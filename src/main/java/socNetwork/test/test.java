package socNetwork.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import socNetwork.entity.User;
import socNetwork.repository.UserRepository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
@Service
public class test {
    @Autowired
    private   UserRepository userRepository;
    User user = new User();

    ExampleMatcher matcher = ExampleMatcher.matching()
            .withMatcher("firstName", startsWith())
            .withMatcher("score", exact());

    Example<User> example = Example.of(user, matcher);

    public UserRepository getUserRepository() {
        return userRepository;
    }

}
