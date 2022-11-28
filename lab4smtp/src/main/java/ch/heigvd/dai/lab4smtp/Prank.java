package ch.heigvd.dai.lab4smtp;

public class Prank{
    private String header;
    private String body;

    /**
     * Constructor of the Prank class
     * @param header The header of the prank
     * @param body The body of the prank
     */
    public Prank(String header, String body){
        this.header = header;
        this.body = body;
    }

    /**
     * Getter of the header
     * @return The header of the prank
     */
    public String getHeader(){
        return this.header;
    }

    /**
     * Getter of the body
     * @return The body of the prank
     */
    public String getBody(){
        return this.body;
    }
}
