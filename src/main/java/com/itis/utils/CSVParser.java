package com.itis.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.*;

public interface CSVParser {

    List<String> CSVFormats = Arrays.asList(
            "application/vnd.ms-excel",
            "text/csv");

    static <T> Set<T> parse(final byte[] data, Class<? extends T> $class) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Iterator<CSVRecord> iterator =
                org.apache.commons.csv.CSVParser.parse(new String(data), CSVFormat.DEFAULT).iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final CSVRecord headers = iterator.next();
        final Set<T> res = new HashSet<>();
        while (iterator.hasNext()) {
            CSVRecord record = iterator.next();
            final Map<String, String> values = new HashMap<>();
            for (int i = 0; i < headers.size(); i++) {
                values.put(headers.get(i), record.get(i));
            }
            res.add(objectMapper.convertValue(values, $class));
        }
        return res;
    }
}