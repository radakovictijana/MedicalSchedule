/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class ServerThread extends Thread{
    private ServerSocket serverSocket;
    List<ClientThread> lct;


    public ServerThread() throws IOException {
        serverSocket = new ServerSocket(10000);
        lct = new LinkedList<>();
    }

    
    @Override
    public void run() {
        try{
            while(!isInterrupted()){
                Socket socket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(socket);
                
                clientThread.start();
                lct.add(clientThread);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void zaustaviServer() {
        try{
            for(ClientThread clientThread: lct){
                clientThread.zaustavi();
            }
            this.interrupt();
            serverSocket.close();
        }catch(Exception ex){
            
        }
    }
    
    
}
