package application.car_owner.factory;

import application.car_owner.repository.CarListRepository;
import infrastructure.car_owner.rdb.bean.CarList_Ver01;

public class CarListFactory {

    public CarListRepository create(){
        return new CarList_Ver01();
    }
}