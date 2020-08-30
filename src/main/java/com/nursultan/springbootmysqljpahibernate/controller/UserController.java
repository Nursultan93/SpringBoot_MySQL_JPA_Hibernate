package com.nursultan.springbootmysqljpahibernate.controller;

import com.nursultan.springbootmysqljpahibernate.entity.User;
import com.nursultan.springbootmysqljpahibernate.exceptions.ResourceNotFoundException;
import com.nursultan.springbootmysqljpahibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable(value = "id") long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found Id :"+id));
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        if (user == null) return null;
        return userRepository.save(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable(value = "id") long id){
        User changeUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found Id :"+id));
        if (changeUser == null) return null;
        changeUser.setFirstName(user.getFirstName());
        changeUser.setLastName(user.getLastName());
        changeUser.setEmail(user.getEmail());

        return userRepository.save(changeUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") long id){
        userRepository.deleteById(id);
    }
}
