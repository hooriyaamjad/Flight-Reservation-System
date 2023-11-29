package com.example.demo.java_classes.connections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FlightConnection {

    public String[] getAllFlights() {
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

   public String[] getSpecificFlight(String id) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/flights/specific" + URLEncoder.encode(id, "UTF-8");

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

    public String[] getFlightPassengers(String id) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/flights/passengers" + URLEncoder.encode(id, "UTF-8");

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

    public String[] getFlightSeatList(String id) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/flight-seat-list/" + URLEncoder.encode(id, "UTF-8");

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

    public void updateOrigin(int id, String new_origin) {
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

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDestination(int id, String new_destination) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/update-destination";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("PUT");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"id\":" + id + ",\"new_destination\":\"" + new_destination + "\"}";

         
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

    public void updateTakeoff(int id, String new_takeoff) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/update-takeoff";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("PUT");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"id\":" + id + ",\"new_takeoff\":\"" + new_takeoff + "\"}";

         
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


    public void updateArrival(int id, String new_arrival) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/update-arrival";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("PUT");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"id\":" + id + ",\"new_arrival\":\"" + new_arrival + "\"}";

         
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

    public void updateAircraft(int id, String new_aircraft) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/update-aircraft";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("PUT");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"id\":" + id + ",\"new_aircraft\":\"" + new_aircraft + "\"}";

         
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

    public void deleteFlight(String id) {
        try {
          
            String nodeServerUrl = "http://localhost:3002/delete-flight/" + URLEncoder.encode(id, "UTF-8");

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


    public void addFlight(int id, String aircraft, String origin, String destination, String start_date, String end_date) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/add-flight";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("POST");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"id\":" + id + ",\"aircraft\":\"" + aircraft + ",\"origin\":\"" + origin + ",\"destination\":\"" + destination + ",\"start_date\":\"" + start_date + ",\"end_date\":\"" + end_date + "\"}";

         
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


    public String[] viewFlightCrew(String id) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/view-flight-crew/" + URLEncoder.encode(id, "UTF-8");

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

    public void addCrewMember(String name, String role, int flight_id) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/add-crew-member";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("POST");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"name\":" + name + ",\"role\":\"" + role + ",\"flight_id\":\"" + flight_id + "\"}";

         
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


    public void removeCrewMember(String name, int id) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/remove-crew-member";

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("DELETE");

          
            connection.setDoOutput(true);

         
            connection.setRequestProperty("Content-Type", "application/json");

           
            String requestBody = "{\"name\":" + name + ",\"flight_id\":\"" + id + "\"}";

         
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

    public String[] getAircrafts() {
        try {
         
           String nodeServerUrl = "http://localhost:3002/view-aircrafts";

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

   public void addAircraft(String name) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/add-aircraft/" + URLEncoder.encode(name, "UTF-8");

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("POST");

        
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



    public void removeAircraft(String name) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/remove-aircraft/" + URLEncoder.encode(name, "UTF-8");

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


    public String[] getMaxFlightID() {
        try {
         
           String nodeServerUrl = "http://localhost:3002/get-max-flight-id";

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


   public void addFlightSeats(String id) {
        try {
        
            String nodeServerUrl = "http://localhost:3002/insert-flight-seats/" + URLEncoder.encode(id, "UTF-8");

            URL url = new URL(nodeServerUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        
            connection.setRequestMethod("POST");

        
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
