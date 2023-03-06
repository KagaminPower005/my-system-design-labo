package user;

import infrastructure.CarDBBean;

public class User01 {

    public static void main(String args[]){

        CarDBBean myBean = new CarDBBean();

        System.out.println(myBean.getData());
    }

}