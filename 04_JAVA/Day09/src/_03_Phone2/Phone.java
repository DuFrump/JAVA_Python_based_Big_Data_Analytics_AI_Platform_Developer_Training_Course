package _03_Phone2;

public interface Phone {
    public static final int MAX_BATTERY_CAPACITY = 100;

    abstract void powerOn();
    abstract void powerOff();
    abstract boolean isOn();
    abstract void watchYouTube();
    abstract void charge();
}
