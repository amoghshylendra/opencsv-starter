package com.amogh.starters.opencsv.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class PersonWithHeaderName {

    @CsvBindByName(column = "First Name")
    String firstName;
    @CsvBindByName(column = "Middle Name")
    String middleName;
    @CsvBindByName(column = "Last Name")
    String lastName;
    @CsvBindByName(column = "Date Of Birth")
    LocalDate dateOfBirth;
    @CsvBindByName(column = "Nationality")
    String nationality;
}
