package com.app.tenobackend.services;

import java.util.List;
import com.app.tenobackend.models.Denuncia;
import com.app.tenobackend.models.User;
import com.app.tenobackend.repositories.DenunciaRepository;
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
    public String contDenuncias(){
        int total = denunciaRepository.countDenuncias();
        return String.format("Tienes en total %s denuncias", total);
    }

    @GetMapping("/getall")
    public List<Denuncia> getAllDiploma(){
        return denunciaRepository.getAllDenuncias();
    }
    @GetMapping("/getbyidrol")
    @ResponseBody
    public List<Denuncia> getDenunciasByRol(@RequestParam String id, String type){
        return denunciaRepository.getDenunciasByIdRol(id, type);
    }

    @GetMapping("/getbyid")
    @ResponseBody
    public Denuncia getOneDiploma(@RequestParam String id){
        return denunciaRepository.getOneDenuncia(id);
    }

    @GetMapping("/insert")
    @ResponseBody
    int insertDenuncia(@RequestParam String descripcion, String denunciante, String denunciado){
        return denunciaRepository.insertDenuncia(descripcion, denunciante, denunciado);
    }
}
