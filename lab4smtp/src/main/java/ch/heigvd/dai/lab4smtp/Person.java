package ch.heigvd.dai.lab4smtp;

public class Person{
    private String mail;

    /**
     * Constructor of the class Person
     * @param mail the mail of the person
     */
    public Person(String mail){
        this.mail = mail;
    }

    /**
     * Getter of the mail
     * @return the mail of the person
     */
    public String getMail(){
        return this.mail;
    }

}