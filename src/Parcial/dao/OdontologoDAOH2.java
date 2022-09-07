package Parcial.dao;

import Parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {


    private static final Logger logger=Logger.getLogger(Odontologo.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        logger.info("Se ejecuta el guardado de Odontologo");

        Connection connection= null;

        try {
            connection=getConnection();
            PreparedStatement ps= connection.prepareStatement("INSERT INTO ODONTOLOGOS " +
                    "(MATRICULA, NOMBRE, APELLIDO) VALUES ( ?,?,?)");
            ps.setInt(1,odontologo.getMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3,odontologo.getApelllido());
            ps.execute();

        }

        catch (Exception e){

            e.printStackTrace();
        }

        finally {
            try {
                connection.close();

            }
            catch (Exception ex){

               logger.error("No se pudo cerrar la conexion-"+ex.getMessage());
               ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        logger.info("Se ejecuta el listado de Odontologo");
        Connection connection=null;
        ArrayList<Odontologo> odontologos=new ArrayList<>();

        try {
            connection=getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){

                odontologos.add(new Odontologo(rs.getInt(1),rs.getString(2),
                        rs.getString(3)));
            }
        }

        catch (Exception e){

            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }

            catch (Exception ex){

                logger.error("No se pudo cerrar la conexion-"+ex.getMessage());

                ex.printStackTrace();
            }
        }
        return odontologos;
    }


    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Parcial1", "as", "as");

    }
}
