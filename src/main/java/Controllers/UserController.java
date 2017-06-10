/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.util.Scanner;

/**
 *
 * @author Jimmy
 */
public class UserController {
    static Scanner in = new Scanner(System.in);
    static String response;
    
    public static String LogIn(String json){
        System.out.println("El JSON QUE FUE INGRESADO SE DEBE MANDAR AL EQUIPO 4");
        System.out.println("SE ESPERA JSON DE RESPUESTA");
        response = in.nextLine();
        return response;       
        
    }
    public static String LogOut(String json){
        System.out.println("El JSON QUE FUE INGRESADO SE DEBE MANDAR AL EQUIPO 4");
        System.out.println("SE ESPERA JSON DE RESPUESTA");
        response = in.nextLine();
        return response;  
    }
    
    public static String RegisterUser(String json){
         System.out.println("El JSON QUE FUE INGRESADO SE DEBE MANDAR AL EQUIPO 4");
        System.out.println("SE ESPERA JSON DE RESPUESTA");
        response = in.nextLine();
        return response;  
        
    }    
}
