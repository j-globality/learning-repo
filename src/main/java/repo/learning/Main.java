package repo.learning;

import reactor.core.publisher.Mono;

import static repo.learning.file.Operations.runFileOperations;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        Mono<String> res = runFileOperations(fileName);
        res.subscribe(System.out::println);
    }
}
