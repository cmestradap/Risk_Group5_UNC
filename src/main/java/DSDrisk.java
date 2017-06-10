
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controllers.*;
import Controllers.SessionController;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Alejandro Gaviria 
 */

public class DSDrisk {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, ParseException{
        String s = new Scanner(System.in).nextLine();
        

        //recive the JSON of the team 3 AND update the database
        SessionController sc = new SessionController();
        sc.CreateSession(s);
        
        //our module is a channel, we send the same JSON to team5.
        System.out.println(sc.SendCreationSession(s));
       
    }
}
    
