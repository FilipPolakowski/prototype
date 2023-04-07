package com.example.prototype;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private static Group fridgeGroup = new Group();
    private static Group mainGroup = new Group();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 430, 932);

        Text text = new Text("Recipe of the day");
        text.setX(60);
        text.setY(635);
        text.setFont(Font.font(38));
        text.setFill(Color.web("#707070"));
        scene.setFill(Color.web("#2D3028"));

        Text text2 = new Text("Compound butter");
        text2.setX(156);
        text2.setY(670);
        text2.setFont(Font.font(15));
        text2.setFill(Color.web("#707070"));

        Text text3 = new Text("Fridge");
        text3.setX(76);
        text3.setY(314);
        text3.setFont(Font.font(20));
        text3.setFill(Color.web("#707070"));

        Text text4 = new Text("Recipes");
        text4.setX(286);
        text4.setY(314);
        text4.setFont(Font.font(20));
        text4.setFill(Color.web("#707070"));

        mainGroup.getChildren().add(new ImageView(new Image("C:\\Users\\Felipe\\Desktop\\prototype\\src\\main\\java\\com\\example\\prototype\\img_1.png")));
        ImageView fridge = new ImageView(new Image("C:\\Users\\Felipe\\Desktop\\prototype\\src\\main\\java\\com\\example\\prototype\\image-removebg-preview.png"));
        fridge.setX(-18);
        fridge.setY(332);
        fridge.setPreserveRatio(true);
        fridge.setFitHeight(244);
        fridge.setFitWidth(244);

        ImageView soup = new ImageView(new Image("C:\\Users\\Felipe\\Desktop\\prototype\\src\\main\\java\\com\\example\\prototype\\image-removebg-preview (1).png"));
        soup.setX(222);
        soup.setY(387);
        soup.setPreserveRatio(true);
        soup.setFitHeight(140);
        soup.setFitWidth(211);


        ImageView dishOfTheDay = new ImageView(new Image("C:\\Users\\Felipe\\Desktop\\prototype\\src\\main\\java\\com\\example\\prototype\\img.png"));
        dishOfTheDay.setX(-11);
        dishOfTheDay.setY(700);
        dishOfTheDay.setPreserveRatio(true);
        dishOfTheDay.setFitHeight(497);
        dishOfTheDay.setFitWidth(496);

        scene.setRoot(mainGroup);
        Rectangle rectangle = new Rectangle(211,285);
        rectangle.setY(285);

        Rectangle rectangle2 = new Rectangle(211,285);
        rectangle2.setY(285);
        rectangle2.setX(220);

        rectangle2.setFill(Color.web("#BDC5CC"));



        Rectangle rectangle3 = new Rectangle(433,380);
        rectangle3.setY(582);

        rectangle3.setFill(Color.web("#BDC5CC"));

        rectangle.setFill(Color.web("#BDC5CC"));
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showFridge(stage, scene, mainGroup);
            }
        });
        mainGroup.getChildren().add(rectangle);

        mainGroup.getChildren().add(rectangle2);


        mainGroup.getChildren().add(rectangle3);
        mainGroup.getChildren().add(soup);

        mainGroup.getChildren().add(fridge);
        mainGroup.getChildren().add(dishOfTheDay);


        mainGroup.getChildren().add(text);
        mainGroup.getChildren().add(text2);
        mainGroup.getChildren().add(text3);
        mainGroup.getChildren().add(text4);



        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
    }
    public void showFridge(Stage stage, Scene scene, Group oldGroup){
        Group group2 = new Group();
        Text text = new Text("Fridge");
        text.setX(162);
        text.setY(75);
        text.setFont(Font.font(38));
        text.setFill(Color.web("#707070"));

        Rectangle rec = new Rectangle(430, 130);
        rec.setFill(Color.web("#BDC5CC"));
        group2.getChildren().add(rec);

        Rectangle rec2 = new Rectangle(430, 318);
        rec2.setY(318);
        rec2.setFill(Color.web("#FFFFFF"));
        group2.getChildren().add(rec2);
        rec2.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px;");


        Rectangle rec3 = new Rectangle(430, 296);
        rec3.setY(637);
        rec3.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px;");

        rec3.setFill(Color.web("#FFFFFF"));
        group2.getChildren().add(rec3);
        ImageView chart1 = new ImageView(new Image(System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\photos\\chart1.jpg"));
        chart1.setFitWidth(414);
        chart1.setFitHeight(177);
        chart1.setX(8);
        chart1.setY(393);

        group2.getChildren().add(chart1);

        ImageView chart2 = new ImageView(new Image(System.getProperty("user.dir")+"\\src\\main\\java\\com\\example\\prototype\\photos\\img.png"));
        chart2.setFitWidth(414);
        chart2.setFitHeight(177);
        chart2.setX(0);
        chart2.setY(699);

        group2.getChildren().add(chart2);
        Button ingr = new Button("Ingredients");
        ingr.setPrefSize(215, 188);
        ingr.setLayoutY(130);
        ingr.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    openFridge(stage, group2, scene);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button add = new Button("Add ingredients");
        add.setPrefSize(215, 188);
        add.setLayoutY(130);
        add.setLayoutX(215);
        add.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px; -fx-background-color: #FFFFFF");
        ingr.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px; -fx-background-color: #FFFFFF");
        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    addIngredients(stage, scene, group2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        group2.getChildren().add(ingr);
        group2.getChildren().add(add);
        group2.getChildren().add(text);

        Button back = new Button("<-");
        back.setPrefSize(66, 66);
        back.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px; -fx-background-color: #2D3028;-fx-text-fill: #FFFFFF");
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                   @Override
                                   public void handle(MouseEvent event) {
                                       scene.setRoot(oldGroup);
                                       stage.show();
                                   }
                               }
        );
        group2.getChildren().add(back);



        scene.setRoot(group2);

    }

    public void openFridge(Stage stage, Group group, Scene scene) throws IOException {
        Rectangle rec = new Rectangle(430, 130);
        rec.setFill(Color.web("#BDC5CC"));
        fridgeGroup = new Group();
        fridgeGroup.getChildren().add(rec);
        Text text = new Text("Ingredients");
        text.setX(142);
        text.setY(75);
        text.setFont(Font.font(38));
        text.setFill(Color.web("#707070"));

        ArrayList<Product> items = Profile.seeItems();
        int counter = 0;
        for (Product product : items) {
            addProduct(product, counter, scene, stage, fridgeGroup);
            counter++;
        }
        Button back = new Button("<-");
        back.setPrefSize(66, 66);
        back.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px; -fx-background-color: #2D3028;-fx-text-fill: #FFFFFF");
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                   @Override
                                   public void handle(MouseEvent event) {
                                       showFridge(stage, scene, mainGroup);
                                   }
                               }
        );
        fridgeGroup.getChildren().add(back);
        ScrollPane pane = new ScrollPane(fridgeGroup);
        fridgeGroup.getChildren().add(text);

        scene.setRoot(pane);
        stage.show();

        pane.setOnScroll((ScrollEvent event) -> {
            double deltaY = event.getDeltaY();
            double currentVvalue = pane.getVvalue();
            double newVvalue = currentVvalue - deltaY / pane.getContent().getBoundsInLocal().getHeight();

            // make sure the newVvalue is within bounds
            if (newVvalue < 0) {
                newVvalue = 0;
            } else if (newVvalue > 1) {
                newVvalue = 1;
            }

            // update the scroll pane's vertical value
            pane.setVvalue(newVvalue);
        });
    }
    private void addProduct(Product product, int counter, Scene scene, Stage stage, Group group) {
        ImageView pic;
        try {
            pic = new ImageView(new Image(System.getProperty("user.dir") + "\\src\\main\\java\\com\\example\\prototype\\photos\\" + product.name + ".png"));
        }catch (IllegalArgumentException a){
            pic = new ImageView(new Image(System.getProperty("user.dir") + "\\src\\main\\java\\com\\example\\prototype\\photos\\download.jpg"));

        }

        Button button2 = new Button("Delete");

        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Profile.deleteProduct(false, product, 100);
                    openFridge(stage,group,scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        Button button3 = new Button("Throw out");
        Button button1 = new Button(product.name +"  "+ product.quantity+"g");

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                plot(scene, product, stage);
            }
        });

        button1.setLayoutX(201);
        button1.setLayoutY(130+counter*201);
        button1.setPrefSize(229,67);

        button2.setLayoutX(201);
        button2.setLayoutY(196+counter*201);
        button2.setPrefSize(229,67);

        button3.setLayoutX(201);
        button3.setLayoutY(262+counter*201);
        button3.setPrefSize(229,67);
        group.getChildren().add(button1);
        group.getChildren().add(button2);
        group.getChildren().add(button3);

        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Profile.deleteProduct(true, product, 100);
                    openFridge(stage,group,scene);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        pic.setY(130+201*counter);
        pic.setPreserveRatio(false);
        pic.setFitHeight(201);
        pic.setFitWidth(201);
        group.getChildren().add(pic);


    }
    private static final String[] VITAMINS = {"Vitamin A", "Vitamin B1", "Vitamin B12","Vitamin B2", "Vitamin B3", "Vitamin B5",
            "Vitamin B6", "Vitamin C", "Choline", "Vitamin D", "Vitamin E",
            "Vitamin K"};

    private static final String[] MINERALS = {"Calcium","Copper","Iron","Magnesium","Manganese","Phosphorus","Potassium","Selenium","Sodium","Zinc"};
    public void plot(Scene scene, Product product, Stage stage) {
        Group group1 = new Group();
        scene.setRoot(group1);
        // set up the axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Vitamin");
        yAxis.setLabel("% of daily recommended intake in 100g");
        scene.setFill(Color.web("#FFFFFF"));

        CategoryAxis xAxis2 = new CategoryAxis();
        NumberAxis yAxis2 = new NumberAxis();
        xAxis2.setLabel("Mineral");
        yAxis2.setLabel("% of daily recommended intake in 100g");


        // create the bar chart
        BarChart<String, Number> vitamins = new BarChart<>(xAxis, yAxis);
        vitamins.setTitle("Vitamin Bar Chart");

        // create the data series and add data to it
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Data Points");
        ArrayList<Double> vitamins1 = product.vitamins;
        for (int i = 0; i < vitamins1.size(); i++) {
            series.getData().add(new XYChart.Data<>(VITAMINS[i], vitamins1.get(i)));
        }
        // add the series to the chart
        vitamins.getData().add(series);
        vitamins.setPrefSize(430, 460);
        group1.getChildren().add(vitamins);
        Button back = new Button("<-");


        BarChart<String, Number> minerals = new BarChart<>(xAxis2, yAxis2);
        vitamins.setTitle("Minerals intake bar chart");

        // create the data series and add data to it
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Data Points");
        ArrayList<Double> minerals1 = product.minerals;
        System.out.println(minerals1.size());
        for (int i = 0; i < minerals1.size(); i++) {
            series2.getData().add(new XYChart.Data<>(MINERALS[i], minerals1.get(i)));
        }
        // add the series to the chart
        minerals.getData().add(series2);
        minerals.setPrefSize(430, 460);
        minerals.setLayoutY(460);
        group1.getChildren().add(minerals);
        group1.getChildren().add(back);
        // set up the scene and show the stage

        back.setPrefSize(66, 66);
        back.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px; -fx-background-color: #2D3028;-fx-text-fill: #FFFFFF");
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                   @Override
                                   public void handle(MouseEvent event) {
                                       try {
                                           openFridge(stage, fridgeGroup, scene);
                                       } catch (IOException e) {
                                           e.printStackTrace();
                                       }
                                   }
                               }
        );
    }
    public void addIngredients(Stage stage, Scene scene, Group group) throws FileNotFoundException {

        Group group3 = new Group();
        Rectangle rec = new Rectangle(430, 130);
        rec.setFill(Color.web("#BDC5CC"));
        group3.getChildren().add(rec);
        Text text = new Text("Add ingredient");
        text.setX(117);
        text.setY(75);
        text.setFont(Font.font(38));
        text.setFill(Color.web("#707070"));

        ArrayList<Product> items = Database.seeItems();
        int counter = 0;
        for (Product product : items) {
            addProducts(product, counter, scene, stage, group3);
            counter++;
        }

        ScrollPane pane = new ScrollPane(group3);
        Button back = new Button("<-");
        back.setPrefSize(66, 66);
        back.setStyle("-fx-border-color: #2D3028; -fx-border-width: 1px; -fx-background-color: #2D3028;-fx-text-fill: #FFFFFF");
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                   @Override
                                   public void handle(MouseEvent event) {
                                       showFridge(stage, scene, mainGroup);
                                   }
                               }
        );
        group3.getChildren().add(back);
        group3.getChildren().add(text);

        scene.setRoot(pane);
        stage.show();
        pane.setOnScroll((ScrollEvent event) -> {
            double deltaY = event.getDeltaY();
            double currentVvalue = pane.getVvalue();
            double newVvalue = currentVvalue - deltaY / pane.getContent().getBoundsInLocal().getHeight();

            // make sure the newVvalue is within bounds
            if (newVvalue < 0) {
                newVvalue = 0;
            } else if (newVvalue > 1) {
                newVvalue = 1;
            }

            // update the scroll pane's vertical value
            pane.setVvalue(newVvalue);
        });
    }
    public static void main(String[] args) {
        launch();
    }
    private void addProducts(Product product, int counter, Scene scene, Stage stage, Group group) {
        ImageView pic;
        try {
            pic = new ImageView(new Image(System.getProperty("user.dir") + "\\src\\main\\java\\com\\example\\prototype\\photos\\" + product.name + ".png"));
        }catch (IllegalArgumentException a){
            pic = new ImageView(new Image(System.getProperty("user.dir") + "\\src\\main\\java\\com\\example\\prototype\\photos\\download.jpg"));

        }

        Button button2 = new Button("Add");



        TextField button3 = new TextField();
        button3.setPromptText("Input the amount");
        Button button1 = new Button(product.name);

        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Profile.addItems(product.name, Double.parseDouble(button3.getText()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                plot(scene, product, stage);
            }
        });

        button1.setLayoutX(201);
        button1.setLayoutY(130+counter*201);
        button1.setPrefSize(229,67);

        button2.setLayoutX(201);
        button2.setLayoutY(196+counter*201);
        button2.setPrefSize(229,67);

        button3.setLayoutX(201);
        button3.setLayoutY(262+counter*201);
        button3.setPrefSize(229,67);
        group.getChildren().add(button1);
        group.getChildren().add(button2);
        group.getChildren().add(button3);

        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        pic.setY(130+201*counter);
        pic.setPreserveRatio(false);
        pic.setFitHeight(201);
        pic.setFitWidth(201);
        group.getChildren().add(pic);


    }
}