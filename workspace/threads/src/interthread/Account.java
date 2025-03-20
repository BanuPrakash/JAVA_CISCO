package interthread;

public class Account {
    private double balance; //heap area, shared by threads, not thread-safe

    public Account(double balance) {
        this.balance = balance;
    }

    // multiple threads can access this
    public double getBalance() {
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return balance;
    }

    public void setBalance(double balance) {
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance = balance;
    }

    public synchronized  void deposit(String name, double amt) {
        System.out.println(name + " depositing ");
        System.out.println(name + " getting balance ");
        double bal = getBalance();
        System.out.println(name + " got balance " + bal);
        bal += amt;
        System.out.println(name + " setting balance  " + bal);
        setBalance(bal);

        notifyAll();
    }

    public synchronized void withdraw(String name, double amt) {
        System.out.println(name + " withdrawing ...");
        System.out.println(name + " getting balance ");
        while(getBalance() < amt) {
            System.out.println("Insufficient balance!!! " + getBalance());
            try {
                wait(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        double bal = getBalance();
        System.out.println(name + " got balance " + bal);
        bal -= amt;
        System.out.println(name + " setting balance  " + bal);
        setBalance(bal);
    }
}
