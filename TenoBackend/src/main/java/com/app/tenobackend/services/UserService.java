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

    @GetMapping("/get-all")
    public List<User> getAllDiploma(){
        return userRepository.getAllUsers();
    }

    @GetMapping("/get-by-id")
    @ResponseBody
    public User getOneDiploma(@RequestParam String id){
        return userRepository.getOneUser(id);
    }
    @GetMapping("/get-id-by-correo")
    @ResponseBody
    public int getIdByCorreo(@RequestParam String correo){
        return userRepository.getIdByCorreo(correo);
    }
}
