package ch.heigvd.dai.lab4smtp;

import java.util.ArrayList;

public class Group{
    private Person sender;
    private ArrayList<Person> receiver;

    public Group(Person sender, ArrayList<Person> receiver){
        this.sender = sender;
        this.receiver = receiver;
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

    public ArrayList<Person> getReceiver(){
        return this.receiver;
    }

}