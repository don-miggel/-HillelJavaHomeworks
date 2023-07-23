package builder;

public class Transmission {
    private final int speedNumber;
    private final TransmissionType transmissionType;

    public Transmission(TransmissionType transmissionType, int speedNumber){
        this.speedNumber = speedNumber;
        this.transmissionType = transmissionType;
    }

    public int getSpeedNumber() {
        return speedNumber;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "speedNumber=" + speedNumber +
                ", transmissionType=" + transmissionType +
                '}';
    }
}
