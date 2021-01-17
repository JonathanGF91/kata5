/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5.Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jonathan
 */
public class Connection {
    
    private String db;
    
    public Connection (String db){
        this.db = db;
    }
    
    public ResultSet query (String query) throws ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        try (java.sql.Connection connection = DriverManager.getConnection(this.db);
                Statement statement = connection.createStatement()) {
            
            ResultSet result = statement.executeQuery(query);
            
        }  
    }
}
