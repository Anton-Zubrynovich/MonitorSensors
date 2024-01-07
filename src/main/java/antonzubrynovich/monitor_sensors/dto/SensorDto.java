package antonzubrynovich.monitor_sensors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@JsonPropertyOrder({"name", "model", "range"})
public class SensorDto {
    private String name;
    private String model;


    @JsonProperty("range")
    private RangeDto rangeDto;
    @JsonUnwrapped
    private TypeDto typeDto;


    @JsonUnwrapped
    private UnitDto unitDto;
    private String location;
    private String description;

    public SensorDto(){}

    public SensorDto(String name, String model, RangeDto rangeDto,TypeDto typeDto, UnitDto unitDto, String location, String description) {
        this.name = name;
        this.model = model;
        this.rangeDto = rangeDto;
        this.typeDto = typeDto;
        this.unitDto = unitDto;
        this.location = location;
        this.description = description;
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

    public RangeDto getRangeDto() {
        return rangeDto;
    }

    public void setRangeDto(RangeDto rangeDto) {
        this.rangeDto = rangeDto;
    }

    public TypeDto getTypeDto() {
        return typeDto;
    }

    public void setTypeDto(TypeDto typeDto) {
        this.typeDto = typeDto;
    }

    public UnitDto getUnitDto() {
        return unitDto;
    }

    public void setUnitDto(UnitDto unitDto) {
        this.unitDto = unitDto;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SensorDto{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", rangeDto=" + rangeDto +
                ", typeDto=" + typeDto +
                ", unitDto=" + unitDto +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
