import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Exceptions {

    public static void main(String[] args) {

        try {
            some();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        testFinally();

//        try with resources

        try (InputStream stream = new BufferedInputStream(System.in)){

        } catch (IOException e) {
            e.printStackTrace();
        }

//        String a = "dd";
//        switch (a) {
//            case "aa":
//
//        }

    }

    public static void some() throws MyException {
        throw new MyException();
    }

    public static void testFinally() {
        try {
            int a = 5 / 0;
        } catch (Exception e) {
            System.out.println("division by zero catched!");
            return;
        } finally {
            System.out.println("FINALLY I AM HERE!");
        }
        System.out.println("i am after return");
    };

}

class MyException extends Exception {
    @Override
    public String getMessage() {
        return "MY SUPER EXCEPTION";
    }
}
