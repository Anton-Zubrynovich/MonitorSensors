package antonzubrynovich.monitor_sensors.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Entity
@Table(name = "types")
public class Type {
    @Column(name = "type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;
    @Column(name = "type_name")
    @NonNull
    String typeName;


    public Type( Long typeId,@NonNull String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }



    public Type(@NonNull String typeName) {
        this.typeName = typeName;
    }

    public Type() {

    }

    public Long getId() {
        return typeId;
    }

    public void setId(Long typeId) {
        this.typeId = typeId;
    }

    @NonNull
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(@NonNull String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(typeId, type.typeId) && Objects.equals(typeName, type.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName);
    }
}
