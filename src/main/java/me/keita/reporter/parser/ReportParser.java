package me.keita.reporter.parser;

import me.keita.reporter.model.Transaction;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public abstract class ReportParser {

    protected abstract List<Transaction> extractData(String data);

    public List<Transaction> parseFromResource(String resourceName) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (is == null) {
                System.out.println("Resource not found: " + resourceName);
                return Collections.emptyList();
            }
            String data = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            return this.extractData(data);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}