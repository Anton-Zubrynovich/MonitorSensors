package antonzubrynovich.monitor_sensors.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeDto {


    @JsonProperty("type")
    private String typeName;

    public TypeDto() {
    }

    public TypeDto(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeDto{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
