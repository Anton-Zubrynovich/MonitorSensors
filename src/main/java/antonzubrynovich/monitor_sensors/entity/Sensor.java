package antonzubrynovich.monitor_sensors.entity;

import antonzubrynovich.monitor_sensors.util.Range;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sensors")
@Range
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@JsonIgnore
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 30, message = "no less then 3 and no more then 30 signs")
    private String name;


    @Column(name = "model")
    @NotNull
    @Size(max = 15, message = "no more then 15 signs")
    private String model;


    @Column(name = "range_from")
    @Positive
    private int rangeFrom;

    @Column(name = "range_to")
    @Positive
    private int rangeTo;

//    @Column(name = "range", columnDefinition = "int4range")
//    private RA range;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn (name="type_id")
    private Type type;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "unit_id")
    private Unit unit;


    @Column(name = "location")
    @Size(max = 40)
    private String location;
    @Column(name = "description")
    @Size(max = 200)
    private String description;

    public Sensor(String name, String model, int rangeFrom, int rangeTo, Type type, Unit unit, String location, String description) {
        this.name = name;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public Sensor() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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


    public int getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(int rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(int rangTo) {
        this.rangeTo = rangTo;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return rangeFrom == sensor.rangeFrom && rangeTo == sensor.rangeTo && Objects.equals(id, sensor.id) && Objects.equals(name, sensor.name) && Objects.equals(model, sensor.model) && Objects.equals(type, sensor.type) && Objects.equals(unit, sensor.unit) && Objects.equals(location, sensor.location) && Objects.equals(description, sensor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, rangeFrom, rangeTo, type, unit, location, description);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", rangeFrom=" + rangeFrom +
                ", rangeTo=" + rangeTo +
                ", type=" + type +
                ", unit=" + unit +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
