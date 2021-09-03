package com.example.springbootkaratedemo.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Book {
    @NonNull
    String title;
    double price;
}
