public class Mercedes extends Car implements Beepable {

    public Mercedes() {
        super(1999, "Mercedes", "e200");
    }

    public void drive() {
        System.out.println("i'm driving");
    }

    @Override
    public void beep() {
        System.out.println("MERSEDES BEEP!");
    }

    @Override
    public void lightOn() {
        System.out.println("mercedes lights on");
    }

}
