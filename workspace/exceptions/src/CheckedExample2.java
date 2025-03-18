import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExample2 {
    public static void main(String[] args) {
        System.out.println("Main starts");

        try {
            callMethod();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main ends");
    }

    private static void callMethod() throws FileNotFoundException{
            FileInputStream fs = new FileInputStream("a.txt");
    }
}
