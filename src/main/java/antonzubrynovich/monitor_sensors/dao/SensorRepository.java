package antonzubrynovich.monitor_sensors.dao;


import antonzubrynovich.monitor_sensors.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByNameContaining(String sensorName);
    List<Sensor> findByModelContaining(String sensorModel);
    Optional<Sensor> findByNameAndModelContaining(String sensorName, String sensorModel);
    Optional<Sensor> findById(Long id);
    void deleteSensorById(Long id);

}