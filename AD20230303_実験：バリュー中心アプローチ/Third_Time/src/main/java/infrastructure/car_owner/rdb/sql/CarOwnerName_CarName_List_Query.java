package infrastructure.car_owner.rdb.sql;

import domain.car_owner.value.car_owner_name_car_name_list.CarName;
import domain.car_owner.value.car_owner_name_car_name_list.CarOwnerName;

public class CarOwnerName_CarName_List_Query {
    public static String get(){

        return """
                Select
                    c.Name As '@1'
                    ,a.Name As '@2'
                From Car a
                 Join CarOwner_Car_Relation b on a.Id = b.CarId
                 Join CarOwner c on c.Id = b.CarOwnerId
                """.replace("@1",CarOwnerName.class.getSimpleName())
                .replace("@2",CarName.class.getSimpleName())
                ;
    }
}