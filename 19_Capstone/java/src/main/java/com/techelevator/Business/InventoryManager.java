package com.techelevator.Business;

import com.techelevator.food.Item;

import java.math.BigDecimal;
import java.util.Map;

public class InventoryManager {
    //keep track of the quantity of each item
    //if something is sold out - indicate that it is SOLD OUT
    private Map<String, Item> itemMap;
    public BigDecimal balance = new BigDecimal(0.00).setScale(2);

    public InventoryManager(Map<String, Item> itemMap) {
        this.itemMap = itemMap;

    }
    public String feedMoney(BigDecimal moneyInserted){
        balance= balance.add(moneyInserted);
        return "The balance is " + balance;
    }

    public String getBalance(){

        return "Your balance is " +balance;
    }

    public String purchaseItem(String code){
        boolean hasKey = itemMap.containsKey(code);
        if(hasKey){
            Item item = itemMap.get(code);
            if(BigDecimal.valueOf(item.getPrice())<= balance){

            }
            return item.getName() +" $"+ item.getPrice() + ". "+ getBalance() + " "+ item.displayVendingSlogan();

        }else {
            return "Please enter the correct code";
        }

    }

    public BigDecimal convertBalance(int currentBalance){
        BigDecimal balanceInDollars;
        balanceInDollars= BigDecimal.valueOf(currentBalance/100);
        return balanceInDollars;
    }

    public String finishedTransaction(int balance){
        int quarter = 0;
        int dime= 0;
        int nickel = 0;
        //balance = 0;

        int quarterValue = 25;
        int dimeValue = 10;
        int nickelValue =5;

        while(balance>0){
            if(balance>=quarterValue){
                quarter++;
                balance-=quarter;
            } else if(balance>=dimeValue){
                dime++;
                balance-=dime;
            }else if(balance>=nickelValue){
                nickel++;
                balance-=nickel;
            }
        }
        String returnChange = "Thank you. Your change is " + quarter + " quarters, " + dime + " dimes, " + nickel +" nickels.";
        return returnChange;

    }


}
