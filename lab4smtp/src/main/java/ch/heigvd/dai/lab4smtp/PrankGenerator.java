package ch.heigvd.dai.lab4smtp;

import java.util.ArrayList;

public class PrankGenerator {
    private Config config;

    public PrankGenerator() {
        config = new Config();
    }

    public void startPrank() {
        System.out.println( "Start prank" );
        SmtpClient client = new SmtpClient(config.getServerIP(), config.getServerPort());
        
        ArrayList<Person> receiver = new ArrayList<Person>();

        Person person1 = new Person("dorian.niclass@heig-vd.ch");
        receiver.add(new Person("dorian.niclass@gmail.com"));

        Group group = new Group(person1, receiver);

        Mail mail = new Mail(group, new Prank("test header", "test body"));

        client.sendMail(mail);
    }
}
//