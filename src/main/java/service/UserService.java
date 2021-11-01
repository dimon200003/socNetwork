package service;

import entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(int id);
    User getByName(String name);
    User editUser(User user);
    List<User> getAll();
}
