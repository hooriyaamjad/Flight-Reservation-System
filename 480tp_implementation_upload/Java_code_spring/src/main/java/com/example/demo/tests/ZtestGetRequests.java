package com.example.demo.tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



public class ZtestGetRequests {

    public String[] testRequestNone() {
         try {
          
            String nodeServerUrl = "http://localhost:3002/flights/all";

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












    public String[] testRequestWithParams(String email) {
        try {
          
            String nodeServerUrl = "http://localhost:3002/user/flights/" + URLEncoder.encode(email, "UTF-8");

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













    public String[] testRequestWithBody(int id, String new_origin) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/update-origin";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("PUT");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"id\":" + id + ",\"new_origin\":\"" + new_origin + "\"}";

         
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

            return results_arr;
            
        } catch (Exception e) {
            e.printStackTrace();
            String[] empty_arr = new String[0];
            return empty_arr;
        }
    }

    public static void main(String[] args) {
        ZtestGetRequests test_requests = new ZtestGetRequests();
        test_requests.testRequestNone();
    }
}