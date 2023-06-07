package com.example;

import java.util.Optional;

public class Nullability {
    public static void main(String[] args) {

        String nullable = null;
        Nullable nullableObj = new Nullable(null);
        Optional<String> optional = Optional.ofNullable(null);
        NullableFromContract nullableObjFromContract = new NullableFromContract(null);

        assert nullable != null;

        if(nullable != null){
            System.out.println("executed notnull");
        }

        if (optional.isPresent()){
            String s = optional.get();
        }
    }
}

record Nullable(String nullableString){

    void doMagic(String x){}
    Nullable{
        if(nullableString == null) {
            throw new NullPointerException();
        }
    }
}

record NullableFromContract(@org.springframework.lang.NonNull String nullableString){
}
