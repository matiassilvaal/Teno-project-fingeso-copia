package com.app.tenobackend.repositories;

import com.app.tenobackend.models.Denuncia;
import com.app.tenobackend.models.User;
import com.app.tenobackend.repositories.UserRepository;
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
            total = conn.createQuery("SELECT COUNT(*) From denuncias").executeScalar(Integer.class);
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
        final String query = "select * from denuncias";
        final List<Denuncia> diplomas;

        Connection conn = sql2o.open();
        try (conn){
            diplomas = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return diplomas;
        } catch (Exception e) {
            System.out.println("Esta ocurriendo un error\n");
            System.out.println(e.getMessage());
            return null;
        }
        finally{
            conn.close();
        }
    }
    @Override
    public Denuncia getOneDenuncia(String id){
        final String query = "select * from denuncias where `id` ="+id;
        final Denuncia diploma;

        Connection conn = sql2o.open();
        try (conn){
            diploma = conn.createQuery(query).executeAndFetchFirst(Denuncia.class);
            return diploma;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Denuncia> getDenunciasByIdRol(String id, String type) {
        final String query;
        if (type.equals("fiscal")) {
            query = "select * from denuncias where `idfiscal` =" + id;
        } else if (type.equals("denunciante")) {
            query = "select * from denuncias where `iddenunciante` =" + id;
        } else if (type.equals("denunciado")) {
            query = "select * from denuncias where `iddenunciado` =" + id;
        } else {
            System.out.println("No se ingreso una adecuada lectura");
            return null;
        }
        final List<Denuncia> diplomas;

        Connection conn = sql2o.open();
        try (conn) {
            diplomas = conn.createQuery(query).executeAndFetch(Denuncia.class);
            return diplomas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

        /*
        * Se establece codigos de validez
        * 0 : correcto ingreso
        * 1: error en correo denunciante
        * 2: error en correo denunciado
        * -1: error al ingreso en la base de datos
        * */
        public int insertDenuncia(String descripcion, String denunciante, String denunciado){
            Connection conn = sql2o.open();
            int total = countDenuncias();
            final UserRepositoryImp getter = new UserRepositoryImp(sql2o);
            Integer iddenunciante = getter.getIdByCorreo(denunciante);
            if(iddenunciante == -1){
                return 1;
            }
            Integer iddenunciado = getter.getIdByCorreo(denunciado);
            if(iddenunciado == -1){
                return 2;
            }

            final String query = "insert into denuncias (id, iddenunciante, iddenunciado, idfiscal, descripcion, state)"+
                    "values (:id, :iddenunciante, :iddenunciado, :idfiscal, :descripcion, :state)";

            try (conn) {
                conn.createQuery(query)
                        .addParameter("id",total)
                        .addParameter("iddenunciante",iddenunciante)
                        .addParameter("iddenunciado",iddenunciado)
                        .addParameter("idfiscal",-1)
                        .addParameter("descripcion",descripcion)
                        .addParameter("state","ingresado")
                        .executeUpdate();
                return 0;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }
}
