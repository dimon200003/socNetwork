package socNetwork.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import socNetwork.entity.RoleEntity;
import socNetwork.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socNetwork.repository.RoleRepository;
import socNetwork.repository.UserRepository;
import socNetwork.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleEntityRepository;



    @Override
    public User addUser(User user) {
        RoleEntity userRole = roleEntityRepository.findByName("ROLE_USER");
        user.setRoleEntity(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("ROLE_USER");
        roleEntity.setId(1);
        userRepository.saveAndFlush(user);
        user.setRoleEntity(roleEntity);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Page<User> getAll1(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findByName(String name) {
        return userRepository.findUserByName(name);
    }

    public User findByAge(int age){return userRepository.findUsersByAge(age);}

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
