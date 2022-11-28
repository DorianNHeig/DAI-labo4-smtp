package ch.heigvd.dai.lab4smtp;

import java.util.ArrayList;

public class Group{
    private Person sender;
    private ArrayList<Person> receivers;

    public Group(Person sender, ArrayList<Person> receivers){
        this.sender = sender;
        this.receivers = receivers;
    }
    /*
    public void setSender(Person sender){
        this.sender = sender;
    }

    public void setReceiver(ArrayList<Person> receiver){
        this.receiver = receiver;
    }*/

    public Person getSender(){
        return this.sender;
    }

    public ArrayList<Person> getReceivers(){
        return this.receivers;
    }

}