/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socketsejemploclase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  En este ejemplo se crearon 2 clases una para simular el 
 *  Servidor y otra para simular el cliente.
 *      Ambas clases tienen un método main para poder ejecutarlas al
 *      mismo tiempo
 * 
 * 
 * Socket ejemplo cliente
 */
public class ClienteSocket {
    
    public static void main(String[] args) {
        try {
            String host = "127.0.0.1";
            int puerto = 6000;
            
            DataInputStream in;
            DataOutputStream out;

            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
            
            Socket socket = new Socket(host, puerto);
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            //enviar mensaje
            out.writeUTF("Hola munDO desde el cliente Socket siendo las " + formatoFecha.format(LocalDateTime.now()));
            
            //leer mensaje servidor
            String mensaje = in.readUTF();
            
            System.out.println("Mensaje " + mensaje + " siendo las " + formatoFecha.format(LocalDateTime.now()));
            socket.close();
                    
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
    }   
    
}
