package com.daddywork.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSV implements DataParser {

    @Override
    public List<Map<String, String>> convertToList(InputStream inputStream) throws Exception {
        Reader reader = new InputStreamReader(inputStream);
        CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
        List<CSVRecord> records = csvParser.getRecords();

        List<Map<String, String>> dataList = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);
            if (i == 0) {
                String header1 = record.get(0);
                String header2 = record.get(1);
                continue;
            }
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("id", record.get(0));
            dataMap.put("value", record.get(1));
            dataList.add(dataMap);
        }
        return dataList;
    }
}
