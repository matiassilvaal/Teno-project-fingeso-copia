package com.app.tenobackend.repositories;

import com.app.tenobackend.models.Denounce;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenounceRepository {

    int countDenounces();
    List<Denounce> getAllDenounces();

    Denounce getOneDenounce(String id);
    List<Denounce> getDenouncesByIdRol(String id, String type);

    int insertDenounce(String description, String denunciante, String denounced, String security);

    int updateStateDenounce(String id, String state);
}
