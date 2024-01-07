package antonzubrynovich.monitor_sensors.dto;

public class RangeDto {
    private int from;
    private int to;

    public RangeDto(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public RangeDto() {
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "RangeDto{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
