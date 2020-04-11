/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author kosig
 */
import java.io.*;
public class Customer implements User{
    
    private Level mystate;
    private String username;
    private String password;
    private int balance = 0;
    public Customer(String x,String y,Level l,int z){
        mystate = l;
        username =x;
        password =y;
        balance = z;
    }
    
    public void setState(Level l){
        mystate=l;
    }
    
    public Level getState(){
        return mystate;
    }
    
     public boolean Username(String i){
        return(i.equals(username));
    }
    
    
    public boolean Password(String i){
        return(i.equals(password));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void deposit(int x){
        balance = balance + x;
        mystate.checkbalance(this);
        
        writefile(username,password, balance);

    }
        
    public void withdraw(int x){
        balance = balance - x; 
        mystate.checkbalance(this);
        writefile(username,password, balance);
    }
    
    public int balance(){
        return (balance);   
    }
    
    public void setbalance(int x){
        balance = x;   
    }
    
    public void onlinepurchase(int i){
     mystate.fee(this,i);
   
        
    }
    public void writefile(String i, String r, int x){
          try{
          File outfile = new File(new File(".").getAbsolutePath()+"//Customers//"+ i + ".txt");
           PrintWriter out = new PrintWriter(outfile);
           out.print("");
           out.print((i + "\t" + r + "\t" + x +"\t"));
           
           out.close();

       }catch(Exception e){
           System.out.println("Invalid username");
       }    
    }
}
