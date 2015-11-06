/*
 * This class used to provide a connection to the datasource for all DAO's.
 */
package common;

import java.sql.DriverManager;

/**
 * @author Rahel Ephrem
 * @version 1.0
 */
public class Connection {
    /**
     * Sole connection object for application instance.
     */
    private static java.sql.Connection con = null; 
    
   /**
     * Returns connection to datasource.
     * @return Returns connection to datasource. 
    */
    public static java.sql.Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/medicalcarealliance"; 
        String driver = "com.mysql.jdbc.Driver";
        
        if( con == null ){
            try { 
                Class.forName(driver).newInstance(); 
                con = DriverManager.getConnection(url,"admin","admin");  
            } catch (Exception e) { e.printStackTrace();} 
        }

        return con;
    }
    
    /**
     * Close the open connection.
     */
    public static void closeConnection(){
        if( con != null ){
            try {
                con.close();
            }catch(Exception e){}
        }
    }
}
