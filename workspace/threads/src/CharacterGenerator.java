public class CharacterGenerator implements Runnable{
    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'z'; ch++) {
            System.out.println(Thread.currentThread() + " : " + ch);
        }
    }
}
