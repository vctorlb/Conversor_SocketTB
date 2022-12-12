package sockets.texto;
import java.util.Scanner;
import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
    
       //Abrir conexão utilizando o loopback
        Socket socket = new Socket("127.0.0.1", 54321);
        
        System.out.println("Digite a Palavra minúscula para conversão.");
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        DataOutputStream saida = new DataOutputStream(socket.getOutputStream()); 

        saida.writeUTF(message);

        
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF();//Receber mensagem em maiúsculo do servidor
        System.out.println("Palavra Traduzida:");
        System.out.println(novaMensagem); //Mostrar mensagem em maiúsculo no cliente

        
        entrada.close();
        saida.close();
        socket.close();
    }
}