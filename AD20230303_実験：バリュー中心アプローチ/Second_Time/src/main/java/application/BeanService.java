package application;

import domain.car_table;
import infrastructure.CarDBBean;
import infrastructure.CarDBBean02;
import infrastructure.CarDBBean03;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class BeanService {

    public void execute(){
        CarDBBean myBean = new CarDBBean();

        System.out.println(myBean.getColname());
        System.out.println(myBean.getData());

        System.out.println("------------------------------------------------------------");

        CarDBBean02 myBean02 = new CarDBBean02();

        System.out.println(myBean02.getColname());
        System.out.println(myBean02.getData());

        ArrayList<car_table> data;
        data = myBean02.getData();

        System.out.println(data.size());

        IntStream.range(0, data.size()).forEach(i -> {
            System.out.println(data.get(i).id().value());
            System.out.println(data.get(i).name().value());
        });

        System.out.println(data.get(2).id().id());
        System.out.println(data.get(2).name().value());

        System.out.println(data.get(0).id().value());
        System.out.println(data.get(0).name().value());

        System.out.println(data.get(1).id().value());
        System.out.println(data.get(1).name().value());

        System.out.println("------------------------------------------------------------");

        CarDBBean03 myBean03 = new CarDBBean03();

        System.out.println(myBean03.getColname());
        System.out.println(myBean03.getData());
    }
}