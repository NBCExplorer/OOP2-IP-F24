package com.example.oop2ipf24.Model;


import com.example.oop2ipf24.Model.Client;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClientDataManager {
    private static final String FILE_PATH = "clients.json";
    private static final Gson gson = new Gson();

    public static void saveClients(List<Client> clients) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(clients, writer);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving clients.");
        }
    }

    public static List<Client> loadClients() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type clientListType = new TypeToken<List<Client>>() {}.getType();
            return gson.fromJson(reader, clientListType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Return empty list if file not found
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

