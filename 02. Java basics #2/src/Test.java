
public class Test implements Beepable, TestInterface {


    @Override
    public void beep() {
        System.out.println("test beep");
    }

    @Override
    public void testMethod() {
        System.out.println("test m");
    }
}
