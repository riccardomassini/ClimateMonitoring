/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.clientrmi;

import client.frame.GestioneScelta;
import javax.swing.JFrame;


public class ResetClient {
    public static void spegniClient(JFrame frame){
        //passo una stringa vuota perchè il costruttore vuoto esiste già
        GestioneScelta gs = new GestioneScelta("");
        gs.setLocation(frame.getX(), frame.getY());
        frame.dispose();
        gs.setVisible(true);
    }
}