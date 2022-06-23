package com.app.tenobackend.repositories;

import com.app.tenobackend.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    int countUsers();
    List<User> getAllUsers();
    User getOneUser(String id);

    int getIdByCorreo(String correo);
}
