package Parcial.dao;

import Parcial.model.Domicilio;

import java.sql.*;
import java.util.List;



public class DomicilioDAOH2 implements IDao<Domicilio> {


    @Override
    public Domicilio guardar(Domicilio domicilio) {

        Connection connection= null;

        try {

            connection=getConnection();
            PreparedStatement ps= connection.prepareStatement("INSERT INTO DOMICILIOS " +
                            "(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3,domicilio.getLocalidad());
            ps.setString(4,domicilio.getProvincia());
            ps.execute();
            ResultSet key=ps.getGeneratedKeys();
            while(key.next()){
                domicilio.setId(key.getInt(1));
            }

        }
        catch (Exception e){

            e.printStackTrace();
        }
     }

    @Override
    public Domicilio buscar(int id) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Domicilio> listar() {
        return null;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Parcial1", "as", "as");
    }
}
