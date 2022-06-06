package com.example.try11;

public class allCardInformation {
    private String balance;
    private String net_charges;
    //-->保存余额
    public void setBalance(String balance){
        this.balance = balance;
    }
    public String getBalance(){
        return balance;
    }
    //-->保存网费
    public void setNet_charges(String net_charges){
        this.net_charges = net_charges;
    }
    public String getNet_charges(){
        return net_charges;
    }
}
