/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.socketsejemploclase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * En este ejemplo se crearon 2 clases una para simular el 
 *  Servidor y otra para simular el cliente.
 *      Ambas clases tienen un método main para poder ejecutarlas al
 *      mismo tiempo
 *  
 * Servidor 
 * Ejemplo sockets
 */
public class SocketsEjemploClase {

    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket socket = null;
        
        int puerto = 6000;
        DataInputStream in;
        DataOutputStream out;
        
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
                
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado " + formatoFecha.format(LocalDateTime.now()));    
            


            while (true) {                
                //espera de conexion o solicitud
            socket = servidor.accept();
            
            System.out.println("Cliente conectado " + formatoFecha.format(LocalDateTime.now()));
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            String mensaje = in.readUTF();
            System.out.println("Mensje " + mensaje);
            
            out.writeUTF("Hola mundo desde el servidor siendo " + formatoFecha.format(LocalDateTime.now()));
            socket.close();
            
            System.out.println("Cliente desconectado a las " + formatoFecha.format(LocalDateTime.now()));
            System.out.println("");
            }
                    
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        
    }
}
