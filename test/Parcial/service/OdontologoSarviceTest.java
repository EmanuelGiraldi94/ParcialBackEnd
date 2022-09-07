package Parcial.service;

import Parcial.dao.OdontologoDAOH2;
import Parcial.model.Odontologo;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class OdontologoSarviceTest {


    @Test
    @Order(1)

    public void guardar() {

        Connection connection=null;

        try {
            Class.forName("org.h2.Driver");
            connection= DriverManager.getConnection("jdbc:h2:~/Parcial1;INIT=RUNSCRIPT FROM " +
                    "'create.sql'", "as", "as");
        }

        catch (Exception e){

            e.printStackTrace();
        }

        finally {
            try {
                connection.close();
            }
            catch (Exception ex){

                ex.printStackTrace();
            }
        }

        Odontologo OdontologoAguardar= new Odontologo(325478,"Carlos", "Rocha");
        OdontologoSarvice odontologoSarvice=new OdontologoSarvice(new OdontologoDAOH2());

        odontologoSarvice.guardarOdontologo(OdontologoAguardar);


    }


   @Test
   @Order(2)
    public void ListarOdontologos(){

       OdontologoSarvice odontologoSarvice=new OdontologoSarvice(new OdontologoDAOH2());

       List<Odontologo> odontologoList = odontologoSarvice.listarTodo();

       for (Odontologo o:odontologoList){

           System.out.println(o.getNombre());
       }

       assertTrue(odontologoList.size()>0);

   }



}