package application.car;

import domain.car.value.car_owner_name_car_name_list.Car_owner_name_Car_name_List_Row;
import infrastructure.car.rdb.CarOwnerName_CarName_ListDBBean02;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CarOwnerName_CarName_List_Service {
    public void execute(){
        CarOwnerName_CarName_ListDBBean02 myBean02 = new CarOwnerName_CarName_ListDBBean02();

//        System.out.println(myBean02.getColname());
//        System.out.println(myBean02.getData());

        ArrayList<Car_owner_name_Car_name_List_Row> data02;
        data02 = myBean02.getData();

        System.out.println(data02.size());

        IntStream.range(0, data02.size()).forEach(i -> {
            System.out.print("[" + data02.get(i).car_owner_name().value() + ", ");
            System.out.println(data02.get(i).car_name().value() + "]");
        });
    }
}