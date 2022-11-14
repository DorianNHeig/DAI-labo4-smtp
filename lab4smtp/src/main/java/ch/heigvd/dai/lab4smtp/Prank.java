package ch.heigvd.dai.lab4smtp;

public class Prank{
    private String header;
    private String body;

    public Prank(String header, String body){
        this.header = header;
        this.body = body;
    }
    /*
    public void setHeader(String header){
        this.header = header;
    }

    public void setBody(String body){
        this.body = body;
    }*/

    public String getHeader(){
        return this.header;
    }

    public String getBody(){
        return this.body;
    }
}
