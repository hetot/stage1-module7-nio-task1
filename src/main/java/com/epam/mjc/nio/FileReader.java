package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile result;
        Path path = Paths.get(file.getPath());
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String name = reader.readLine().split(": ")[1];
            int age = Integer.parseInt(reader.readLine().split(": ")[1]);
            String email = reader.readLine().split(": ")[1];
            long phone = Long.parseLong(reader.readLine().split(": ")[1]);
            result = new Profile(name, age, email, phone);
            try {
                reader.close();
            } catch (Exception e) {
                result = null;
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }
}
