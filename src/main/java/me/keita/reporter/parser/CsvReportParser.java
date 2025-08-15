package me.keita.reporter.parser;

import me.keita.reporter.model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvReportParser extends ReportParser {

    @Override
    protected List<Transaction> extractData(String data) {
        List<Transaction> transactions = new ArrayList<>();
        String[] lines = data.split("\\r?\\n");

        for (int i = 1; i < lines.length; i++) { // пропускаем заголовок
            String line = lines[i].trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length < 3) continue;

            String account = parts[0].trim();
            String description = parts[1].trim();
            BigDecimal amount = new BigDecimal(parts[2].trim());

            transactions.add(new Transaction(account, description, amount));
        }

        return transactions;
    }
}