package prtype;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import prtype.DBconnection;

public class validations {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public static boolean check=false;
   
    public static int truecount=0;

    public validations() {
        con = DBconnection.connect();
    }

    public boolean vcus(String name) {
        boolean con1 = false;
        if (name.isEmpty()) {
            con1 = false;
            JOptionPane.showMessageDialog(null, "One or more fields are empty");

            return con1;

        } else {
            return true;
        }
    }

    public boolean vnum(String number) {
        boolean c = false;

        return c;
    }

    public boolean custname(String name) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty", "ERROR in name field", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean address(String address) {
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Address cannot be empty", "ERROR in address field", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean phone(String phn) {
        if (phn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone number cannot be empty", "ERROR in Phone number field", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean nicpp(String nicpp) {
        if (nicpp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NIC/PP cannot be empty", "ERROR in NIC/PP field", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public boolean date(String idate, String odate) {
        if (idate.isEmpty() || odate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill the date fields", "ERROR in datefields", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean roomNO(String room) {

        if (room.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Room No cannot be empty", "ERROR in ROOMNO field", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            int Room = Integer.parseInt(room);
            if (Room >= 200 && Room <= 220) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "You have only 200-220 Room numbers", "Invalid room Number!", JOptionPane.WARNING_MESSAGE);
                return false;
            }

        }
    }

    public boolean Headcount(String count) {

        if (count.isEmpty()) {
            JOptionPane.showMessageDialog(null, "head count cannot be empty", "ERROR in Head Count field", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            int Count = Integer.parseInt(count);
            if (Count >= 1 && Count <= 20) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "You have only 20 Rooms", "Wrong Room Count!", JOptionPane.WARNING_MESSAGE);
                return false;
            }

        }
    }

    public boolean validateUser(String user, String pass) {

        String passwrd;
        boolean status = false;

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill details", "ERROR!", JOptionPane.WARNING_MESSAGE);
            status = false;

        } else {
            try {

                String sql = "SELECT password FROM users WHERE username='" + user + "'";
                pst = con.prepareStatement(sql);

                rs = pst.executeQuery();

                while (rs.next()) {
                    passwrd = rs.getString("password");

                    if (passwrd.equals(pass)) {
                        status = true;
                        
                        

                    }
                }
            } catch (Exception e) {
            }
            
        }

        return status;
    }
    
    public static boolean emptyCheck(String che)
    {
        
        
        if(che.trim().isEmpty()){
            check=false;
             return check;
            
        }
      
        else
            truecount ++;
            return true;
    }
    
    public boolean namevalidate(String name){
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"FILL THE NAME FIELD");
            return false;
        }
        else 
            return true;
        }

}
