import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExample3 {
    // propagated to DefaultHandler
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Main starts");
        callMethod();
        System.out.println("Main ends");
    }

    private static void callMethod() throws FileNotFoundException {
            FileInputStream fs = new FileInputStream("a.txt");

    }
}
