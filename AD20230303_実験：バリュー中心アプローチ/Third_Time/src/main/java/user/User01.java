package user;

import application.car.CarListService;
import application.car.CarOwnerName_CarName_List_Service;

public class User01 {

    public static void main(String[] args){

        CarListService myCarList = new CarListService();

        System.out.print(myCarList.draw());

        System.out.println("------------------------------------------------------------");

        CarOwnerName_CarName_List_Service
                myCarOwnerName_CarName_List
                 = new CarOwnerName_CarName_List_Service();

        System.out.print(myCarOwnerName_CarName_List.draw());
    }

}