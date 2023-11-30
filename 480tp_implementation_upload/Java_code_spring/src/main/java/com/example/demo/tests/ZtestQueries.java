// java -cp mysql-connector-j-8.2.0.jar TestQueries.java
// mysql-connector-j-8.2.0.jar must be in same directory as TestQueries.java

package com.example.demo.tests;

import java.sql.*;

public class ZtestQueries {

    private Connection dbConnect;
    private ResultSet results;

    public ZtestQueries() {
        createConnection();
        runTestQuery();
        close();
    }

    public void createConnection(){
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/AIRLINECOMPANY", "root", "password");
        }
        catch (SQLException e){
            System.err.println("Error occurred while establishing database connection");
            e.printStackTrace();   
        }
    }

    public void close(){
        try{
            results.close();
            dbConnect.close();
        } catch (SQLException e){
            System.err.println("Error occurred while closing database connection");
            e.printStackTrace();
        }
    }

    public void runTestQuery(){
        try {

            if (dbConnect == null) {
                System.out.println("db connect was null");
                return;
            }

            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM FLIGHT");

            System.out.println("results:");
            
            for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
                System.out.print(results.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            // Iterate through the result set and print each row
            while (results.next()) {
                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
                    System.out.print(results.getString(i) + "\t");
                }
                System.out.println();
            }

            /* 
            while (results.next()){
                int animalID = results.getInt("AnimalID");
                String animalName = results.getString("AnimalNickname");
                String animalSpecies = results.getString("AnimalSpecies");
                    
                Animal animal = new Animal(animalID, animalName, animalSpecies);
                this.animalList.add(animal);
            }
            */

            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error occurred while querying");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZtestQueries queryTest = new ZtestQueries();
        System.out.println(queryTest);
    }


}