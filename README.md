# DAI Labo4 - Report

Authors: Joris Décoppet, Dorian Niclass

---

## Description
This project is an implementation of an SMTP server in Java. It as been made for the DAI course at HEIG-VD. It's a server that can send emails containing a prank message to a list of victims.
The list of victims is read from a file, and the list of prank messages is read from another file. The server is configured with a configuration file.

## Mock Server

## Instructions
To test the server we used an SMTP mock server. It's a server that will receive the emails and display them in a web interface. It's very useful to test the server without sending real emails.

### Setting up mockmock

You may need a mock server to test the application.  
We used this docker image of mockmock : https://hub.docker.com/r/mmoayyed/mockmock

First we need to pull the docker image  
```docker pull mmoayyed/mockmock```

Then we need to start it  
```docker run -d -p 25:25000 -p 8282:8282 --name mockmock mmoayyed/mockmock```

### Setting up the PrankGenerator
To use our application your need to make somme changes in the files.
- The configuration file is located at the root of the project in the folder **configs**. You have to set the **server_ip** as your mock server ip. You should change the **server_port** too. The parameter **nb_group** should be higher thant 0 ans it's the number of groups the programme will generate. The **size_group** parameter is used to specify the number of person in each group. Containing the sender and all the victims. This number should be higher than 2.
- 

## Implementations

### UML

### Our approach