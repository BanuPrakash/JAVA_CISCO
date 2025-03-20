package threadsafety;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

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

    public void deposit(String name, double amt) {
        System.out.println(name + " depositing ");
        System.out.println(name + " getting balance ");
        double bal = getBalance();
        System.out.println(name + " got balance " + bal);
        bal += amt;
        System.out.println(name + " setting balance  " + bal);
        setBalance(bal);
    }

    public void withdraw(String name, double amt) {
        System.out.println(name + " withdrawing ...");
        System.out.println(name + " getting balance ");
        double bal = getBalance();
        System.out.println(name + " got balance " + bal);
        bal -= amt;
        System.out.println(name + " setting balance  " + bal);
        setBalance(bal);
    }
}
