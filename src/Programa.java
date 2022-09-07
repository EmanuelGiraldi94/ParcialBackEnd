import java.sql.Connection;
import java.sql.DriverManager;

public class Programa {

    public static void main(String[] args) {

        Connection connection= null;

        try {

            Class.forName("org.h2.Driver");
            connection= DriverManager.getConnection("jdbc:h2:~/Parcial1;INIT=RUNSCRIPT " +
                    "FROM 'create.sql'", "as", "as");

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
    }
}
