package ch.heigvd.dai.lab4smtp;

public class Person{
    private String mail;

    public Person(String mail){
        this.mail = mail;
    }

    /*
    public void setMail(String mail){
        this.mail = mail;
    }*/

    public String getMail(){
        return this.mail;
    }

}