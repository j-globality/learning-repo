import java.io.FileOutputStream;
import java.io.IOException;

public class FileTesting {
    public static void main(String[] args) {
        createFile();
    }

    public static void createFile() {
        try(FileOutputStream fileOutputStream = new FileOutputStream("newFile")){
            fileOutputStream.write("testing".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
