package com.example.prototype;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {


    public static Product getProduct(String name) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\allproductscvsv.txt");
        Scanner database = new Scanner(file);
        while(database.hasNextLine()){
            Scanner worker = new Scanner(database.nextLine());
            if(worker.hasNext()){
                String cheater = worker.nextLine();
                Scanner scanner = new Scanner(cheater);
                scanner.useDelimiter(",");
                if(scanner.hasNext()){
                    if(scanner.next().equalsIgnoreCase(name)){
                        return new Product(cheater);
                    }
                }
            }
        }
        return null;
    }

    static ArrayList<Product> seeItems() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\allproductscvsv.txt");
        Scanner query = new Scanner(file);
        ArrayList<Product> answer = new ArrayList<>();
        while(query.hasNextLine()){
            Scanner scanner = new Scanner(query.nextLine());
            scanner.useDelimiter(",");
            if(scanner.hasNext()) {
                Product product = Database.getProduct(scanner.next());
                answer.add(product);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getProduct("carrot").toCSV());
    }
}
