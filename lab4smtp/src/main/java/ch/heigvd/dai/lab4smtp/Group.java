package ch.heigvd.dai.lab4smtp;

import java.util.ArrayList;

public class Group{
    private Person sender;
    private ArrayList<Person> receivers;

    /**
     * Constructor of the Group class
     * @param sender the sender of the email
     * @param receivers all the receivers of the email
     */
    public Group(Person sender, ArrayList<Person> receivers){
        this.sender = sender;
        this.receivers = receivers;
    }

    /**
     * Getter of the sender
     * @return the sender of the email
     */
    public Person getSender(){
        return this.sender;
    }

    /**
     * Getter of the receivers
     * @return all the receivers of the email
     */
    public ArrayList<Person> getReceivers(){
        return this.receivers;
    }

}