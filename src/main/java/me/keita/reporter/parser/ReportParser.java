package me.keita.reporter.parser;

import me.keita.reporter.model.Transaction;
import java.util.Collections;
import java.util.List;

public abstract class ReportParser {
    public List<Transaction> parse(String path) {
        try {
            return extractData(path);
        } catch (Exception e) {
            System.err.println("Error parsing file: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    protected abstract List<Transaction> extractData(String path) throws Exception;
}