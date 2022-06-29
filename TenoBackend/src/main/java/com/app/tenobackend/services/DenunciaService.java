package com.app.tenobackend.services;

import java.util.List;
import com.app.tenobackend.models.Denounce;
import com.app.tenobackend.repositories.DenounceRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "denounces")

public class DenunciaService {

    private final DenounceRepository denounceRepository;
    DenunciaService(DenounceRepository denounceRepository){
        this.denounceRepository = denounceRepository;
    }

    @GetMapping("/count")
    public String contDenounces(){
        int total = denounceRepository.countDenounces();
        return String.format("Tienes en total %s denuncias", total);
    }

    @GetMapping("/get-all")
    public List<Denounce> getAllDiploma(){
        return denounceRepository.getAllDenounces();
    }
    @GetMapping("/get-by-idrol")
    @ResponseBody
    public List<Denounce> getDenounceByRol(@RequestParam String id, String type){
        return denounceRepository.getDenouncesByIdRol(id, type);
    }

    @GetMapping("/get-by-id")
    @ResponseBody
    public Denounce getOneDiploma(@RequestParam String id){
        return denounceRepository.getOneDenounce(id);
    }

    /*
    * Formato de ingreso de insert:
    * .../denounces/insert?descripcion={descripcion}&denunciante='{correo denunciante}'&denunciado='{correo denunciado}'
    *
    * Consideraciones: Es necesario que cada dato ingresado esté entre comillas, por algún motivo sin eso mysql lo
    * rechaza :)
    *
    * Se establece codigos de validez
    * 0 : correcto ingreso
    * 1: error en correo denunciante
    * 2: error en correo denunciado
    * -1: error al ingreso en la base de datos
    **/
    @PostMapping("/insert")
    @ResponseBody
    int insertDenounce(@RequestParam String description, String denunciante, String denounced){
        return denounceRepository.insertDenounce(description, denunciante, denounced);
    }

    /*
     * Formato de ingreso de insert:
     * .../denounces/updatedenounce?id={id de la denuncia}&state={nuevo estado}
     *
     * Consideracions: por algún motivo no es necesario ingresar entre comillas los textos :D
     *                 los estados aceptados solo son : asignado y finalizado, en caso de
     *                 ingresar alguno distinto se retornará el código 1
     *
     * Se establece codigos de validez
     * 1 : error al ingresar estado
     * 0 : correcta actualización
     * -1: error al ingreso en la base de datos
     * */
    @PatchMapping("/update-denounce")
    @ResponseBody
    int updateStateDenounce(@RequestParam String id, String state){
        return denounceRepository.updateStateDenounce(id, state);
    }
}
