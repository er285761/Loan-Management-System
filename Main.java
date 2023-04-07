package uranus;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
    function fn=new function();
    Scene scene,scene1;
    Label res, fill,name,Pass;
    Button log;
    TextField uname;
    PasswordField pd;
    Color color;
    String resp=null;
    public static void main (String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception{
       Pane pane=new Pane();
       pane.setPrefWidth(459);
       pane.setPrefHeight(400);
       pane.setMaxWidth(4559);


        fill=new Label("Fill in your login details: ");
        fill.setLayoutY(66); fill.setLayoutX(114);

      name=new Label("Username: ");
       name.setLayoutY(149); name.setLayoutX(37);

       Pass=new Label("Password: ");
        Pass.setLayoutY(211); Pass.setLayoutX(38);

        log=new Button("Login");
        log.setLayoutY(293); log.setLayoutX(123);

        PasswordField pd=new PasswordField();
        pd.setLayoutY(207); pd.setLayoutX(114); pd.setPrefWidth(267);

        TextField uname=new TextField();
        uname.setLayoutY(145); uname.setLayoutX(114); uname.setPrefWidth(267);

        Label res=new Label();
        res.setLayoutY(347); res.setLayoutX(123);

        pane.getChildren().addAll(fill,name,Pass,log,pd,uname,res);
        scene=new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Loan Management System");
        stage.show();



        log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nm,pdo;
                nm=uname.getText();
                pdo=pd.getText();

                if(nm.isEmpty()) resp="the field Username is empty..\n\n";
                if(pdo.isEmpty()) resp="field password is empty";

                if(nm.equals("admin") && pdo.equals("admin")) {
                    scene1=new Scene(fn._tab());
                    stage.setScene(scene1);
                    stage.setTitle("Welcome Admin - Loan management system");

                } else{
                    resp="Password or username dont match" +nm +" "+ pdo;
                    res.setTextFill(color.web("#de0017"));
                }

                res.setText(resp);


            }
        });





    }
}