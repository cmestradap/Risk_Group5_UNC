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
public class Player {

    private boolean Turn;
    private boolean playing;
    private String CaptureState;
    private String Color;
    private int TerritoryAmount;
    private int CardAmount;
    private int Army;
    private int ContinentAmount;
    private int trades;
    
    /**
     * This method is the constructor of Player class
     */
    public Player(){
        CaptureState = null;
        Color = null;
        TerritoryAmount = 0;
        CardAmount = 0;
        Army = 0;
        
    }
    
    /**
     * This method is the constructor of player class
     * @param turn
     * @param capture
     * @param color
     * @param territoryamount
     * @param continentamount
     * @param cardamount
     * @param army 
     * @param Trades 
     */
    public Player(boolean turn,boolean Playing, String capture, String color,int territoryamount,int continentamount, int cardamount, int army,int Trades){
        Turn = turn;
        playing = Playing;
        CaptureState = capture;
        Color = color;
        TerritoryAmount = territoryamount;
        CardAmount = cardamount;
        Army = army;
        ContinentAmount = continentamount;
        trades = Trades;
    }
    
    /**
     * This method sets the turn of the player
     * @param value 
     */
    public void setTurn(boolean value) {
        this.Turn = value;
    }

    /**
     * This method gets the turn of the player
     * @return The turn's player
     */
    public boolean getTurn() {
        return this.Turn;
    }

    /**
     * This method sets the capture state of the player
     * @param value 
     */
    public void setCaptureState(String value) {
        this.CaptureState = value;
    }

    /**
     * This method gets the captured state of the player
     * @return The capture state's player  
     */
    public String getCaptureState() {
        return this.CaptureState;
    }

    /**
     * This method sets the color of the player
     * @param value 
     */
    public void setColor(String value) {
        this.Color = value;
    }

    /**
     * This method gets the color of the player
     * @return The color's player
     */
    public String getColor() {
        return this.Color;
    }

    /**
     * This method sets the Continent amount of the player
     * @param value 
     */
    public void setContinentAmount(int value) {
        this.ContinentAmount = value;
    }

    /**
     * This method gets the Continent amount of the player
     * @return The Continent amount's player 
     */
    public int getContinentAmount() {
        return this.ContinentAmount;
    }
    /**
     * This method sets the territory amount of the player
     * @param value 
     */
    public void setTerritoryAmount(int value) {
        this.TerritoryAmount = value;
    }

    /**
     * This method gets the territory amount of the player
     * @return The territory amount's player 
     */
    public int getTerritoryAmount() {
        return this.TerritoryAmount;
    }

    /**
     * This method sets the cards amount of the player
     * @param value 
     */
    public void setCardAmount(int value) {
        this.CardAmount = value;
    }

    /**
     * 
     * This method gets the cards amount of the player
     * @return The card amount's player 
     */
    public int getCardAmount() {
        return this.CardAmount;
    }

    /**
     * 
     * This method sets the army of the player
     * @param value 
     */
    public void setArmy(int value) {
        this.Army = value;
    }

    /**
     * 
     * This method gets the army of the player
     * @return  the army's player
     */
    public int getArmy() {
        return this.Army;
    }

    /**
     * This method let the player accept the turn and get the amount of army that he get in the beginning
     * @param player
     * @param session 
     */
    public static void accepts(Player player,Session session) {
        player.Army = player.TerritoryAmount / 3;
        Map map = session.getMap();
        ArrayList<Continent> Continents = map.getContinents();
        for (Continent Continent : Continents) {
            if (Continent.getOwner().equals(player.Color)) {
                player.Army = player.Army + Continent.getArmy();
            }
        }
    }

    /**
     * This method lets the player finish the turn and gives a card if he can and reset the states needed
     * @param player
     * @param Cards 
     */
    public static void Passes(Player player,Card[] Cards) {
        if("CAPTURE".equals(player.getCaptureState())){            
            for (Card Card : Cards) {
                if ("WHITE".equals(Card.getOwner())) {
                    Card.setOwner(player.getColor());
                    player.setCaptureState("NON-CAPTURE");
                    break;
                }
            }
            
        }
        
    }

    /**
     * This method lets place one army in one territory.
     * @param player
     * @param Territorytoplace 
     */
    public static void Places(Player player, Territory Territorytoplace) {
        if (player.getArmy() > 0) {
            if (Territorytoplace.getArmy() == 0) {
                Territorytoplace.setOwner(player.getColor());
            }
            if (Territorytoplace.getOwner().equals(player.getColor())) {
                player.setArmy(player.getArmy() - 1);
                Territorytoplace.setArmy(Territorytoplace.getArmy() + 1);
            }
        }

    }
      /**
     * 
     * This method gets the value of trade of the player
     * @return 
     */
    public int gettrades(){
        return trades;
    }
      /**
     * This method sets the value of trade of the player
     * @param value 
     */
    public void settrades(int value){
        trades = value;
    }
    
    public void setplaying(boolean value){
        playing = value;
    }
    
    public boolean getplaying(){
        return playing;
    }

}