package com.example.demo.java_classes.connections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RegisteredUserConnection {

    public String[] getRegisteredUserInfo(String email) {
        try {
          
            String nodeServerUrl = "http://localhost:3002/registered-users/" + URLEncoder.encode(email, "UTF-8");

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

          
            connection.setRequestMethod("GET");

         
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

           
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

      
            System.out.println("Response from Node.js server: " + response.toString());

            System.out.println("\n\nresults as an array:");
            String str_res = response.toString();
            str_res = str_res.substring(1, str_res.length() - 1);
            String[] results_arr = str_res.split("\\{");
            for (int i = 0; i < results_arr.length; i++) {
                int last_index = results_arr[i].lastIndexOf("}");
                if (last_index != -1) {
                    results_arr[i] = results_arr[i].substring(0, last_index);
                }
                System.out.println(results_arr[i]);
            }
            System.out.println("\n\n");

      
            connection.disconnect();

            return results_arr;

        } catch (Exception e) {
            e.printStackTrace();
            String[] empty_arr = new String[0];
            return empty_arr;
        }
    }

    public void createMembership(String email, String name, String address, String membership, String card, String benefits) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/new-membership";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("POST");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"email\":" + email + ",\"name\":\"" + name + ",\"address\":\"" + address + ",\"membership\":\"" + membership + ",\"card\":\"" + card + ",\"benefits\":\"" + benefits + "\"}";

         
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

        
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

      
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response from Node.js server: " + response.toString());

            System.out.println("\n\nresults as an array:");
            String str_res = response.toString();
            str_res = str_res.substring(1, str_res.length() - 1);
            String[] results_arr = str_res.split("\\{");
            for (int i = 0; i < results_arr.length; i++) {
                int last_index = results_arr[i].lastIndexOf("}");
                if (last_index != -1) {
                    results_arr[i] = results_arr[i].substring(0, last_index);
                }
                System.out.println(results_arr[i]);
            }
            System.out.println("\n\n");

       
            connection.disconnect();


            
        } catch (Exception e) {
            e.printStackTrace();
  
        }
    }

    public void deleteMembership(String email) {
        try {
          
            String nodeServerUrl = "http://localhost:3002/delete-user-membership/" + URLEncoder.encode(email, "UTF-8");

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

          
            connection.setRequestMethod("DELETE");

         
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

           
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

      
            System.out.println("Response from Node.js server: " + response.toString());

            System.out.println("\n\nresults as an array:");
            String str_res = response.toString();
            str_res = str_res.substring(1, str_res.length() - 1);
            String[] results_arr = str_res.split("\\{");
            for (int i = 0; i < results_arr.length; i++) {
                int last_index = results_arr[i].lastIndexOf("}");
                if (last_index != -1) {
                    results_arr[i] = results_arr[i].substring(0, last_index);
                }
                System.out.println(results_arr[i]);
            }
            System.out.println("\n\n");

      
            connection.disconnect();



        } catch (Exception e) {
            e.printStackTrace();
  
        }
    }



    public String[] getAllRegisteredUsers() {
        try {
         
           String nodeServerUrl = "http://localhost:3002/view-all-registered-users";

           URL url = new URL(nodeServerUrl);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();

     
           connection.setRequestMethod("GET");

   
           int responseCode = connection.getResponseCode();
           System.out.println("Response Code: " + responseCode);

       
           BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           String line;
           StringBuffer response = new StringBuffer();

           while ((line = reader.readLine()) != null) {
               response.append(line);
           }
           reader.close();

           System.out.println("Response from Node.js server: " + response.toString());

           System.out.println("\n\nresults as an array:");
           String str_res = response.toString();
           str_res = str_res.substring(1, str_res.length() - 1);
           String[] results_arr = str_res.split("\\{");
           for (int i = 0; i < results_arr.length; i++) {
               int last_index = results_arr[i].lastIndexOf("}");
               if (last_index != -1) {
                   results_arr[i] = results_arr[i].substring(0, last_index);
               }
               System.out.println(results_arr[i]);
           }
           System.out.println("\n\n");

  
           connection.disconnect();

           return results_arr;

       } catch (Exception e) {
           e.printStackTrace();
           String[] empty_arr = new String[0];
           return empty_arr;
       }

   }


   public void removeRegisteredUser(String email) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/remove-registered-user/" + URLEncoder.encode(email, "UTF-8");

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("DELETE");

        
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

        
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            System.out.println("Response from Node.js server: " + response.toString());

            System.out.println("\n\nresults as an array:");
            String str_res = response.toString();
            str_res = str_res.substring(1, str_res.length() - 1);
            String[] results_arr = str_res.split("\\{");
            for (int i = 0; i < results_arr.length; i++) {
                int last_index = results_arr[i].lastIndexOf("}");
                if (last_index != -1) {
                    results_arr[i] = results_arr[i].substring(0, last_index);
                }
                System.out.println(results_arr[i]);
            }
            System.out.println("\n\n");


            connection.disconnect();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }



    


    
}
