package ch.heigvd.dai.lab4smtp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

public class Config {
    private static final String CONFIG_PATH = "./configs/config.toml";
    private static final String PERSONS_PATH = "./configs/persons.txt";
    private static final String PRANKS_DIR = "./configs/pranks/";

    private class ConfigData {
        // Default configuration
        public String server_ip = "127.0.0.1";
        public int server_port = 25;
        public int nb_group = 4;
        public int size_group = 4;

        public transient List<Prank> pranks = new ArrayList<>();
        public transient List<Person> persons = new ArrayList<>();
    }

    private ConfigData data;

    public Config() {
        readFiles();
    }

    private void readFiles() throws IllegalStateException {
        File confFile = new File(CONFIG_PATH);

        // Use of a toml parser library (toml4j) for the configuration file
        // Sources: https://github.com/mwanji/toml4j
        
        if(!confFile.exists()) {
            confFile.getParentFile().mkdirs();

            try{
                // If the config does not existe, create the default configuration
                confFile.createNewFile();
                this.data = new ConfigData(); 
            
                // and store it
                TomlWriter tomlWriter = new TomlWriter();
                tomlWriter.write(data, confFile);
            }catch (IOException e){}
        }

        try {
            // Read toml file and set data
            this.data = new Toml().read(confFile).to(ConfigData.class);
        }catch(IllegalStateException e) {
            System.err.println(e);
            System.exit(1);
        }

        // Error if the number of groups or the size of groups are too low
        if(this.data.nb_group < 1) {
            System.err.println("The number of groups must be greater than 0.\n The value as been set to 1.");
            this.data.nb_group = 1;
        }
        if(this.data.size_group < 3) {
            System.err.println("The size of groups must be greater than 2.\n The value as been set to 3.");
            this.data.size_group = 3;
        }

        // Read persons file
        data.persons = new ArrayList<>();

        File personsFile = new File(PERSONS_PATH);

        // Create the persons.txt file if not exists
        if(!personsFile.exists()){
            try{
                personsFile.createNewFile();

                FileWriter writer = new FileWriter(personsFile);
                writer.write("# Write one email per line"); 
                writer.close();
            }catch(IOException e) {}
        }

        try {
            // Read the persons.txt file
            BufferedReader reader = new BufferedReader(new FileReader(PERSONS_PATH));

            String line = null;
            while((line = reader.readLine()) != null) {
                if(line.startsWith("#")) continue;
                // only add the person if the line contain a @
                if(!line.contains("@")){
                    System.err.println("Error: missing @ in the email address: " + line);
                    continue;
                }
                
                data.persons.add(new Person(line));
            }

            reader.close();
        }catch(FileNotFoundException e){
            System.err.println(String.format("File \"%s\" not found", PERSONS_PATH));
        }catch(IOException e) {
            System.err.println(String.format("Error while reading file: %s", e.toString()));
        }

        // Read pranks files
        // Each prank is stored in individual file in PRANKS_FOLDER
        // The first line of the file represent the header (Email title)

        data.pranks = new ArrayList<>();
        try {
            File folder = new File(PRANKS_DIR);

            // Create the pranks folder if not exists
            if(!folder.exists()) {
                folder.mkdirs();
            }

            // Read all file inside pranks folder
            for(File prankFile : folder.listFiles()) {
                BufferedReader reader = new BufferedReader(new FileReader(prankFile));

                String prankHeader = "";
                String prankBody = "";
                boolean firstLine = true;

                String line = null;
                while((line = reader.readLine()) != null) {
                    if(firstLine) {
                        prankHeader = line;
                        firstLine = false;
                    }else{
                        prankBody += line + "\n";
                    }
                }
                
                data.pranks.add(new Prank(prankHeader, prankBody));
                reader.close();
            }
        }catch(FileNotFoundException e){
            System.err.println(String.format("Folder \"%s\" not found", PRANKS_DIR));
        }catch(IOException e) {
            System.err.println(String.format("Error while reading file: %s", e.toString()));
        }
    }

    //--- Data getters ---//

    public String getServerIP() {
        return data.server_ip;
    }

    public int getServerPort() {
        return data.server_port;
    }

    public int getNbGroup() {
        return data.nb_group;
    }

    public int getGroupSize() {
        return data.size_group;
    }

    public List<Person> getPersons() {
        return data.persons;
    }

    public List<Prank> getPranks() {
        return data.pranks;
    }
}
