package com.amogh.starters.opencsv.utils;

import java.util.Comparator;
import java.util.List;

public class OrderComparator implements Comparator<String> {

    public static List<String> preDefinedHeaderList = List.of("FIRST NAME", "MIDDLE NAME", "LAST NAME", "DATE OF BIRTH", "NATIONALITY");

    @Override
    public int compare(String headerName1, String headerName2) {
        return preDefinedHeaderList.indexOf(headerName2) - preDefinedHeaderList.indexOf(headerName1);
    }
}
