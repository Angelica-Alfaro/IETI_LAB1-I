package edu.eci.users.controller;

import edu.eci.users.data.User;
import edu.eci.users.dto.UserDto;
import edu.eci.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController( @Autowired UserService userService ) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all() {
        try {
            return ResponseEntity.ok().body(userService.all());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById( @PathVariable String id ) {
        try {
            return ResponseEntity.ok().body(userService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
        try{
            User newUser = new User (userDto.getName(), userDto.getEmail(), userDto.getLastName());
            return ResponseEntity.ok().body(userService.create(newUser));
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        try{
            User newUser = new User (userDto.getName(), userDto.getEmail(), userDto.getLastName());
            return ResponseEntity.ok().body(userService.update(newUser, id));
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try {
            userService.deleteById(id);
            return ResponseEntity.ok().body(true);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
