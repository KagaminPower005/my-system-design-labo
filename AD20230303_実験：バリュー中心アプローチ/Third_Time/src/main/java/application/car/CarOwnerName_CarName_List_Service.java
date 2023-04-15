package application.car;

import domain.car.value.car_owner_name_car_name_list.CarOwnerName_CarName_List_Row;
import infrastructure.car.rdb.CarOwnerName_CarName_List_DBBean02;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CarOwnerName_CarName_List_Service {
    public void execute(){
        CarOwnerName_CarName_List_DBBean02 myBean02 = new CarOwnerName_CarName_List_DBBean02();

        System.out.println("------------------------------------------------------------");
        System.out.println(myBean02.getColname());

        System.out.println("------------------------------------------------------------");

        ArrayList<CarOwnerName_CarName_List_Row> data02;
        data02 = myBean02.getData();

        IntStream.range(0, data02.size()).forEach(i -> {
            System.out.print("[" + data02.get(i).car_owner_name().value() + ", ");
            System.out.println(data02.get(i).car_name().value() + "]");
        });

        System.out.println("------------------------------------------------------------");
        System.out.println(data02.size());

        System.out.println("------------------------------------------------------------");
    }
}