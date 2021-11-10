package socNetwork.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socNetwork.entity.Admin;
import socNetwork.entity.User;
import socNetwork.service.impl.AdminServiceImpl;
import socNetwork.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminServiceImpl adminService;

    private final UserServiceImpl userService;

    @GetMapping("/adminList")
    public List<Admin> adminList() {

        return adminService.getAll();
    }



    @PostMapping("/saveAdmin")
    public Admin saveAdmin(@RequestBody Admin admin){

        return adminService.addAdmin(admin);
    }

    @GetMapping("/findByLogin")
    public Admin findByLogin(@RequestParam String adminLogin) {

        return adminService.getByName(adminLogin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
        adminService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/editAdmin")
    public Admin editAdmin(@RequestBody Admin admin) {
        return adminService.editAdmin(admin);
    }

    @GetMapping("/userList")
    public List<User> userList() {

        return userService.getAll();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/editUser")
    public User editUser(@RequestBody User user) {
        return userService.editUser(user);
    }




}
