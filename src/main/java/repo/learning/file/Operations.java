package repo.learning.file;

import reactor.core.publisher.Mono;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Operations {

    public static Mono<String> runFileOperations(String fileName) {
        return Mono.when(createAndWriteToFile(fileName))
                .then(readFile(fileName));

    }

    public static Mono<String> createAndWriteToFile(String fileName) {
        return Mono.fromCallable(() -> {
            try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                fileOutputStream.write("testing".getBytes());
                return fileName;
            } catch (IOException e) {
                throw new RuntimeException();
            }
        });
    }

    public static Mono<String> readFile(String file) {
        return Mono.fromCallable(() -> {
            try (Scanner scanner = new Scanner(Path.of(file))){
                return scanner.nextLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
