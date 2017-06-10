/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;

/**
 *
 * @author jimmy
 */
public class Map {
    private String Name;
    private ArrayList<Continent> Continents;
    private ArrayList<Card> Cards;
    
    /**
     *  This method is the constructor of Map class
     * @param name
     * @param continents
     * @param cards
     * @param boundary 
     */
    public Map(String name,ArrayList<Continent> continents, ArrayList<Card> cards){
        Name = name;
        Continents = continents;
        Cards = cards;
    }
   
    
    /**
     * This method sets the name of the map
     * @param value 
     */
    public void setName(String value){
        Name = value;
    }
    
    /**
     * This method gets the name of the map
     * @return The name of the map 
     */
    public String getName(){
        return Name;
    }
    
    /**
     * This method gets the continents of the map
     * @return 
     */
    public ArrayList<Continent> getContinents(){
        return Continents;
    }
    
    /**
     * This method gets the cards of the map
     * @return 
     */
    public ArrayList<Card> getCards(){
        return Cards;
    }
    
}