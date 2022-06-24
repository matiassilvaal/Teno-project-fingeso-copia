package com.app.tenobackend.repositories;

import com.app.tenobackend.models.Denounce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class DenounceRepositoryImp implements DenounceRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countDenounces() {
        Integer total = 0;
        Connection conn = sql2o.open();
        try(conn){
            total = conn.createQuery("SELECT COUNT(*) From denounces").executeScalar(Integer.class);
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
    public List<Denounce> getAllDenounces(){
        final String query = "select * from denounces";
        final List<Denounce> diplomas;

        Connection conn = sql2o.open();
        try (conn){
            diplomas = conn.createQuery(query).executeAndFetch(Denounce.class);
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
    public Denounce getOneDenounce(String id){
        final String query = "select * from denounces where `id` ="+id;
        final Denounce diploma;

        Connection conn = sql2o.open();
        try (conn){
            diploma = conn.createQuery(query).executeAndFetchFirst(Denounce.class);
            return diploma;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally{
            conn.close();
        }
    }

    @Override
    public List<Denounce> getDenouncesByIdRol(String id, String type) {
        final String query;
        if (type.equals("fiscal")) {
            query = "select * from denounces where idfiscal =" + id;
        } else if (type.equals("denunciante")) {
            query = "select * from denounces where iddenunciante =" + id;
        } else if (type.equals("denunciado")) {
            query = "select * from denounces where iddenounced =" + id;
        } else {
            System.out.println("No se ingreso una adecuada lectura");
            return null;
        }
        final List<Denounce> diplomas;

        Connection conn = sql2o.open();
        try (conn) {
            diplomas = conn.createQuery(query).executeAndFetch(Denounce.class);
            return diplomas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        finally{
            conn.close();
        }
    }

    /*
    * Se establece codigos de validez
    * 0 : correcto ingreso
    * 1: error en correo denunciante
    * 2: error en correo denunciado
    * -1: error al ingreso en la base de datos
    * */
    public int insertDenounce(String description, String denunciante, String denounced){
        Connection conn = sql2o.open();
        int total = countDenounces();
        final UserRepositoryImp getter = new UserRepositoryImp(sql2o);
        Integer iddenunciante = getter.getIdByCorreo(denunciante);
        if(iddenunciante == -1){
            return 1;
        }
        Integer iddenunciado = getter.getIdByCorreo(denounced);
        if(iddenunciado == -1){
            return 2;
        }

        final String query = "insert into denounces (id, iddenunciante, iddenounced, idfiscal, description, state)"+
                "values (:id, :iddenunciante, :iddenounced, :idfiscal, :description, :state)";

        try (conn) {
            conn.createQuery(query)
                    .addParameter("id",total)
                    .addParameter("iddenunciante",iddenunciante)
                    .addParameter("iddenounced",iddenunciado)
                    .addParameter("idfiscal",-1)
                    .addParameter("description",description)
                    .addParameter("state","ingresado")
                    .executeUpdate();
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally{
            conn.close();
        }
    }

    /*
     * Se establece codigos de validez
     * 1 : error al ingresar estado
     * 0 : correcta actualización
     * -1: error al ingreso en la base de datos
     * */
    public int updateStateDenounce(String id, String state){
        if(!state.equals("asignado") && !state.equals("finalizado")){
            return 1;
        }

        final String query = "update denounces set state = :state where id = :id";

        Connection conn = sql2o.open();

        try (conn) {
            conn.createQuery(query)
                    .addParameter("state",state)
                    .addParameter("id",id)
                    .executeUpdate();
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

        finally{
            conn.close();
        }
    }
}
