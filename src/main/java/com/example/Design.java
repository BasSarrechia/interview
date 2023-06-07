package com.example;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Design {
    public static void main(String[] args) {
        FizzbuzzProvider fizzbuzzProvider = new FizzbuzzProvider();
        String fizzbuzz = IntStream.rangeClosed(1, 100)
                .mapToObj(fizzbuzzProvider::calculate)
                .collect(Collectors.joining(" "));

        System.out.println(fizzbuzz);
    }
}

class FizzbuzzProvider {
    public String calculate(int num) {
        Function<Integer, Optional<String>> fizzBuzzStrategy = (number) ->
                number % 15 == 0 ? Optional.of("fizzbuzz") : Optional.empty();
        Function<Integer, Optional<String>> fizzStrategy = (number) ->
                number % 3 == 0 ? Optional.of("fizz") : Optional.empty();
        Function<Integer, Optional<String>> buzzStrategy = (number) ->
                number % 5 == 0 ? Optional.of("buzz") : Optional.empty();

        return Stream.of(
                        fizzBuzzStrategy,
                        fizzStrategy,
                        buzzStrategy
                ).flatMap(strategy -> strategy.apply(num).stream())
                .findFirst().orElseGet(() -> String.valueOf(num));
    }
}