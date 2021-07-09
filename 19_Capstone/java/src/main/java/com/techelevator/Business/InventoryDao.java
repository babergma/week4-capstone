package com.techelevator.Business;

import com.techelevator.food.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

public class InventoryDao {
    private static HashMap<String, Item> inventoryMap;

    public static Map<String, Item> createMapItems() {
        String path = "vendingmachine.csv";
        inventoryMap = new HashMap<>();
        try {
            // Get the path of the input file
            File vendingFile;
            while (true) {
                // Validate the input file
                vendingFile = new File(path);
                if (vendingFile.exists() == false) {
                    System.out.println(path + " does not exist");
                    continue;
                } else if (vendingFile.isFile() == false) {
                    System.out.println(path + " is not a file");
                    continue;
                }
                break;
            }
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String line;
                while ((line = reader.readLine()) != null) {
//                    String line = fileScanner.nextLine();
                    String[] parts = line.split("\\|");
//                    if (parts.length <= 4) {
                        String code = parts[0];
                        String name = parts[1];
                        String priceString = parts[2];
                        String category = parts[3];

                        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(priceString));
                        if (category.equals("Chip")) {
                            Chip chip = new Chip(name, price, code, 5, category);
                            inventoryMap.put(code, chip);
                            //  System.out.println(inventoryMap);
                        } else if (category.equals("Candy")) {
                            Candy candy = new Candy(name, price, code, 5, category);
                            inventoryMap.put(code, candy);
                            System.out.println(inventoryMap);
                        } else if (category.equals("Drink")) {
                            Drink drink = new Drink(name, price, code, 5, category);
                            inventoryMap.put(code, drink);
                            //      System.out.println(inventoryMap);
                        } else if (category.equals("Gum")) {
                            Gum gum = new Gum(name, price, code, 5, category);
                            inventoryMap.put(code, gum);
                            //      System.out.println(inventoryMap);
                        }

                    }
//                }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
//        System.out.println(inventoryMap);
        return inventoryMap;
    }
}
