package antonzubrynovich.monitor_sensors.service;

import antonzubrynovich.monitor_sensors.entity.Sensor;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.annotation.Secured;

public interface SensorService {

    List<Sensor> getAllSensors();

    Sensor addSensor(Sensor sensor);
    List<Sensor> findByName(String sensorName);
    Sensor findById(Long id);
    List<Sensor> findByModel(String sensorName);
    Sensor findExact(String sensorName, String sensorModel);
    void deleteSensor(Long id);
    Sensor updateSensor(Long Id, Sensor sensor);

}
