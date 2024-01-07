package antonzubrynovich.monitor_sensors.util;

import antonzubrynovich.monitor_sensors.entity.Sensor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<Range, Sensor> {

    @Override
    public void initialize(Range constraintAnnotation) {
    }

    @Override
    public boolean isValid(Sensor sensor, ConstraintValidatorContext context) {
        if (sensor == null){
            return true;
        }
        return sensor.getRangeFrom() < sensor.getRangeTo();
    }
}