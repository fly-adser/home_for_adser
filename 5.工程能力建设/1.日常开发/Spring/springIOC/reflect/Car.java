package springIOC.reflect;

public class Car {

    private String brand;
    private String color;
    private int maxSpeed;

    //1.默认构造函数
    public Car(){
        System.out.println("init car!!");
    }

    //2.带参构造函数
    public Car(String brand, String color, int maxSpeed){
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    //3.为带参方法
    public void introduce(){
        System.out.println("brand:" + brand + "; color:" + color + "; maxSpeed:" + maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
