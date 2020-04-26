package com.amogh.starters.opencsv.writer;

import com.amogh.starters.opencsv.entity.Person;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WriteBeansWithDefaultMappingStrategy {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<Person> persons = new ArrayList<>();
        persons.add(Person.builder().firstName("Amogh").middleName("Kudumallige").lastName("Shylendra").dateOfBirth(LocalDate.of(1988, 1, 1)).nationality("Indian").build());
        persons.add(Person.builder().firstName("Amogh2").middleName("Kudumallige2").lastName("Shylendra2").nationality("Indian").build());

        Writer writer = new FileWriter("outputfiles/outputfile_using_beans_with_default_strategy.csv");
        StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer).build();
        beanToCsv.write(persons);
        writer.close();
    }
}
