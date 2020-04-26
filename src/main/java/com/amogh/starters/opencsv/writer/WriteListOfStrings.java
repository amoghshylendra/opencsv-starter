package com.amogh.starters.opencsv.writer;

import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteListOfStrings {

    public static void main(String[] args) throws IOException {
        CSVWriter writer = new CSVWriter(
                new FileWriter("outputfiles/outputfile_using_list_of_strings.csv"),
                ICSVWriter.DEFAULT_SEPARATOR,
                ICSVWriter.NO_QUOTE_CHARACTER,
                '\t',
                "\n");

        List<List<String>> data = new ArrayList<>();
        data.add(List.of("Amogh", "Kudumallige", "Shylendra", "01-01-1988", "Indian"));
        data.add(List.of("Amogh2", "Kudumallige2", "Shylendra2", "02-02-1988", "Indian"));
        data.forEach(dataLine -> writer.writeNext(dataLine.toArray(new String[5])));
        writer.close();
    }
}
