package u01.devices;

/**
 * An interface modelling a Device, which can be on/off.
 * It can also be non-working, meaning it is off and cannot be switched one.
 */
public interface Device {

    /**
     * Switches the device on
     */
    void on();

    /**
     * Switches the device off
     */
    void off();

    /**
     * @return whether the device is on
     */
    boolean isOn();

    /**
     * @return whether the device is actually working
     */
    boolean isWorking();
}