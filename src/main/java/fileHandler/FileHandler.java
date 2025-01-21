package fileHandler;

import bobAndSteve.BobAndSteve;
import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;
import bobAndSteve.exception.InvalidCommandException;
import bobAndSteve.exception.InvalidCommandFormatException;
import bobAndSteve.exception.ListIndexOutOfBoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileHandler {

    private File file;
    private String filePath;

    public FileHandler(String filePath) throws IOException {
        this.file = new File(filePath);
        if (!file.exists()) {
            File directory = new File("./data");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            file = new File(directory, "bobAndSteve.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        }
    }

    public File loadFile() {
        return file;
    }

    public void writeFile(TaskList taskList) throws IOException {
        try {
            String newData = taskList.toString();
            FileWriter fw = new FileWriter("./data/bobAndSteve.txt");
            fw.write(newData);
            fw.close();
        } catch (IOException error) {
            System.out.println("Error writing file");
        }
    }
}