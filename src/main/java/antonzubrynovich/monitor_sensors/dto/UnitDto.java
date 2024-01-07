package antonzubrynovich.monitor_sensors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitDto {

    @JsonProperty("unit")
    private String unitName;

    public UnitDto() {
    }

    public UnitDto(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return "UnitDto{" +
                "unitName='" + unitName + '\'' +
                '}';
    }
}