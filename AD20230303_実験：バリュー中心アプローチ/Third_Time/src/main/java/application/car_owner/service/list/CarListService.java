package application.car_owner.service.list;

import application.car_owner.factory.CarListFactory;
import application.car_owner.factory.CarListWrapper;
import application.car_owner.repository.CarListRepository;
import domain.car_owner.value.car.Car_Row;
import infrastructure.car_owner.rdb.bean.CarList_Ver03;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CarListService {

    public String draw(){

        StringBuilder myList ;

        CarListRepository myBean = new CarListFactory().create();

        myList = new StringBuilder("------------------------------------------------------------\n");

        myList.append(myBean.getCol_name()).append("\n");
        myList.append(myBean.getData()).append("\n");

        var data01 = myBean.getData();

        IntStream.range(0, data01.size()).forEach(i ->
                myList.append(data01.get(i).toString()).append("\n")
        );

        myList.append(data01.size()).append("\n");

        myList.append("------------------------------------------------------------\n");

        CarListWrapper myBean02 = new CarListWrapper();

        myList.append(myBean02.getCol_name()).append("\n");
        myList.append(myBean02.getData()).append("\n");

        ArrayList<Car_Row> data02;
        data02 = myBean02.getData();

        IntStream.range(0, data02.size()).forEach(i -> {
            myList.append("[").append(data02.get(i).id().value()).append(", ");
            myList.append(data02.get(i).name().value()).append("]").append("\n");
        });

        myList.append(data02.size()).append("\n");

        myList.append("------------------------------------------------------------\n");

        CarList_Ver03 myBean03 = new CarList_Ver03();

        myList.append(myBean03.getCol_name()).append("\n");
        myList.append(myBean03.getData()).append("\n");

        var data03 = myBean03.getData();

        IntStream.range(0, data03.size()).forEach(i ->
                myList.append(data03.get(i).toString()).append("\n")
        );

        myList.append(data03.size()).append("\n");

        myList.append("------------------------------------------------------------\n");

        return myList.toString();
    }
}