package sockets.texto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        
        int port = 54321;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("A porta " + port + " foi aberta!");
        System.out.println("Servidor esperando receber mensagem de cliente...");
        

        Socket socket = serverSocket.accept();
        

        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

        
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String mensagem = entrada.readUTF();//receber mensagem em minúsculo do cliente
        String novaMensagem = mensagem.toUpperCase(); //converter mensagem em maiúsculo

        
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF(novaMensagem); //Enviar mensagem em maiúsculo para cliente

        
        entrada.close();
        saida.close();

        
        socket.close();
        serverSocket.close();
    }
}