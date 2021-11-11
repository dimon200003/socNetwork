package socNetwork.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socNetwork.entity.User;
import socNetwork.service.impl.UserServiceImpl;


import java.util.List;


import static org.hibernate.sql.Template.TEMPLATE;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {


    private final UserServiceImpl userService;

    @GetMapping("/get")
    public String getUser(){
        return "Hi user!";
    }

    @GetMapping("/userList")
    public List<User> userList() {

         return userService.getAll();
    }


    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {

        return userService.addUser(user);
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

    @PostMapping("/edit")
    public User editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @RequestMapping("/test")
    public HttpEntity<User> greeting(
            @RequestParam(value = "name", defaultValue = "Word") String name) {

        User user = new User(String.format(TEMPLATE, name));
        user.add(linkTo(methodOn(UserController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }



}
