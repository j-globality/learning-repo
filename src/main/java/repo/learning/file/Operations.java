package repo.learning.file;

import reactor.core.publisher.Mono;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Operations {

    public static Mono<Void> runFileOperations() {
        return Mono.when(createAndWriteToFile())
                .then(createAndWriteToFile())
                .then(readFile())
                .thenEmpty(readFile());
    }

    public static Mono<Void> createAndWriteToFile() {
        return Mono.<Void>fromRunnable(() -> {
            try(FileOutputStream fileOutputStream = new FileOutputStream("newFile.txt")) {
                fileOutputStream.write("testing".getBytes());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        });
    }

    public static Mono<Void> readFile() {
        return Mono.<Void>fromRunnable(() -> {
            try (Scanner scanner = new Scanner("newFile.txt")){
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
