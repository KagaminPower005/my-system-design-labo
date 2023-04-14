package application;

import domain.car_table.car_table_row;
import infrastructure.CarDBBean;
import infrastructure.CarDBBean02;
import infrastructure.CarDBBean03;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CarBeanService {

    public void execute(){
        CarDBBean myBean = new CarDBBean();

        System.out.println(myBean.getColname());
        System.out.println(myBean.getData());

        var data01 = myBean.getData();

        System.out.println(data01.size());

        IntStream.range(0, data01.size()).forEach(i ->
                System.out.println(data01.get(i).toString())
        );

        System.out.println("------------------------------------------------------------");

        CarDBBean02 myBean02 = new CarDBBean02();

        System.out.println(myBean02.getColname());
        System.out.println(myBean02.getData());

        ArrayList<car_table_row> data02;
        data02 = myBean02.getData();

        System.out.println(data02.size());

        IntStream.range(0, data02.size()).forEach(i -> {
            System.out.print("[" + data02.get(i).id().value() + ", ");
            System.out.println(data02.get(i).name().value() + "]");
        });

        System.out.println("------------------------------------------------------------");

        CarDBBean03 myBean03 = new CarDBBean03();

        System.out.println(myBean03.getColname());
        System.out.println(myBean03.getData());

        var data03 = myBean03.getData();

        System.out.println(data03.size());

        IntStream.range(0, data03.size()).forEach(i ->
                System.out.println(data03.get(i).toString())
        );

    }
}