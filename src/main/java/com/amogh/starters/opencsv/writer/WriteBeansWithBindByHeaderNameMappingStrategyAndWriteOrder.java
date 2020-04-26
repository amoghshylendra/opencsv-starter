package com.amogh.starters.opencsv.writer;

import com.amogh.starters.opencsv.entity.PersonWithHeaderName;
import com.amogh.starters.opencsv.utils.OrderComparator;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
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

public class WriteBeansWithBindByHeaderNameMappingStrategyAndWriteOrder {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<PersonWithHeaderName> persons = new ArrayList<>();
        persons.add(PersonWithHeaderName.builder().firstName("Amogh").middleName("Kudumallige").lastName("Shylendra").dateOfBirth(LocalDate.of(1988, 1, 1)).nationality("Indian").build());
        persons.add(PersonWithHeaderName.builder().firstName("Amogh2").middleName("Kudumallige2").lastName("Shylendra2").nationality("Indian").build());

        Writer writer = new FileWriter("outputfiles/outputfile_using_beans_with_CsvBindByName_strategy_and_column_order.csv");

        // build mapping strategy with column order
        HeaderColumnNameMappingStrategy<PersonWithHeaderName> mappingStrategy = new HeaderColumnNameMappingStrategy<>();
        mappingStrategy.setType(PersonWithHeaderName.class);
        mappingStrategy.setColumnOrderOnWrite(new OrderComparator());

        // create bean to CSV using the above mapping strategy
        StatefulBeanToCsv<PersonWithHeaderName> beanToCsv = new StatefulBeanToCsvBuilder<PersonWithHeaderName>(writer)
                .withMappingStrategy(mappingStrategy)
                .withQuotechar(ICSVWriter.NO_QUOTE_CHARACTER)
                .build();
        beanToCsv.write(persons);
        writer.close();
    }
}
