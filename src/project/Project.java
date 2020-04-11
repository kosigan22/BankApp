/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.*;
//import java.io.*;

/**
 *
 * @author kosig
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Project extends Application{
    
    Stage app;
    Scene clogin,mlogin,scene3,scene4;    
    int current=0,num=0;
    
    @Override
    public void start(Stage primaryStage) {
        app = primaryStage;
        Manager x = new Manager ();
        
        
        
        BorderPane window = new BorderPane();

        Button manager = new Button();
        Button customer = new Button();
        
        //Manager Button
        manager.setText("Manager");
        manager.setOnAction(e -> app.setScene(mlogin));
        //Customer Button
        customer.setText("Customer");
        customer.setOnAction(e ->{
                num++;
                
                 app.setScene(clogin);
                
                });
            
        HBox root = new HBox();
        root.getChildren().addAll(customer,manager);
        
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        
        
        
        Scene scene = new Scene(root, 300, 250);
        //Scene 2 login
        VBox window1 = new VBox(10);
        VBox window2 = new VBox(10);
        
  
       //Manager
        
        TextField username = new TextField();
        Label username1 = new Label("Username");
        
        TextField password = new TextField();
        Label password1 = new Label("Password");
        
       Button login = new Button();
       login.setText("Login");
        
        
        
        window1.setPadding(new Insets(20,20,20,20));    
        window1.getChildren().addAll(username1,username,password1,password,login);
        
          HBox window3 = new HBox(10);
           
           scene3 = new Scene(window3, 300, 250);
           Stage app1 = primaryStage; 
           
        
       login.setOnAction(e -> {
       if ((x.Username(username.getText()) == true) && (x.Password(password.getText()) == true)){
      
           app1.setScene(scene3);
       }
       });
       //Manager has login with username: admin and password admin 
       Button add = new Button();
       add.setText("Add Customer");

       Button delete = new Button();
       delete.setText("Delete Customer");
       
       window3.getChildren().addAll(add,delete);
       window3.setAlignment(Pos.CENTER);
       
       Button back2 = new Button();
       back2.setText("Back");
       back2.setOnAction(e -> app.setScene(scene));
       window3.getChildren().add(back2);
 
       //add
       VBox addc = new VBox(10);
       Scene addCustomer = new Scene(addc,300,250);
       add.setOnAction(e -> app.setScene(addCustomer));
       
        TextField addusername = new TextField();
        Label addusername1 = new Label("Username");
        
        TextField addpassword = new TextField();
        Label addpassword1 = new Label("Password");
        
       Button add1 = new Button();
       add1.setText("Add");
       
       addc.setPadding(new Insets(20,20,20,20));    
       addc.getChildren().addAll(addusername1,addusername,addpassword1,addpassword,add1);
       
       Button back = new Button();
       back.setText("Back");
       back.setOnAction(e -> app.setScene(scene3));
      
       addc.getChildren().add(back);
       
       add1.setOnAction(e -> {
       
       x.addCustomer(addusername.getText(),addpassword.getText());
     
       //add window to confirm customer has been added     
       });

       //delete
       
       VBox deletec = new VBox(10);
       Scene deleteCustomer = new Scene(deletec,300,250);
       delete.setOnAction(e -> app.setScene(deleteCustomer));
       
       TextField deleteusername = new TextField();
       Label deleteusername1 = new Label("Username");
        
        TextField deletepassword = new TextField();
        Label deletepassword1 = new Label("Password");
        
       Button delete1 = new Button();
       delete1.setText("Delete");
       
       deletec.setPadding(new Insets(20,20,20,20));    
       deletec.getChildren().addAll(deleteusername1,deleteusername,deletepassword1,deletepassword,delete1);
       
       Button back1 = new Button();
       back1.setText("Back");
       back1.setOnAction(e -> app.setScene(scene3));
       deletec.getChildren().add(back1);
       
       delete1.setOnAction(e -> {
       
       x.deleteCustomer(deleteusername.getText(),deletepassword.getText());
       //add window to confirm customer has been deleted 
       });    

       //Customer
       
       Button login1 = new Button();
       login1.setText("Login");
       
       
        
        TextField Cusername = new TextField();
        Label username2 = new Label("Username");
        
        TextField Cpassword = new TextField();
        Label password2 = new Label("Password");
        
        window2.setPadding(new Insets(20,20,20,20));
        window2.getChildren().addAll(username2,Cusername,password2,Cpassword,login1);
        
          HBox window4 = new HBox(10);
           
           scene4 = new Scene(window4, 400, 250);
           Stage app2 = primaryStage; 
        
       login1.setOnAction(e -> {
           Customer current1;
        
           
       if ((x.readfile(Cusername.getText(), Cpassword.getText())) == true) {
          // current = x.findCustomer1(Cusername.getText(), Cpassword.getText());
           //Customer c = new Customer(Cusername.getText(), Cpassword.getText(),new Silver());
           current1= x.createCustomer(Cusername.getText(), Cpassword.getText());
           app2.setScene(scene4);
           }
       }
       );
       
       Button deposit = new Button();
       deposit.setText("Deposit");
       
       Button withdraw = new Button();
       withdraw.setText("Withdraw");
       
       Button balance = new Button();
       balance.setText("Get Balance");
       
       Button online = new Button();
       online.setText("Online Purchase");
       
       Button back8 = new Button();
       back8.setText("Back");
       back8.setOnAction(e -> app.setScene(scene));
      
       
       window4.getChildren().addAll(deposit,withdraw,balance,online);
       window4.setAlignment(Pos.CENTER);
       
       window4.getChildren().add(back8);
       
       //deposit
       
       VBox deposit1 = new VBox(10);
       Scene deposit2 = new Scene(deposit1,300,250);
       deposit.setOnAction(e -> app.setScene(deposit2));
       
       TextField deposit3 = new TextField();
       Label deposit4 = new Label("How much would you like to deposit:");
       
       Button submit = new Button();
       submit.setText("Deposit");
       
        deposit1.setPadding(new Insets(20,20,20,20));
        deposit1.getChildren().addAll(deposit4,deposit3,submit);
       
       submit.setOnAction(e ->{
           Customer current1;
          //  Customer[] c3 = x.findCustomer();
          current1=x.createCustomer(Cusername.getText(), Cpassword.getText());
           current1.deposit(Integer.parseInt(deposit3.getText()));
            
            deposit3.clear();
    });
       deposit3.clear();
       Button back3 = new Button();
       back3.setText("Back");
       back3.setOnAction(e -> app.setScene(scene4));
       deposit1.getChildren().add(back3);
       
       //withdraw
       
       VBox withdraw1 = new VBox(10);
       Scene withdraw2 = new Scene(withdraw1,300,250);
       withdraw.setOnAction(e -> app.setScene(withdraw2));
       
       TextField withdraw3 = new TextField();
       Label withdraw4 = new Label("How much would you like to withdraw:");
       
       Button submit1 = new Button();
       submit1.setText("Withdraw");
       
        withdraw1.setPadding(new Insets(20,20,20,20));
        withdraw1.getChildren().addAll(withdraw4,withdraw3,submit1);
       
       submit1.setOnAction(e ->{
          Customer current1;
          //  Customer[] c3 = x.findCustomer();
          current1=x.createCustomer(Cusername.getText(), Cpassword.getText());
           current1.withdraw(Integer.parseInt(withdraw3.getText()));
            withdraw3.clear();
    });
       
       Button back4 = new Button();
       back4.setText("Back");
       back4.setOnAction(e -> app.setScene(scene4));
       withdraw1.getChildren().add(back4);
       
       
       
      //balance
       
       VBox balance1 = new VBox(10);
       Scene balance2 = new Scene(balance1,300,250);
       
       
       Button back5 = new Button();
       back5.setText("Back");
       back5.setOnAction(e -> app.setScene(scene4));
       
       Label balance3 = new Label();
       
       balance.setOnAction(e -> {
            app.setScene(balance2);
            Customer current1;
            x.readfile(Cusername.getText(), Cpassword.getText());
            current1=x.createCustomer(Cusername.getText(), Cpassword.getText());
            int y = current1.balance();
            System.out.println(y);
            balance3.setText("Total Balance: $" + Integer.toString(current1.balance())); 
             
               });
       
       balance1.getChildren().addAll(balance3,back5);
       
       balance1.setAlignment(Pos.CENTER);

       
       //Online purchases
       VBox online1 = new VBox(10);
       Scene online2 = new Scene(online1,300,250);
       online.setOnAction(e -> app.setScene(online2));
       
       TextField online3 = new TextField();
       Label online4 = new Label("How much would you like to spend on your online purchase:");
       
       Button submit2 = new Button();
       submit2.setText("Confirm");
       
        online1.setPadding(new Insets(20,20,20,20));
        online1.getChildren().addAll(online4,online3,submit2);
       
       submit2.setOnAction(e ->{
            
            if(Integer.parseInt(online3.getText()) > 50){
                
                Customer current1;
          
          current1=x.createCustomer(Cusername.getText(), Cpassword.getText());
                
                
            current1.onlinepurchase(Integer.parseInt(online3.getText()));
            online3.clear();}else{
                
                VBox checkscene = new VBox(10);
                Scene checkscene1 = new Scene(checkscene,300,250);
                Label checkscene2 = new Label("Online purchase must be at least $50, Please try again");
                checkscene.getChildren().addAll(checkscene2);
                app.setScene(checkscene1);
                
                  Button back6 = new Button();
                  back6.setText("Back");  
                  checkscene.getChildren().add(back6);
                  app.setScene(online2);
       
                
            }
    });
       
       Button back7 = new Button();
       back7.setText("Back");
       back7.setOnAction(e -> app.setScene(scene4));
       online1.getChildren().add(back7);
       
   
       
        mlogin = new Scene(window1, 300, 250);
        clogin = new Scene(window2, 300, 250);
        

        //Set the beginning scene
        app.setTitle("Simple Bank Account Application");
        app.setScene(scene);
        app.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
