package storage;

import bobAndSteve.TaskList;
import bobAndSteve.exception.BobAndSteveException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public File load() throws BobAndSteveException {
        try {
            File file = new File(filePath);
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
            return file;
        } catch (IOException error) {
            throw new BobAndSteveException("Failed to load or create the file. Please check file path permissions and ensure the 'data' directory is accessible.");
        }
    }

    public void writeFile(TaskList taskList) {
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