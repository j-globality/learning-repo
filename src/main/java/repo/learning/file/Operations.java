package repo.learning.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        createFile();
        readFile();
    }

    public static void createFile() {
        try(FileOutputStream fileOutputStream = new FileOutputStream("testFiles/newFile.txt")){
            fileOutputStream.write("testing".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile() {
        try (Scanner scanner = new Scanner(new File("testFiles/newFile.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
