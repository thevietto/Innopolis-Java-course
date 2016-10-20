public abstract class Car implements Comparable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        return model != null ? model.equals(car.model) : car.model == null;

    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return ((Car) o).getName().compareTo(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
