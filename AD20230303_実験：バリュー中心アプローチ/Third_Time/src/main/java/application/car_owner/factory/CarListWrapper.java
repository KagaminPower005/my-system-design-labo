package application.car_owner.factory;

import domain.car_owner.value.car.Car_Row;
import infrastructure.car_owner.rdb.bean.CarList_Ver02;

import java.util.ArrayList;
import java.util.Vector;

public class CarListWrapper {

    private final CarList_Ver02 myBean02 = new CarList_Ver02();

    public ArrayList<Car_Row> getData()
    {
        return myBean02.getData();
    }
    public Vector<String> getCol_name()
    {
        return myBean02.getCol_name();
    }
}