package com.app.tenobackend.repositories;

import com.app.tenobackend.models.Denuncia;
import com.app.tenobackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class DenunciaRepositoryImp implements DenunciaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countDenuncias() {
        Integer total = 0;
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) From Denuncias").executeScalar(Integer.class);
            return total;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }

        finally{
            conn.close();
        }
    }

    @Override
    public List<Denuncia> getAllDenuncias(){
        final String query = "select * from denuncia";
        final List<Denuncia> diplomas;

        Connection conn = sql2o.open();
        try (conn){
            diplomas = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return diplomas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally{
            conn.close();
        }
    }
}
