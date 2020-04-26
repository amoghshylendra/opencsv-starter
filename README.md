#OpenCSV Starter
### Code samples to read/write csv files easily using OpenCSV library

_Version used_: 5.1

###Write CSV files

_**Write CSV with list of strings**_

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

_**Write CSV with Java Beans**_

    Writer writer = new FileWriter("outputfiles/outputfile_using_beans_with_default_strategy.csv");
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer).build();
            beanToCsv.write(persons);
            writer.close();

       