package socNetwork.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socNetwork.entity.User;
import socNetwork.service.impl.UserServiceImpl;
import socNetwork.springSecurity.jwt.JwtProvider;


@RestController
public class AuthController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {


        return userService.addUser(user);
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getName(), request.getPassword());
        String token = jwtProvider.generateToken(user.getName());
        return new AuthResponse(token);
    }


}
