package com.app.tenobackend.repositories;

import com.app.tenobackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository{
    @Autowired
    private Sql2o sql2o;

    public UserRepositoryImp(Sql2o conn){
        this.sql2o = conn;
    }
    @Override
    public int countUsers() {
        Integer total = 0;
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) From users").executeScalar(Integer.class);
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
    public List<User> getAllUsers(){
        final String query = "select * from users";
        final List<User> diplomas;

        Connection conn = sql2o.open();
        try (conn){
            diplomas = conn.createQuery(query).executeAndFetch(User.class);
            return diplomas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        finally{
            conn.close();
        }
    }

    @Override
    public User getOneUser(String id){
        final String query = "select * from users where `id` ="+id;
        final User diploma;

        Connection conn = sql2o.open();
        try (conn){
            diploma = conn.createQuery(query).executeAndFetchFirst(User.class);
            return diploma;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getIdByCorreo(String correo){
        final String query = "select * from users where correo ="+correo;

        Connection conn = sql2o.open();
        try (conn){
            return conn.createQuery(query).executeAndFetchFirst(User.class).getId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
