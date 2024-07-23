/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.registraeventi;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerEventi{
    private static LoggerEventi instance;
    private static final String LOG_FILE = "./data/Applicazione.dati.log";
    private FileWriter fileWriter;

    private LoggerEventi() {
        try {
                fileWriter = new FileWriter(LOG_FILE, true); // True per appendere al file esistente
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            Logger.getLogger(LoggerEventi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized LoggerEventi getInstance() {
        if (instance == null) {
            instance = new LoggerEventi();
        }
        return instance;
    }

    public synchronized void log(String message){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(new Date());
            String logEntry = "[" + formattedDate + "] " + message + "\n";
            fileWriter.write(logEntry);
            fileWriter.flush();
        }catch(FileNotFoundException ex){
            ex.printStackTrace(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void close() {
        try {
            fileWriter.close();
        
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
