/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Database {
    GameLogic game = new GameLogic();
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hangman";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static String query;
    Database(){
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
    
    //for list word
    static List[] allLists = new List[3];
    
    private static List<String> list1 = new ArrayList<String>();
    private static List<String> list2 = new ArrayList<String>();
    private static List<String> list3 = new ArrayList<String>();
    
    public static void readAndWrite(List<String> list, String c){
        try{
            query = "SELECT "+c+" FROM list";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                list.add(rs.getString(c));
            }
//            stmt.close();
//            conn.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void startParallel(){
        Thread[] thread = new Thread[3];
        
        thread[0] = new Thread(new Runnable(){
            public void run(){
                readAndWrite(list1, "hewan");
                allLists[0] = list1;
            }
        });
        
        thread[1] = new Thread(new Runnable(){
            public void run(){
                readAndWrite(list2, "bunga");
                allLists[1] = list2;
            }
        });
        
        thread[2] = new Thread(new Runnable(){
            public void run(){
                readAndWrite(list3, "buah");
                allLists[2] = list3;
            }
        });
        
        for(int i=0; i<3; i++){
            thread[i].start();
        }
        
        try{
            for(int i=0; i<3; i++){
                thread[i].join();
            }
        }
        catch(InterruptedException e){
            e.getStackTrace();
        }
    }
    
    public void startSequential(){
        readAndWrite(list1, "hewan");
        readAndWrite(list2, "bunga");
        readAndWrite(list3, "buah");
        
            allLists[0]=list1;
            allLists[1]=list2;
            allLists[2]=list3;
    }
    public List[] getAllLists(){
        return allLists;
    }
    
    public static void setAllLists(@SuppressWarnings("rawtypes") List[] allLists) {
	Database.allLists = allLists;
    }
    
    public ResultSet getScore() throws SQLException{   
        query = "select *from player inner join score on player.id_player=score.id_player order by point desc;";
        rs = stmt.executeQuery(query);
        
        return rs;
    }
    
    public void setScore(int points){
        try{
            query = "INSERT INTO score VALUES(null,"+game.getIdName()+","+points+");";
            stmt.executeUpdate(query);
        }
        catch(SQLException e){
            e.getStackTrace();
        }
    }
    public int getId(String nama){
        int save=0;
        try {
            query = "SELECT id_player FROM player WHERE nama_player ='"+nama+"';";
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                save = rs.getInt("id_player");
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        
        return save;
    }
    
    public void setName(String nama){
       try{
            query = "INSERT INTO player VALUES(null,'"+nama+"');";
            stmt.executeUpdate(query);
            System.out.println(game.getUserName());
        }
        catch(SQLException e){
            e.getStackTrace();
        } 
    }
}
