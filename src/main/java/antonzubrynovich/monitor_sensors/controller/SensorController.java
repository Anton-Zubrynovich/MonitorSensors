package antonzubrynovich.monitor_sensors.controller;

import antonzubrynovich.monitor_sensors.dto.RangeDto;
import antonzubrynovich.monitor_sensors.util.MapperUtil;
import antonzubrynovich.monitor_sensors.dto.SensorDto;
import antonzubrynovich.monitor_sensors.dto.TypeDto;
import antonzubrynovich.monitor_sensors.dto.UnitDto;
import antonzubrynovich.monitor_sensors.entity.Sensor;
import antonzubrynovich.monitor_sensors.entity.Type;
import antonzubrynovich.monitor_sensors.entity.Unit;
import antonzubrynovich.monitor_sensors.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Tag(name = "Sensor", description = "the Sensor Api")
@RequestMapping("/api")
public class SensorController {

    @Autowired
    private final SensorService service;

    @Autowired
    private ModelMapper modelMapper;


    @Operation(
            summary = "Fetch all sensors in pretty style",
            description = "Fetches all sensor entities and their data from data source in pretty style")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping(value = "/sensors/all", produces = "application/json")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<SensorDto> getAll(){
        List<Sensor> sensors = service.getAllSensors();
        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }

    @Operation(
            summary = "Fetch all sensors in original style",
            description = "Fetches all sensor entities and their data from data source in original style")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation")
    })
    @GetMapping(value = "/sensors/all/original", produces = "application/json")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<Sensor> getAllOriginal(){
        return service.getAllSensors();
    }


    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @Operation(
            summary = "Fetch all sensors with a specific name in pretty style",
            description = "Fetches all sensor entities with a specific name and their data from data source in pretty style")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "successful operation")
    })
    @GetMapping(value = "/sensors/name/{name}", produces = "application/json")
    public List<SensorDto> getByName(@PathVariable String name) {
        List<Sensor> sensors = service.findByName(name);
        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }


    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @Operation(
            summary = "Fetch all sensors with a specific model in pretty style",
            description = "Fetches all sensor entities with a specific model and their data from data source in pretty style")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "203", description = "successful operation")
    })
    @GetMapping(value = "/sensors/model/{model}", produces = "application/json")
    public List<SensorDto> getByModel(@PathVariable String model) {
        List<Sensor> sensors = service.findByModel(model);
        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @Operation(
            summary = "Fetch sensor with a specific name and model in pretty style",
            description = "Fetches sensor entity with a specific name and model and it's data from data source in pretty style")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation")
    })
    @GetMapping( "/sensors/name/model/{name}/{model}")
    public SensorDto getSensorByNameAndModel(@PathVariable("name") String name, @PathVariable("model") String model) {
        Sensor sensor = service.findExact(name, model);
        return this.convertToSensorDto(sensor);
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(
            summary = "Adds a sensor",
            description = "Adds a sensor to the list of sensors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "205", description = "successfully added a sensor"),
    })
    @PostMapping("/sensors")
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return service.addSensor(sensor);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(
            summary = "Update a sensor",
            description = "Updates a sensor from the list of sensors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "206", description = "successfully updated a sensor"),
            @ApiResponse(responseCode = "404", description = "sensor not found"),
            @ApiResponse(responseCode = "500", description = "bad parameters")
    })
    @PutMapping("/sensors/{id}")
    public Sensor updateSensor(@PathVariable("id") long id,@RequestBody Sensor sensor) {
    return service.updateSensor(id, sensor);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(
            summary = "Delete a sensor",
            description = "Deletes a sensor from the list of sensors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "207", description = "successfully updated a sensor"),
            @ApiResponse(responseCode = "404", description = "sensor not found"),
    })
    @DeleteMapping("/sensors/{id}")
    void deleteSensorById(@PathVariable Long id) {
        service.deleteSensor(id);
    }


    public SensorController(SensorService service) {
        this.service = service;
    }

    private SensorDto convertToSensorDto(Sensor sensor) {
        SensorDto sensorDto = modelMapper.map(sensor, SensorDto.class);
        sensorDto.setTypeDto(convertToTypeDto(sensor.getType()));
        sensorDto.setUnitDto(convertToUnitDto(sensor.getUnit()));
        sensorDto.setRangeDto(new RangeDto(sensor.getRangeFrom(), sensor.getRangeTo()));
        return sensorDto;
    }
    private TypeDto convertToTypeDto(Type type) {
        return modelMapper.map(type, TypeDto.class);
    }
    private UnitDto convertToUnitDto(Unit unit) {
        return modelMapper.map(unit, UnitDto.class);
    }
}


