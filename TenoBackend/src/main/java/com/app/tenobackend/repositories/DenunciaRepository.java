package com.app.tenobackend.repositories;

import com.app.tenobackend.models.Denuncia;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Repository
public interface DenunciaRepository {

    int countDenuncias();
    List<Denuncia> getAllDenuncias();

    Denuncia getOneDenuncia(String id);
    List<Denuncia> getDenunciasByIdRol(String id, String type);

    int insertDenuncia(String descripcion, String denunciante, String denunciado);
}
