/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import model.Paciente;

/**
 *
 * @author matheusnascimento
 */
public class PacienteController {

    public Paciente paciente;

    public PacienteController() {
        paciente = new Paciente();
    }

    public boolean createPaciente(String baseUrl, String json) {
        try {
            URL url = new URL(baseUrl + "paciente");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("Accept", "*/*");
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.addRequestProperty("Content-Length", "" + json.length());
            connection.setRequestMethod("POST");
            System.out.println(json.length());
            connection.setDoOutput(true);
            connection.connect();
            OutputStream writer = connection.getOutputStream();
            writer.write((json + "\n").getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("client read " + line);
            }
            reader.close();
            int responseCode = connection.getResponseCode();
            System.out.println("response code=" + responseCode);
            System.out.println("Client exiting");
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateGravidadePaciente(String baseUrl, String json) {
        try {
            URL url = new URL(baseUrl + "paciente/status");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("Accept", "*/*");
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.addRequestProperty("Content-Length", "" + json.length());
            connection.setRequestMethod("PUT");
            System.out.println(json.length());
            connection.setDoOutput(true);
            connection.connect();
            OutputStream writer = connection.getOutputStream();
            writer.write((json + "\n").getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("client read " + line);
            }
            reader.close();
            int responseCode = connection.getResponseCode();
            System.out.println("response code=" + responseCode);
            System.out.println("Client exiting");
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public Paciente[] listPaciente(String baseUrl) {
        try {
            URL url = new URL(baseUrl + "medico/pacientes?sort=true");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("Accept", "*/*");
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestMethod("GET");
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder jsonBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();
            int responseCode = connection.getResponseCode();
            Gson gson = new Gson(); // Or use new GsonBuilder().create();

            Paciente[] pacientes = gson.fromJson(jsonBuilder.toString(), Paciente[].class);
            System.out.println("Client exiting");
            return pacientes;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Paciente getPaciente(String baseUrl, String json) {
        try {
            URL url = new URL(baseUrl + "paciente?cpf=" + json);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("Accept", "*/*");
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestMethod("GET");
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder jsonBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            System.out.println(jsonBuilder.toString());

            Paciente paciente = gson.fromJson(jsonBuilder.toString(), Paciente.class);
            int responseCode = connection.getResponseCode();
            System.out.println("response code=" + responseCode);
            System.out.println("Client exiting");
            return paciente;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    

}
