public abstract class Vehicle {
    private String company;
    private String model;
    private int yearRelease;
    private int numWheels;
    private int speed;

    public abstract short testDrive();

    public abstract void park();
}
