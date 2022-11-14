package ch.heigvd.dai.lab4smtp;

public class Mail{
    private Group group;
    private Prank prank;

    public Mail(Group group, Prank prank){
        this.group = group;
        this.prank = prank;
    }

    // si en enlever les setter il faut changer les private en final
    /* 
    public void setGroup(Group group){
        this.group = group;
    }

    public void setPrank(Prank prank){
        this.prank = prank;
    }*/

    public Group getGroup(){
        return this.group;
    }

    public Prank getPrank(){
        return this.prank;
    }
}