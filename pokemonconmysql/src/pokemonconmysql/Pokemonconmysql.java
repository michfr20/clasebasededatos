/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonconmysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Pokemonconmysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //paso 1 añadir libreria mysql
        
        //
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");//direccion deln servidor de baso de datos
        dataSource.setDatabaseName("pokemonbd");
        dataSource.setUser("root");
        dataSource.setPassword("");
        
        
        //paso 3 obtener una conexion data source
        Connection connection = dataSource.getConnection();
        
        
        //paso 4 crear sentecia
        /*Statement sentencia = connection.createStatement();
        
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del pokemon :");
        String tipo = JOptionPane.showInputDialog("Ingrese nombre del pokemon :");
        int nivel = Integer.valueOf(JOptionPane.showInputDialog("Ingrese nombre del pokemon :"));
        int vida = Integer.valueOf(JOptionPane.showInputDialog("Ingrese nombre del pokemon :"));
        
        //paso 5 definir sentencias a ejecutar
        sentencia.executeUpdate("INSERT INTO pokemones(codigo,nombre,tipo,nivel,vida) VALUES (NULL,'"+nombre+"','"+tipo+"','"+nivel+"','"+vida+"')");
        */
        //paso4b crear preparedStatement
        //PreperedStatement prep = connection.prepareStatement("INSERT INTO pokemones(,nombre,tipo,nivel,vida) VALUES (NULL,'','','',''")
        
        //paso 4c crear preparedStatement
        PreparedStatement prep = connection.prepareStatement("SELECT * FROM pokemones");
        
        //paso 5c obtener resul set
        ResultSet rs = prep.executeQuery();
        
        //paso 6c iterar resul set
        while (rs.next()){
            String n = rs.getString("nombre");
            String t = rs.getString("tipo");
            int niv = rs.getInt("nivel");
            int v = rs.getInt("vida");
            
            System.out.println("Pokemon : " + n + "Tipo : " + t);
        }
        
    }
    
}
