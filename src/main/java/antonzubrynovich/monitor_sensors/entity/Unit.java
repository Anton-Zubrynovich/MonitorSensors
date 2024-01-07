package antonzubrynovich.monitor_sensors.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Objects;


@Entity
@Table(name = "units")
public class Unit {
    @Column(name = "unit_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "unit_name")
    String unitName;


    public Unit(@NonNull String unitName) {
        this.unitName = unitName;
    }


    public Unit( Long id,@NonNull String unitName) {
        this.id = id;
        this.unitName = unitName;
    }

    public Unit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(@NonNull String unitName) {
        this.unitName = unitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(id, unit.id) && Objects.equals(unitName, unit.unitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitName);
    }
}
