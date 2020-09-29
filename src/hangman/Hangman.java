/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author MITA AMARA
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Hangman {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hangman";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static String query;

    Hangman(){
        initComponent();
    }
    
    private void initComponent() {
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getPlayer(){
        try{
        query = "SELECT * FROM player";
        rs = stmt.executeQuery(query);
        
            while(rs.next()){
                System.out.println("id pemain: " + rs.getInt("id_player"));
                System.out.println("nama " + rs.getString("nama_player"));
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getList(){
        try{
           query = "SELECT * FROM list limit 2";
           rs = stmt.executeQuery(query);
           
           while(rs.next()){
                System.out.println("list hewan: " + rs.getString("hewan"));
                System.out.println("list bunga " + rs.getString("bunga"));
                System.out.println("list buah " + rs.getString("buah"));
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //TODO GET HIHGSCORE FOR CATEGORY
    //TODO SETNAME
    //TODO GETLIST DENGAN SYARAT
}
