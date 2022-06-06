package com.example.try11;

public class allInformation {
    private String user_name;
    private String user_id;
    private String card_id;
    //-->保存用户的用户名
    public void setName(String user_name){
        this.user_name = user_name;
    }
    public String getName(){
        return user_name;
    }
    //-->保存用户的学号
    public void setUserId(String user_id){
        this.user_id = user_id;
    }
    public String getUserId(){
        return user_id;
    }
    //-->保存用户的卡id
    public void setCardId(String card_id){
        this.card_id = card_id;
    }
    public String getCardId(){
        return card_id;
    }
}
