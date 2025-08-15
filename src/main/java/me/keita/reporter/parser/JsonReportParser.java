package me.keita.reporter.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.keita.reporter.model.Transaction;
import java.io.File;
import java.util.List;

public class JsonReportParser extends ReportParser {

    @Override
    protected List<Transaction> extractData(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), new TypeReference<List<Transaction>>() {});
    }
}