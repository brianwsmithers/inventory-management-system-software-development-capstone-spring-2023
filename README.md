# inventory-management-system-software-development-capstone-spring-2023

## Installation
1. Clone the master branch of this repository to a location of your choosing.
     <p>i. HTTPS Clone</p>
        
     ```
     git clone https://github.com/brianwsmithers/inventory-management-system-software-development-capstone-spring-2023.git
     ```
     <p>ii. SSH</p>
        
     ```
     git clone git@github.com:brianwsmithers/inventory-management-system-software-development-capstone-spring-2023.git
     ```

## How to Install this Project
1. Download and install Oracle 21c Express Edition and setup on your machine.
    Set the oracle password to whatever you want.
    If you change the password, you will need to edit it in the application.properties file and in the database_credentials text file in the resources folder.

2. Download and install sqldeveloper to use as a GUI to write and run sql scripts

3. Make a connection between the OracleDb and sql. 
    There is a sql script that is already written and is in the sql resources folder so all that is need is to copy and paste the file in sqldeveloper and run the script

## How to Run this Program
Right click on ```InventoryManagementApplication```, click ```run as```, and in the options to run the file select ```Spring Boot App```. Finally,
go to a web browser of your choosing and type in the following ```localhost:8080```.

If using Intellij, run the file ```InventoryManagementSystemApplication```. Once the command line displays the SpringBoot information, open a web browser and type ```localhost:8080``` into the search bar.

