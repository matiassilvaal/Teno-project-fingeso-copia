package com.app.tenobackend.repositories;

import com.app.tenobackend.models.Denuncia;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DenunciaRepository {

    int countDenuncias();
    List<Denuncia> getAllDenuncias();
}
