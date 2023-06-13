package com.example.prueba4.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVREADER {

    private String filePath;

    public CSVREADER(String filePath) {
        this.filePath = filePath;
    }

    public boolean checkCityExists(String city) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Comprobar si el campo de la ciudad coincide con el valor proporcionado
                if (fields.length > 0 && fields[0].equalsIgnoreCase(city)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void readCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en campos utilizando coma como delimitador
                String[] fields = line.split(",");

                // Procesar los campos según sea necesario
                for (String field : fields) {
                    System.out.println(field);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
