package user;

import application.car_owner.list.CarListService;
import application.car_owner.list.CarOwnerName_CarName_ListService;

public class User {

    public static void main(String[] args){

        CarListService myCarList = new CarListService();

        System.out.println(myCarList.getClass()
                .getSimpleName().replace("Service","."));

        System.out.print(myCarList.draw());

        System.out.println("------------------------------------------------------------");

        CarOwnerName_CarName_ListService
                myCarOwnerName_CarName_List
                 = new CarOwnerName_CarName_ListService();

        System.out.println(myCarOwnerName_CarName_List
                .getClass().getSimpleName().replace("Service","."));

        System.out.print(myCarOwnerName_CarName_List.draw());
    }

}