package antonzubrynovich.monitor_sensors.service.Impl;


import antonzubrynovich.monitor_sensors.dao.UserRepository;
import antonzubrynovich.monitor_sensors.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import antonzubrynovich.monitor_sensors.service.CustomUserDetails;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public UserDetailsServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username + " not found");
        }
        return new CustomUserDetails(user);
    }

}
