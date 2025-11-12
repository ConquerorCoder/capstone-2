package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public void saveReceipt(Order order) {
        String folderPath = "src/main/resources/receipts";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = now.format(formatter);
        String filename = folderPath + "/" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write("Papa Christians Pizzeria\n");
            writer.write("--------------------------\n");
            writer.write("Customer: " + order.getCustomerName() + "\n");
            writer.write("Date/Time: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("------------------------------------\n");

            for (OrderItem item : order.getItems()) {
                writer.write(String.format("%-30s $%6.2f\n", item.getDescription(), item.getPrice()));
            }

            writer.write("------------------------------------\n");
            writer.write(String.format("%-30s $%6.2f\n", "TOTAL:", order.getTotalPrice()));
            writer.write("====================================\n");
            writer.write("   Thank you for your order!\n");
            writer.write("====================================\n");

            System.out.println("Receipt saved successfully: " + filename);

        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}