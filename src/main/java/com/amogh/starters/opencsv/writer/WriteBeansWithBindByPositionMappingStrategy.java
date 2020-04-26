package com.amogh.starters.opencsv.writer;

import com.amogh.starters.opencsv.entity.PersonWithOrder;
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

public class WriteBeansWithBindByPositionMappingStrategy {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<PersonWithOrder> persons = new ArrayList<>();
        persons.add(PersonWithOrder.builder().firstName("Amogh").middleName("Kudumallige").lastName("Shylendra").dateOfBirth(LocalDate.of(1988, 1, 1)).nationality("Indian").build());
        persons.add(PersonWithOrder.builder().firstName("Amogh2").middleName("Kudumallige2").lastName("Shylendra2").nationality("Indian").build());

        Writer writer = new FileWriter("outputfiles/outputfile_using_beans_with_CsvBindByPosition_strategy.csv");
        StatefulBeanToCsv<PersonWithOrder> beanToCsv = new StatefulBeanToCsvBuilder<PersonWithOrder>(writer).build();
        beanToCsv.write(persons);
        writer.close();
    }
}
