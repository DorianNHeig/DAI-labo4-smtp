package ch.heigvd.dai.lab4smtp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrankGenerator {
    private Config config;

    /**
     * Constructor of the PrankGenerator
     */
    public PrankGenerator() {
        config = new Config();
    }

    /**
     * Start the prank with the config file
     */
    public void startPrank() {
        System.out.println( "Start prank" );

        if (config.getPersons().size() == 0) {
            System.err.println("The persons list is empty. Quitting.");
            System.exit(1);
        }

        if (config.getPranks().size() == 0) {
            System.err.println("The pranks folder is empty. Quitting.");
            System.exit(1);
        }
            
        SmtpClient client = new SmtpClient(config.getServerIP(), config.getServerPort());
        
        List<Group> groups = generateGroups();

        Random rand = new Random();
        for (Group group : groups) {
            Prank prank = config.getPranks().get(rand.nextInt(config.getPranks().size()));
            Mail mail = new Mail(group, prank);

            client.sendMail(mail);
        }
    }

    /**
     * Generate the groups for the prank
     * @return List of groups
     */
    private ArrayList<Group> generateGroups() {
        ArrayList<Group> groups = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < config.getNbGroup(); ++i) {
            ArrayList<Person> receivers = new ArrayList<>();
            
            // generate the liste of receivers
            for (int j = 1; j < config.getGroupSize(); ++j){
                receivers.add(config.getPersons().get(rand.nextInt(config.getPersons().size())));
            }

            // generate the group with a sender and the receivers
            Group group = new Group(config.getPersons().get(rand.nextInt(config.getPersons().size())), receivers);
            groups.add(group);
        }

        return groups;
    }
    
}
//