
package prtype;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class DBconnection {
    public static Connection connect(){
        Connection connect = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        return connect;
    }
    
}
