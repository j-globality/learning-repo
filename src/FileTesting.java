import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileTesting {
    public static void main(String[] args) {
        createFile();
        readFile();
    }

    public static void createFile() {
        try(FileOutputStream fileOutputStream = new FileOutputStream("newFile.txt")){
            fileOutputStream.write("testing".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile() {
        try (Scanner scanner = new Scanner(new File("newFile.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

}
