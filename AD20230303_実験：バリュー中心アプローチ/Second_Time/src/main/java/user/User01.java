package user;

import domain.car_table;
import infrastructure.CarDBBean;
import infrastructure.CarDBBean02;
import infrastructure.CarDBBean03;

import java.util.ArrayList;

public class User01 {

    public static void main(String args[]){

        CarDBBean myBean = new CarDBBean();

        System.out.println(myBean.getColname());
        System.out.println(myBean.getData());

        System.out.println("------------------------------------------------------------");

        CarDBBean02 myBean02 = new CarDBBean02();

        System.out.println(myBean02.getColname());
        System.out.println(myBean02.getData());

        ArrayList<car_table> data;
        data = myBean02.getData();

        System.out.println(data.size());

        System.out.println("------------------------------------------------------------");

        CarDBBean03 myBean03 = new CarDBBean03();

        System.out.println(myBean03.getColname());
        System.out.println(myBean03.getData());

    }

}