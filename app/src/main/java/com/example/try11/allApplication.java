package com.example.try11;

import android.app.Application;
import java.util.ArrayList;

public class allApplication extends Application {
    public static ArrayList<allInformation> mList = new ArrayList<allInformation>();
    public static ArrayList<allUserInformation> aList = new ArrayList<>();
    public static ArrayList<allCardInformation> kList = new ArrayList<>();
    //-->保存allInformation对象，用于存储用户名，学号和卡号
    public  static void addAllInformation(allInformation all) {
        mList.add(all);
    }
    //-->保存用户的信息
    public  static void addAllUserInformation(allUserInformation all) {
        aList.add(all);
    }
    //-->保存卡信息
    public  static void addAllCardInformation(allCardInformation all) {
        kList.add(all);
    }

}
