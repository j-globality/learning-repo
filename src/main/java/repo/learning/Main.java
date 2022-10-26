package repo.learning;

import reactor.core.publisher.Mono;

import static repo.learning.file.Operations.runFileOperations;

public class Main {
    public static void main(String[] args) {
        Mono<Void> res = runFileOperations();
        res.subscribe();
    }
}
