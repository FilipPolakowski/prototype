package com.example.prototype;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    double quantity = 0;
    String name = "404";
    String url = "aaa";
    ArrayList<Double> minerals = new ArrayList<>();
    ArrayList<Double> vitamins = new ArrayList<>();
    public Product(String name, ArrayList<Double> minerals, ArrayList<Double> vitamins){
        this.name=name;
        this.url=System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\photos"+name+".jpg";
        this.minerals = minerals;
        this.vitamins = vitamins;
    }



    public void addProduct(double howMuch){
        this.quantity+=howMuch;
    };

    public void removeProduct(double howMuch){
        this.quantity -= howMuch;
    }

    public String toString(){
        return(name+","+quantity);
    }

    public Image getImage(){
        System.out.println(url);
        return new Image(url);
    }

    public double getQuantity(){
        return quantity;
    }
    public String toCSV(){
        String answer = "";
        answer+=name+",";
        for (int i = 0; i < minerals.size(); i++) {
            answer+=minerals.get(i)+",";
        }
        for (int i = 0; i < vitamins.size(); i++) {
            answer+=vitamins.get(i)+",";
        }
        return answer;
    }

    public Product(String csv){
        Scanner reader = new Scanner(csv);
        reader.useDelimiter(",");
        int counter = 0;
        while(reader.hasNext()) {

            if(counter==0){
                this.name = reader.next();
                counter++;
                continue;
            }
            if(counter<11){
                this.minerals.add(Double.valueOf(reader.next()));
                counter++;
                continue;
            }
            counter++;
            this.vitamins.add(Double.valueOf(reader.next()));
            this.url=System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\photos\\"+name+".png";

        }

    }

    public static void main(String[] args) {
        ArrayList<Double> minerals = new ArrayList<>();
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);
        minerals.add(0.2);

        ArrayList<Double> vitamins = new ArrayList<>();
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);
        vitamins.add(0.4);

        Product product = new Product("carrot",minerals, vitamins);
        System.out.println(product.toCSV());

        Product product2 = new Product(product.toCSV());
        System.out.println(product2.toCSV());
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public void inqQuantity(double quantity) {
        this.quantity += quantity;
    }
}
