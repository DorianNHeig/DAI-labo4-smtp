package ch.heigvd.dai.lab4smtp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class SmtpClient{

    private String ip;
    private int port;

    /**
     * Constructor of the class SmtpClient to load the ip and the port
     * @param ip the ip of the server
     * @param port the port of the server
     */
    public SmtpClient(String serverIP, int serverPort){
        this.ip = serverIP;
        this.port = serverPort;
    }

    /**
     * Method to send a mail to the server
     * @param mail the mail to send
     */
    public void sendMail(Mail mail){
        Person sender = mail.getGroup().getSender();
        ArrayList<Person> receivers = mail.getGroup().getReceivers();
        
        String prankHeader = mail.getPrank().getHeader();
        String prankBody = mail.getPrank().getBody();

        // socket connection
        try{
            Socket socket = new Socket(ip, port);
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            
            // send the mail
            os.writeBytes("EHLO localhost\r\n");
            os.writeBytes("MAIL FROM:<"+ sender.getMail() + ">\r\n");


            for(Person victim : receivers) {
                os.writeBytes("RCPT TO:<" + victim.getMail() + ">\r\n");
            }

            os.writeBytes("DATA\r\n");
            os.writeBytes("From: <" + sender.getMail() + ">\r\n");
            os.writeBytes("To: ");

            for(Person victim : receivers) {
                os.writeBytes("<" + victim.getMail() + ">, ");
            }

            os.writeBytes("\r\n");
            os.writeBytes("Content-Type: text/plain; charset=\"UTF-8\"\r\n");
            os.writeBytes("Subject:" + prankHeader + "\r\n\r\n");
            os.writeBytes(prankBody + "\r\n");
            os.writeBytes("\r\n.\r\n");
            os.writeBytes("QUIT\r\n");

            os.close();
            socket.close();

            System.out.println("Mail sent !");
        }catch(UnknownHostException e){
            System.out.println("Error : Unknown host (" + ip + ":" + port + ") not found");
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
        }catch(Exception e){
            System.out.println("Error while connecting to the server: " + e.getMessage());
        }
    }
}