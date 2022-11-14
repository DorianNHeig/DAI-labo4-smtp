package ch.heigvd.dai.lab4smtp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class SmtpClient{

    private String ip;
    private int port;

    // load the server configuration
    public SmtpClient(String serverIP, int serverPort){
        this.ip = serverIP;
        this.port = serverPort;
    }

    public void sendMail(Mail mail){
        Person sender = mail.getGroup().getSender();
        ArrayList<Person> receiver = mail.getGroup().getReceiver();
        
        String prankHeader = mail.getPrank().getHeader();
        String prankBody = mail.getPrank().getBody();

        // socket connection
        try{
            System.out.println(String.format("IP: %s, Port %d", ip, port));
            Socket socket = new Socket(ip, port);
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            
            // send the mail
            for(Person victim : receiver){
                os.writeBytes("EHLO\r\n");
                os.writeBytes("MAIL FROM:<"+ sender.getMail() + ">\r\n");
                os.writeBytes("RCPT TO:<" + victim.getMail() + ">\r\n");
                os.writeBytes("DATA\r\n");
                os.writeBytes("Subject:" + prankHeader + "\r\n\r\n");
                os.writeBytes(prankBody + "\r\n");
                os.writeBytes("\r\n.\r\n");
                os.writeBytes("QUIT\r\n");
            }

            socket.close();
        }catch(UnknownHostException e){
            System.out.println("Error : Unknown host (" + ip + ":" + port + ") not found");
        }catch(IOException e){
            System.out.println("Error : IOException (problem with input / output)");
        }catch(Exception e){
            System.out.println("Error while connecting to the server");
        }
    }
}