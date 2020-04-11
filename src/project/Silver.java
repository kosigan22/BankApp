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
public class Silver extends Level{
   
/*
Abstraction Function:
AF(r) = customer balance, such that
c.balance = predefined balance 

Rep Invariant:
(10000 < c.balance < 20000) = c.setState(new Platinum());
(c.balance > 20000) = c.setState(new Platinum());
*/
    
/*
    Requires: balance != null && balance = c.balance
    Modifies: The state of c,c.setState()
    Effects:  Changes the state of c
*/
    @Override
    public void checkbalance(Customer c){
    int balance = c.balance();
    if(balance < 10000){}
    if(balance < 20000 && balance > 10000){
        c.setState(new Gold());
    }
     if(balance > 20000){
        c.setState(new Platinum());
    }
    }
    
    
/*  Requires: c.balance != null
    Modifies: The value of c.balance
    Effects:  Changes the value of balance
*/
    @Override
    public void fee(Customer c, int i){
    c.withdraw(i+20);    
    }
    
    
    
    
}
