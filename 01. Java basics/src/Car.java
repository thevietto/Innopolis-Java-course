public abstract class Car {

    private int year;
    private String name;
    private String model;

    public static int count = 0;

    public Car(int y, String name, String model) {
        year = y;
        this.name = name;
        this.model = model;
        count++;
    }

    public Car(String name) {
        this(1994, name, "bmw");
    }


    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract void lightOn();
}
