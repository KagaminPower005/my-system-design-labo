package infrastructure.car_owner.rdb.sql;

import domain.car_owner.value.car_owner_name_car_name_list.CarName;
import domain.car_owner.value.car_owner_name_car_name_list.CarOwnerName;

public class CarOwnerName_CarName_List_Query {
    public static String get(){

        return "SELECT" +
                " c.Name As '" + CarOwnerName.class.getSimpleName() + "'" +
                " ,a.Name As '" + CarName.class.getSimpleName() + "'" +
                " FROM Car a " +
                " Join CarOwner_Car_Relation b on a.Id = b.CarId" +
                " Join CarOwner c on c.Id = b.CarOwnerId";
    }
}