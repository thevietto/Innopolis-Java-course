public class Toyota extends Car {

    public Toyota(String name) {
        super(name);
    }

    @Override
    public void lightOn() {
        System.out.println("toyota lights ON!");
    }

    @Override
    public boolean equals(Object obj) {
        return getName().equals(((Car) obj).getName());
    }
}
