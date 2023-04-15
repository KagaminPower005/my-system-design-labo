package application.car;

import domain.car.value.car_owner_name_car_name_list.CarOwnerName_CarName_List_Row;
import infrastructure.car.rdb.CarOwnerName_CarName_List_DBBean02;

import java.util.ArrayList;


public class CarOwnerName_CarName_List_Service {
    public String execute(){
        CarOwnerName_CarName_List_DBBean02 myBean02 = new CarOwnerName_CarName_List_DBBean02();

        StringBuilder myList ;

        myList = new StringBuilder("------------------------------------------------------------\n");

        myList.append(myBean02.getCol_name().toString())
                .append("]\n");

        myList.append("------------------------------------------------------------\n");

        ArrayList<CarOwnerName_CarName_List_Row> data02;
        data02 = myBean02.getData();

        for (CarOwnerName_CarName_List_Row
                carOwnerName_carName_list_row : data02) {
            myList.append("[")
                    .append(carOwnerName_carName_list_row.car_owner_name().value())
                    .append(" ,");
            myList.append(carOwnerName_carName_list_row.car_name().value())
                    .append("]\n");
        }

        myList.append("------------------------------------------------------------\n");

        myList.append(data02.size())
                .append("\n");

        myList.append("------------------------------------------------------------\n");

        return myList.toString();
    }
}