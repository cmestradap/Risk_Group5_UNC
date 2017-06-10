/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.sql.PreparedStatement;
import Models.Session;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Alejandro GAviria
 */
public class SessionController {
    
    static String response;
    
    
    public static String CreateSession(String Json) throws ParseException, ClassNotFoundException, SQLException{
        
        
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        jsonObject = (JSONObject)parser.parse(Json);
        
        JSONArray arreglo = (JSONArray) parser.parse("["+jsonObject.toJSONString()+"]");
        
        //System.out.println((String) ((JSONObject)((JSONArray)((JSONObject)(arreglo.get(0))).get("session")).get(0)).get("id"));
       
        Session sc = new Session(); 
        sc.setID(Integer.parseInt(String.valueOf(((JSONObject)((JSONArray)((JSONObject)(arreglo.get(0))).get("session")).get(0)).get("id"))));
        sc.setState((String.valueOf(((JSONObject)((JSONArray)((JSONObject)(arreglo.get(0))).get("session")).get(0)).get("state"))));
        sc.setType((String.valueOf(((JSONObject)((JSONArray)((JSONObject)(arreglo.get(0))).get("session")).get(0)).get("type"))));
        sc.getMap().setName((String.valueOf(((JSONObject)((JSONArray)((JSONObject)(arreglo.get(0))).get("session")).get(0)).get("map"))));
        
        
        String queryInsertSession = "INSERT INTO session VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnector.getInstance().getConnection().prepareStatement(queryInsertSession);
        
        preparedStatement.setInt(1,sc.getID());
        preparedStatement.setString(2,sc.getState());
        preparedStatement.setString(3,sc.getType());
        preparedStatement.setString(4,sc.getMap().getName());
        preparedStatement.executeUpdate();
        
        
        
        JSONArray players = (JSONArray)((JSONObject)arreglo.get(0)).get("players");
        
        for (int i = 0; i < players.size(); i++) {
            
        String queryInsertPlayer = "INSERT INTO player (turn, playing, color, capturestate, territory_amount, continent_amount, card_amount, trades, army) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement2 = DatabaseConnector.getInstance().getConnection().prepareStatement(queryInsertPlayer);
        
        preparedStatement2.setBoolean(1,(boolean)((JSONObject)players.get(i)).get("turn"));
        preparedStatement2.setString(2,String.valueOf(((JSONObject)players.get(i)).get("playing")));
        preparedStatement2.setString(3,String.valueOf(((JSONObject)players.get(i)).get("color")));
        preparedStatement2.setString(4,String.valueOf(((JSONObject)players.get(i)).get("capturestate")));
        preparedStatement2.setString(5,String.valueOf(((JSONObject)players.get(i)).get("territory_amount")));
        preparedStatement2.setString(6,String.valueOf(((JSONObject)players.get(i)).get("continent_amount")));
        preparedStatement2.setString(7,String.valueOf(((JSONObject)players.get(i)).get("card_amount")));
        preparedStatement2.setString(8,String.valueOf(((JSONObject)players.get(i)).get("trades")));
        preparedStatement2.setString(9,String.valueOf(((JSONObject)players.get(i)).get("army")));
        preparedStatement2.executeUpdate();
            
        }
            
        JSONArray continents = (JSONArray)((JSONObject)arreglo.get(0)).get("continent");
        
        for (int i = 0; i < continents.size(); i++) {
            
        String queryInsertContinent = "UPDATE continent SET owner='"+String.valueOf(((JSONObject)continents.get(i)).get("owner"))+"' WHERE name='"+String.valueOf(((JSONObject)continents.get(i)).get("name"))+"';";
        PreparedStatement preparedStatement3 = DatabaseConnector.getInstance().getConnection().prepareStatement(queryInsertContinent);
        
        preparedStatement3.executeUpdate();
            
        }  
        JSONArray territories = (JSONArray)((JSONObject)arreglo.get(0)).get("territory");
        for (int i = 0; i < territories.size(); i++) {
            
        String queryInsertTerritory = "UPDATE territory SET owner='"+String.valueOf(((JSONObject)territories.get(i)).get("owner"))+"',type='"+String.valueOf(((JSONObject)territories.get(i)).get("type"))+"' WHERE name='"+String.valueOf(((JSONObject)territories.get(i)).get("name"))+"' AND continent = '"+String.valueOf(((JSONObject)territories.get(i)).get("continent"))+"';";
        PreparedStatement preparedStatement4 = DatabaseConnector.getInstance().getConnection().prepareStatement(queryInsertTerritory);
        
        preparedStatement4.executeUpdate();
        
        }
        
        /*
        JSONArray Cards = (JSONArray)((JSONObject)arreglo.get(0)).get("card");
        for (int i = 0; i < Cards.size(); i++) {
            
        String queryInsertCard = "INSERT INTO card (id,design,owner,type) VALUES(?,?,?,?);";
        PreparedStatement preparedStatement5 = DatabaseConnector.getInstance().getConnection().prepareStatement(queryInsertCard);
        
        preparedStatement5.setString(1,String.valueOf(((JSONObject)Cards.get(i)).get("id")));
        preparedStatement5.setString(2,String.valueOf(((JSONObject)Cards.get(i)).get("design")));
        preparedStatement5.setString(3,String.valueOf(((JSONObject)Cards.get(i)).get("owner")));
        preparedStatement5.setString(4,String.valueOf(((JSONObject)Cards.get(i)).get("type")));
        preparedStatement5.executeUpdate();
        
        }
        */
       
       return null;
    }
    public String SendCreationSession(String s){
    
         return s;
    
    }
}
        
            
 