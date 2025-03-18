import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExample1 {
    public static void main(String[] args) {
        System.out.println("Main starts");
        callMethod();
        System.out.println("Main ends");
    }

    private static void callMethod() {
        // try to open a file "a.txt"
        try {
            FileInputStream fs = new FileInputStream("a.txt");
            // other lines of code
        } catch (FileNotFoundException e) {
            System.out.println("Problem occured in opening file!!");
        }
    }
}
