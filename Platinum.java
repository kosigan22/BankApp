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
public class Platinum extends Level {
    @Override
    public void checkbalance(Customer c){
    int balance = c.balance();
    if(balance < 10000){
    c.setState(new Silver());}
    if(balance < 20000 && balance > 10000){
            c.setState(new Gold());}
     if(balance > 20000){}
    }
    
    public void fee(Customer c, int i){
    c.withdraw(i);    
    }
    
    
    
}
