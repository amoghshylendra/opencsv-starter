package com.amogh.starters.opencsv.writer;

import com.amogh.starters.opencsv.custom.CustomCsvBindByPosition;
import com.amogh.starters.opencsv.entity.PersonWithHeaderName;
import com.amogh.starters.opencsv.entity.PersonWithOrder;
import com.amogh.starters.opencsv.utils.OrderComparator;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
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

public class WriteBeansWithCustomHeaderNames {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<PersonWithOrder> persons = new ArrayList<>();
        persons.add(PersonWithOrder.builder().firstName("Amogh").middleName("Kudumallige").lastName("Shylendra").dateOfBirth(LocalDate.of(1988, 1, 1)).nationality("Indian").build());
        persons.add(PersonWithOrder.builder().firstName("Amogh2").middleName("Kudumallige2").lastName("Shylendra2").nationality("Indian").build());

        Writer writer = new FileWriter("outputfiles/outputfile_using_beans_with_custom_header_names.csv");

        // build mapping strategy with custom column headers
        String[] customHeaderNames = new String[]{"First Name - Custom", "Middle Name - Custom", "Last name - Custom", "Date Of Birth - Custom", "Nationality - Custom"};
        CustomCsvBindByPosition<PersonWithOrder> mappingStrategy = new CustomCsvBindByPosition<>(customHeaderNames);
        mappingStrategy.setType(PersonWithOrder.class);

        // create bean to CSV using the above mapping strategy
        StatefulBeanToCsv<PersonWithOrder> beanToCsv = new StatefulBeanToCsvBuilder<PersonWithOrder>(writer)
                .withMappingStrategy(mappingStrategy)
                .withQuotechar(ICSVWriter.NO_QUOTE_CHARACTER)
                .build();
        beanToCsv.write(persons);
        writer.close();
    }
}
