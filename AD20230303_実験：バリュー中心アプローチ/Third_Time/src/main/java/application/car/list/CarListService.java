package application.car.list;

import domain.car.value.car.Car_Row;
import infrastructure.car.rdb.CarDBBean;
import infrastructure.car.rdb.CarDBBean02;
import infrastructure.car.rdb.CarDBBean03;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CarListService {

    public String draw(){

        StringBuilder myList ;

        CarDBBean myBean = new CarDBBean();

        myList = new StringBuilder("------------------------------------------------------------\n");

        myList.append(myBean.getCol_name()).append("\n");
        myList.append(myBean.getData()).append("\n");

        var data01 = myBean.getData();

        IntStream.range(0, data01.size()).forEach(i ->
                myList.append(data01.get(i).toString()).append("\n")
        );

        myList.append(data01.size()).append("\n");

        myList.append("------------------------------------------------------------\n");

        CarDBBean02 myBean02 = new CarDBBean02();

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

        CarDBBean03 myBean03 = new CarDBBean03();

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