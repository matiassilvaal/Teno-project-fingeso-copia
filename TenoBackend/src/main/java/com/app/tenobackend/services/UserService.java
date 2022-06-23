package com.app.tenobackend.services;

import java.util.List;
import com.app.tenobackend.models.User;
import com.app.tenobackend.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "users")

public class UserService {

    private final UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/count")
    public String contUsers(){
        int total = userRepository.countUsers();
        return String.format("Tienes en total %s usuarios", total);
    }

    @GetMapping("/getall")
    public List<User> getAllDiploma(){
        return userRepository.getAllUsers();
    }

    @GetMapping("/getbyid")
    @ResponseBody
    public User getOneDiploma(@RequestParam String id){
        return userRepository.getOneUser(id);
    }
}
