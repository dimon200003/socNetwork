package controller;

import entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/userList")
    public List<User> userList() {

        return userService.getAll();
    }

    @GetMapping("/findByName")
    public User findByName(@RequestParam String name) {
        return userService.getByName(name);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


}
