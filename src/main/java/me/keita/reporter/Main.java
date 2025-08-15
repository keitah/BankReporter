package me.keita.reporter;

import me.keita.reporter.model.Transaction;
import me.keita.reporter.parser.CsvReportParser;
import me.keita.reporter.parser.JsonReportParser;
import me.keita.reporter.parser.ReportParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReportParser csvParser = new CsvReportParser();
        List<Transaction> csvTransactions = csvParser.parseFromResource("transactions.csv");
        System.out.println("CSV parsed:");
        csvTransactions.forEach(System.out::println);

        ReportParser jsonParser = new JsonReportParser();
        List<Transaction> jsonTransactions = jsonParser.parseFromResource("transactions.json");
        System.out.println("JSON parsed:");
        jsonTransactions.forEach(System.out::println);
    }
}