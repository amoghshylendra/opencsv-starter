package com.amogh.starters.opencsv.entity;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Person {
    String firstName;
    String middleName;
    String lastName;
    LocalDate dateOfBirth;
    String nationality;
}
