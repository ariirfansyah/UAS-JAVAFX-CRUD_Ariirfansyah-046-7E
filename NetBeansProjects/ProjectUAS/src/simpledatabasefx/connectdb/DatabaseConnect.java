
package simpledatabasefx.connectdb;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author arief
 */
public class DatabaseConnect {
    private static Connection connect;
    public static Connection tryConnect()
    {
            if(connect == null)
        {
            try {
                String url  ="jdbc:mysql://localhost:3306/universitas";
                String user = "root";
                String pass = "";
           
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connect = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
            //Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("WARNING: Can not create connection!");
            }
        }
         return connect;
   
    }
}