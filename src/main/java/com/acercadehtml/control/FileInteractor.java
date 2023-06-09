package com.acercadehtml.control;

import java.io.*;

public class FileInteractor {
    public static StringBuilder ReadFile (String path){
        StringBuilder file = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while((line = reader.readLine()) != null){
                file.append(line+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public static void WriteFile(String path, StringBuilder content){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(content.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean CreateFolder(){
        return true;
    }
}
