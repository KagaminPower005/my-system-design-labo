package user;

import application.car.CarBeanService;
import application.car.CarOwnerName_CarName_List_Service;

public class User01 {

    public static void main(String[] args){

        CarBeanService myBean = new CarBeanService();

        myBean.execute();

        System.out.println("------------------------------------------------------------");

        CarOwnerName_CarName_List_Service
                myCarOwnerName_CarName_List
                 = new CarOwnerName_CarName_List_Service();

        System.out.println(myCarOwnerName_CarName_List.execute());
    }

}