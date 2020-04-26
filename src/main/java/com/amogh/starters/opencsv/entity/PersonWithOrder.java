package com.amogh.starters.opencsv.entity;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class PersonWithOrder {
    @CsvBindByPosition(position = 0)
    String firstName;
    @CsvBindByPosition(position = 1)
    String middleName;
    @CsvBindByPosition(position = 2)
    String lastName;
    @CsvBindByPosition(position = 3)
    LocalDate dateOfBirth;
    @CsvBindByPosition(position = 4)
    String nationality;
}
