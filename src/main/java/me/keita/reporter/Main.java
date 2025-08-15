package me.keita.reporter;

import me.keita.reporter.model.Transaction;
import me.keita.reporter.parser.CsvReportParser;
import me.keita.reporter.parser.JsonReportParser;
import me.keita.reporter.parser.ReportParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            URL csvUrl = Main.class.getClassLoader().getResource("example.csv");
            URL jsonUrl = Main.class.getClassLoader().getResource("example.json");
            if (csvUrl == null || jsonUrl == null) throw new Exception("Resources not found!");

            BigDecimal initialBalance = new BigDecimal("1000.00");

            processReport(new CsvReportParser(), csvUrl.getPath(), initialBalance, "CSV");
            processReport(new JsonReportParser(), jsonUrl.getPath(), initialBalance, "JSON");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processReport(ReportParser parser, String path, BigDecimal initialBalance, String label) {
        try {
            List<Transaction> transactions = parser.parse(path);
            BigDecimal balance = initialBalance;
            BigDecimal income = BigDecimal.ZERO;
            BigDecimal expense = BigDecimal.ZERO;

            System.out.println("\n" + label + " Transactions:");

            for (Transaction t : transactions) {
                BigDecimal amt = t.getAmount();
                if (amt.compareTo(BigDecimal.ZERO) >= 0) expense = expense.add(amt);
                else income = income.add(amt.abs());

                balance = balance.subtract(amt);
                t.setBalanceAfter(balance);

                System.out.println(t);
            }

            System.out.println("\n" + label + " summary: Initial=" + initialBalance +
                    ", Income=" + income + ", Expense=" + expense + ", Final=" + balance);

            saveCsv(transactions, label.toLowerCase() + "_output.csv");
            saveJson(transactions, label.toLowerCase() + "_output.json");

        } catch (Exception e) {
            System.err.println("Error processing " + label + " report: " + e.getMessage());
        }
    }

    private static void saveCsv(List<Transaction> transactions, String fileName) {
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            writer.write("account,description,amount,balanceAfter\n");
            for (Transaction t : transactions)
                writer.write(String.format("%s,%s,%s,%s\n",
                        t.getAccount(), t.getDescription(), t.getAmount(), t.getBalanceAfter()));
        } catch (Exception e) { System.err.println("CSV save error: " + e.getMessage()); }
    }

    private static void saveJson(List<Transaction> transactions, String fileName) {
        try {
            new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(new File(fileName), transactions);
        } catch (Exception e) { System.err.println("JSON save error: " + e.getMessage()); }
    }
}