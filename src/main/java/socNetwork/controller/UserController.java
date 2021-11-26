package socNetwork.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socNetwork.entity.User;
import socNetwork.service.impl.UserServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
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



    @GetMapping("/")
    CollectionModel<EntityModel<User>> findUser(@RequestBody User user,
                                                @RequestParam(required = false) Integer page,
                                                @RequestParam(required = false) Integer size) {

        Page<EntityModel<User>> pages = new PageImpl<>(userService.getAll1(PageRequest.of(page, size)).stream().map(user1 -> EntityModel.of(user1,
                        linkTo(methodOn(UserServiceImpl.class).findByName(user.getName())).withSelfRel()))
                .collect(Collectors.toList()), PageRequest.of(page, size), 1);

        return CollectionModel.of(pages, linkTo(methodOn(UserController.class).findUser(user, page, size)).withRel("users"));
    }

    @GetMapping("/userList")
    public List<User> userList() {
        User user = new User();

        user.add(linkTo(methodOn(UserController.class).findByName(user.getName())).withSelfRel());


        return userService.getAll();
    }


    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {

        User user1 = userService.addUser(user);
        user1.add(linkTo(methodOn(UserController.class).saveUser(user)).withSelfRel());

        return user1;
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
    @PostMapping("/test1")
    public User editUser1(@PathVariable String name, @RequestBody User user) {
        User user1 = userService.findByName(name);
        user1 = userService.editUser(user);

        return user1;
    }

    @GetMapping("/test/{name}")
    public HttpEntity<User> greeting(
            @PathVariable String name) {

        User user = userService.findByName(name);


        user.add(linkTo(methodOn(UserController.class).greeting(name)).withSelfRel());


        return new ResponseEntity<>(user, HttpStatus.OK);
    }



}
