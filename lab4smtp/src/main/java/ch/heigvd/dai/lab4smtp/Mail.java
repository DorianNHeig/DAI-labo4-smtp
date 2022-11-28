package ch.heigvd.dai.lab4smtp;

public class Mail{
    private Group group;
    private Prank prank;

    /**
     * Constructor of the mail
     * @param group the group of the mail
     * @param prank the prank of the mail
     */
    public Mail(Group group, Prank prank){
        this.group = group;
        this.prank = prank;
    }

    /**
     * Get the group of the mail
     * @return the group of the mail
     */
    public Group getGroup(){
        return this.group;
    }

    /**
     * Get the prank of the mail
     * @return the prank of the mail
     */
    public Prank getPrank(){
        return this.prank;
    }
}