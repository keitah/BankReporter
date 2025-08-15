package me.keita.reporter.parser;

import me.keita.reporter.model.Transaction;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvReportParser extends ReportParser {

    @Override
    protected List<Transaction> extractData(String path) throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        for (String line : FileUtils.readLines(new File(path), "UTF-8")) {
            if (line.startsWith("account") || line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            String account = parts[0].trim();
            String desc = parts[1].trim();
            BigDecimal amount = new BigDecimal(parts[2].trim());
            transactions.add(new Transaction(account, desc, amount));
        }
        return transactions;
    }
}