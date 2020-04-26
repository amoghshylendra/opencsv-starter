package com.amogh.starters.opencsv.custom;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.NonNull;

public class CustomCsvBindByPosition<T> extends ColumnPositionMappingStrategy<T> {

    public String[] headerNames;

    public CustomCsvBindByPosition(@NonNull String[] headerNames){
        this.headerNames = headerNames;
    }

    public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {
        String[] h = super.generateHeader(bean);
        return headerNames;
    }
}
