package com.app.tenobackend.services;

import java.util.List;
import com.app.tenobackend.models.Denuncia;
import com.app.tenobackend.models.User;
import com.app.tenobackend.repositories.DenunciaRepository;
import com.app.tenobackend.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "denuncias")

public class DenunciaService {

    private final DenunciaRepository denunciaRepository;
    DenunciaService(DenunciaRepository denunciaRepository){
        this.denunciaRepository = denunciaRepository;
    }

    @GetMapping("/count")
    public String contUsers(){
        int total = denunciaRepository.countDenuncias();
        return String.format("Tienes en total %s usuarios", total);
    }

    @GetMapping("/getall")
    public List<Denuncia> getAllDiploma(){
        return denunciaRepository.getAllDenuncias();
    }


}
