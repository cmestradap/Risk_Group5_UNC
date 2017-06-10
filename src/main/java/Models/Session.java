
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author team5
 */
package Models;
import Controllers.DatabaseConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.*;
import java.util.ArrayList;

public class Session {
    
    private int ID;
    private String State;
    private Player[] players;
    private Map map = new Map(null, null, null);
    private String Type;
    
   public Session(){}
    
    /**
     * This method create an object of Session
     * @param id
     * @param state
     * @param Players
     * @param map1 
     */
    public Session(int id, String state,Player[] Players, Map map1, String type){
        ID = id;
        State = state;
        players = Players;
        map = map1;
        Type = type;
    }

    public Session(int i, String string, ArrayList<Player> Players, Map mapobj, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      
    
    /**
     * This method sets the value of the id of the session
     * @param value 
     */
    public void setID(int value){
        this.ID = value;
    }
    
    /**
     * This method gets the value of the id of the session
     * @return The ID of the session
     */
    public int getID(){
        return ID;
    }
    
    /**
     * This method sets the value of the state of the session
     * @param value 
     */
    public void setState(String value){
        this.State = value;
    }
    
    /**
     * This method gets the value of the state of the session
     * @return 
     */
    public String getState(){
        return State;
    }
    
    /**
     * This method gets the value of the players of the session
     * @return The players of the session
     */
    public Player[] getPlayers(){
        return players;
    }
    
    /**
     * This method gets the value of the map of the session
     * @return The map of the session
     */
    public Map getMap(){
        return this.map;
    }
    /**
     * This method sets the type value of the session
     * @param value 
     */
    public void setType(String value){
        Type = value;
    }
    
    /**
     *  This method gets the type value of the session
     * @return The type of the session
     */
    public String getType(){
        return Type;
    }
    /**
     * this method Obteins the data 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void ObtainData() throws ClassNotFoundException, SQLException{
    ResultSet resultset;
        resultset = DatabaseConnector.getInstance().getStatement().executeQuery("SELECT DISTINCTROW * FROM session,continent,territory,map  WHERE session.map = map.map AND  map.map = continent.map AND continent.name = territory.continent ORDER BY session.id ;");
            while (resultset.next()) {
                
                Object a1 = resultset.getString("session.id");
                Object a2 = resultset.getString("session.state");
                Object a3 = resultset.getString("session.type");
                Object a4 = resultset.getString("session.map");
                Object a5 = resultset.getString("continent.map");
                Object a6 = resultset.getString("continent.name");
                Object a7 = resultset.getString("continent.owner");
                Object a8 = resultset.getString("territory.name");
                Object a9 = resultset.getString("territory.owner");
                Object a10 = resultset.getString("territory.continent");
                Object a11 = resultset.getString("territory.type");
                Object a12 = resultset.getString("map.map");
             
                
                
                System.out.println(a1);
                System.out.println(a2);
                System.out.println(a3);
                System.out.println(a4);
                System.out.println(a5);
                System.out.println(a6);
                System.out.println(a7);
                System.out.println(a8);
                System.out.println(a9);
                System.out.println(a10);
                System.out.println(a11);
                System.out.println(a12);
                
       
       }
    }
}