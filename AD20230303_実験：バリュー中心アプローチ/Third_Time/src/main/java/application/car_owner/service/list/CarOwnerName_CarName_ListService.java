package application.car_owner.service.list;

import domain.car_owner.value.car_owner_name_car_name_list.CarOwnerName_CarName_List_Record;
import infrastructure.car_owner.rdb.data.CarOwnerName_CarName_List_ColName;
import infrastructure.car_owner.rdb.data.CarOwnerName_CarName_List_RowData;

import java.util.ArrayList;

public class CarOwnerName_CarName_ListService {
    public String draw(){
        StringBuilder myList ;

        myList = new StringBuilder("------------------------------------------------------------\n");

        //列名の取得
        CarOwnerName_CarName_List_ColName
                myColName = new CarOwnerName_CarName_List_ColName();

        myList.append(myColName.get().toString())
                .append("\n");

        myList.append("------------------------------------------------------------\n");

        //行データの取得
        CarOwnerName_CarName_List_RowData
                myRowData = new CarOwnerName_CarName_List_RowData();

        ArrayList<CarOwnerName_CarName_List_Record> myListRow;
        myListRow = myRowData.get();

        for (CarOwnerName_CarName_List_Record
                carOwnerName_carName_list_rec : myListRow) {
            myList.append("[")
                    .append(carOwnerName_carName_list_rec.car_owner_name().value())
                    .append(" ,");
            myList.append(carOwnerName_carName_list_rec.car_name().value())
                    .append("]\n");
        }

        myList.append("------------------------------------------------------------\n");

        myList.append(myListRow.size())
                .append("\n");

        myList.append("------------------------------------------------------------\n");

        return myList.toString();
    }
}