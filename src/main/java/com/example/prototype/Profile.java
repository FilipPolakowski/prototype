package com.example.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Profile {
    private String fridge;

    public static ArrayList<Product> seeItems() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\fridge.txt");
        Scanner query = new Scanner(file);
        ArrayList<Product> answer = new ArrayList<>();
        while(query.hasNextLine()){
            Scanner scanner = new Scanner(query.nextLine());
            scanner.useDelimiter(",");
            if(scanner.hasNext()) {
                Product product = Database.getProduct(scanner.next());
                if (scanner.hasNext()) {
                    product.setQuantity(Double.parseDouble(scanner.next()));
                }
                answer.add(product);
            }
        }
        return answer;
    }


    public static void addItems(String name, double quantity) throws IOException {
        ArrayList<Product> products = seeItems();
        for (Product product:products) {
            if(product.name.equalsIgnoreCase(name)){
                product.inqQuantity(quantity);
                saveItems(products);
                return;
            }
        }
        Product newProduct = Database.getProduct(name);
        newProduct.setQuantity(quantity);
        products.add(newProduct);
        saveItems(products);
    }

    private static void saveItems(ArrayList<Product> products) throws IOException {
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\fridge.txt");

        PrintWriter writer = new PrintWriter(file);

        for (Product product:products) {
            if(product.quantity>0) {
                writer.println(product.toString() + ",");

            }
        }
        writer.close();



    }
    static void deleteProduct(boolean isThrown, Product product, double quantity) throws IOException {
        ArrayList<Product> products = seeItems();
        for (Product producta:products) {
            if(producta.name.equalsIgnoreCase(product.name)){
                if(isThrown){
                    producta.setQuantity(-1);
                }
                producta.inqQuantity(-1*quantity);
                saveItems(products);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        addItems("eggs",40);
    }
}
