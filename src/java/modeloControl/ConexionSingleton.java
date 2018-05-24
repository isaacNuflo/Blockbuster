package modeloControl;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSingleton {

    private static Connection _connection;

    private ConexionSingleton(String name_db, String host, String user, String password) {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver).newInstance();
            _connection = DriverManager.getConnection("jdbc:mysql://"+host+":3306/" + name_db, user, password);
        } catch (Exception e) {
            System.out.println("Error Duplicado el objeto _connection" + e.getMessage());
            e.printStackTrace();
        }

    }

    public static Connection getConexion(String name_db, String host, String user, String password) {

        if (_connection == null) {
            new ConexionSingleton(name_db,host,user,password);
        }
        return _connection;
    }
}
