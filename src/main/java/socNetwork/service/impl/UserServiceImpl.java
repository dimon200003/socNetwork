package socNetwork.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import socNetwork.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socNetwork.repository.UserRepository;
import socNetwork.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public User addUser(User user) {
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User findByLoginAndPassword(String name, String password) {
        User user = getByName(name);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return user;
    }

}