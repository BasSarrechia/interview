package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parsing {
    public static void main(String[] args) {
    }
}

record WhenCondition(JsonNode predicate1, String op, JsonNode predicate2) {
    @Override
    public String toString() {
        if (op != null && predicate2 != null) {
            ObjectMapper mapper = new ObjectMapper();
            return this.parsePredicate(predicate1, mapper) + " " + op + " " + this.parsePredicate(predicate2, mapper);
        }
        return predicate1.asText();
    }

    String parsePredicate(JsonNode predicate, ObjectMapper mapper) {
        if (predicate.isObject()) {
            return "(" + mapper.convertValue(predicate, WhenCondition.class).toString() + ")";
        }
        return predicate.asText();
    }
}