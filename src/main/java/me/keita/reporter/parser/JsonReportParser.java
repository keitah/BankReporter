package me.keita.reporter.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.keita.reporter.model.Transaction;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JsonReportParser extends ReportParser {

    @Override
    protected List<Transaction> extractData(String data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, new TypeReference<List<Transaction>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}