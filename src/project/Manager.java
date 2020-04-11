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

public class Manager implements User {
    
    
    
    private int money=100;
    
    @Override
    public boolean Username(String i){
        return(i.equals("admin"));
    }
    
    @Override
    public boolean Password(String i){
        return(i.equals("admin"));
    }
    
    public void addCustomer(String i, String r){
       createfile(i,r,100); 
        
               
       
    }
    
    public Customer createCustomer(String i, String r){
        
        Customer c = new Customer(i,r,new Silver(),money);
        (c.getState()).checkbalance(c);
        return c;
    }
    
    
    public void deleteCustomer(String i, String r){
         File outfile = new File(new File(".").getAbsolutePath()+"//Customers//"+ i + ".txt");
         outfile.delete();
        
        
        
       
    }
    
    
    
   
    
    public void createfile(String i, String r, int x){
          try{
            FileWriter outfile = new FileWriter(new File(".").getAbsolutePath()+"//Customers//"+ i + ".txt",true);
           BufferedWriter out = new BufferedWriter(outfile);
         
           
           out.write((i + "\t" + r + "\t" + x +"\t" ));
           out.close();
                   

       
       }catch(Exception e){
           System.out.println("Invalid username");
       }    
    }    
    public boolean readfile(String i, String r){
            try{
                BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"//Customers//"+ i + ".txt"));
                String line = null;
                
                if((line = br.readLine()) != null){
                    String tmp[] = line.split("\t");
                 if(tmp[0].equals(i)==true && tmp[1].equals(r)==true){
                    Customer k = createCustomer(i,r);
                    money=Integer.parseInt(tmp[2]);
                    k.setbalance(Integer.parseInt(tmp[2]));
                    return true;          }  
                }
                    
            }catch(Exception e){
               System.out.println("Invalid username");
               return false;
            } 
                return false; 
                
                       
            
            
    }
   
}
    
    
    
    
    
    
    
    

