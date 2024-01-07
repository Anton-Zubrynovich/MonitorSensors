package antonzubrynovich.monitor_sensors.dao;

import java.util.Optional;
import antonzubrynovich.monitor_sensors.entity.Role;
import antonzubrynovich.monitor_sensors.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);
}
