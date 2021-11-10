package socNetwork.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import socNetwork.entity.User;
import socNetwork.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.getByName(name);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}