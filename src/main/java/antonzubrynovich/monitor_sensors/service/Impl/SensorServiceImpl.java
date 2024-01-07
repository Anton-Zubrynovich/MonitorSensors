package antonzubrynovich.monitor_sensors.service.Impl;

import antonzubrynovich.monitor_sensors.entity.Sensor;
import antonzubrynovich.monitor_sensors.service.SensorService;
import antonzubrynovich.monitor_sensors.dao.SensorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private final SensorRepository repository;

    @Override
    public List<Sensor> getAllSensors() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Sensor addSensor(Sensor sensor) {
        return repository.save(sensor);
    }

    @Override
    public List<Sensor> findByName(String sensorName) {
        return repository.findByNameContaining(sensorName);
    }

    @Override
    public Sensor findById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public List<Sensor> findByModel(String sensorModel) {
        return repository.findByModelContaining(sensorModel);
    }

    @Override
    public Sensor findExact(String sensorName, String sensorModel) {
        return repository.findByNameAndModelContaining(sensorName, sensorModel).get();
    }

    @Override
    @Transactional
    public void deleteSensor(Long Id) {
        repository.deleteById(Id);
    }


    @Transactional
    public Sensor updateSensor(Long Id, Sensor sensor) {
        if (Id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        Sensor _sensor = repository.findById(Id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(Id)));
        if (_sensor != null){
            _sensor.setName(sensor.getName());
            _sensor.setModel(sensor.getModel());
            _sensor.setRangeFrom(sensor.getRangeFrom());
            _sensor.setRangeTo(sensor.getRangeTo());
            _sensor.setLocation(sensor.getLocation());
            _sensor.setDescription(sensor.getDescription());
            _sensor.setType(sensor.getType());
            _sensor.setUnit(sensor.getUnit());
        }
        assert _sensor != null;
        return repository.save(_sensor);
    }

    public SensorServiceImpl(SensorRepository repository) {
        this.repository = repository;
    }
}

