/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;

public class Continent {

    public static Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String Name;
    private String Owner;
    private int Army;
    private ArrayList<Territory> Territories;
    
    /**
     * 
     */
    public Continent(){
        Name = null;
        Owner = null;
        Army = 0;
        Territories = null;
    }
    /**
     * This method is the construct of Continent class
     * @param name
     * @param owner
     * @param army
     * @param terr 
     */
    public Continent(String name, String owner, int army, ArrayList<Territory> terr){
        Name = name;
        Owner = owner;
        Army = army;
        Territories = terr;
    }
    
    /**
     * This method sets the value of the name of the Continet
     * @param value 
     */
    public void setName(String value){
        this.Name = value;
    }
    
    /**
     * This method gets the value of the name of the Continet
     * @return The name of the continent 
     */
    public String getName(){
        return Name;
    }
    
    /**
     * This method gets the value of the territoriy of the Continet
     * @return The array territory of the continent 
     */
    public ArrayList<Territory> getTerritory(){
        return Territories;
    }
    
    
    public void setTerritory(ArrayList<Territory> terr){
        this.Territories = terr;    
    }
    
    /**
     * This method sets the value of the owner of the Continet
     * @param value 
     */
    public void setOwner(String value){
        this.Owner = value;
    }
    
    /**
     * This method gets the value of the owner of the Continet
     * @return The owner of the continent
     */
    public String getOwner(){
        return Owner;
    }
    
    /**
     * This method sets the value of the army of the Continet
     * @param value 
     */
    public void setArmy(int value){
        this.Army = value;
    }
    
    /**
     * This method gets the value of the army of the Continet
     * @return the army of the continent
     */
    public int getArmy(){
        return Army;
    }
        
        
}