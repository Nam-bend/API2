package org.ailbles.demo4.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{id}")
public Optional<User> getUserById(@PathVariable Long id ){
        return userService.getUserById(id);
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);

    }
@PutMapping("/{id}")
public Optional<User> updateUser(@PathVariable Long id , @RequestBody User updateUser ){
    return userService.updateUser(id,updateUser);
}
 @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
 }
}
