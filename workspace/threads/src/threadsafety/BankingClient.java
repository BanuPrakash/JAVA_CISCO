package threadsafety;

public class BankingClient {
    public static void main(String[] args) {
        Account account = new Account(5000);
        TransactionThread t1 = new TransactionThread(account, "Divya", TransactionType.CREDIT, 2500);
        TransactionThread t2 = new TransactionThread(account, "\tRajesh", TransactionType.CREDIT, 3000);
        TransactionThread t3 = new TransactionThread(account, "\t\tRia", TransactionType.DEBIT, 2000);

        t1.start();
        t2.start();
        t3.start();

        try {
            // Barrier
            // main has to wait till t1 completes
            t1.join();
            // main has to wait till t2 completes
            t2.join();
            // main has to wait till t3 completes
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final Balance : " + account.getBalance()); // main thread

    }
}
