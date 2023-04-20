package infrastructure.car_owner.rdb.data;

import domain.car_owner.value.car_owner_name_car_name_list.CarName;
import domain.car_owner.value.car_owner_name_car_name_list.CarOwnerName;
import domain.car_owner.value.car_owner_name_car_name_list.CarOwnerName_CarName_List_Record;
import infrastructure.car_owner.rdb.connection.CarOwnerDbConnection;
import infrastructure.car_owner.rdb.sql.CarOwnerName_CarName_List_Query;
import infrastructure.support.rdb.DBClose;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CarOwnerName_CarName_List_RowData implements Serializable
{
    private ArrayList<CarOwnerName_CarName_List_Record> RowData;

    public CarOwnerName_CarName_List_RowData() {
        try {
            //データベースへの接続
            Connection cn = new CarOwnerDbConnection().get();

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry = CarOwnerName_CarName_List_Query.get();

            //問い合わせ
            ResultSet rs = st.executeQuery(qry);

            //行の取得
            RowData = new ArrayList<>();
            while (rs.next()) {

                CarOwnerName myCar_ownerName
                        = new CarOwnerName(rs.getString(CarOwnerName.class.getSimpleName()));
                CarName myCar_name
                        = new CarName(rs.getString(CarName.class.getSimpleName()));

                CarOwnerName_CarName_List_Record
                        myCar_owner_name_Car_name_ListRow
                        = new CarOwnerName_CarName_List_Record(myCar_ownerName, myCar_name);

                RowData.add(myCar_owner_name_Car_name_ListRow);
            }

                //接続のクローズ
                new DBClose(rs, st, cn);
            }
                    catch(Exception e){
                e.printStackTrace();
            }
        }

    public ArrayList<CarOwnerName_CarName_List_Record> get()
    {
        return RowData;
    }
}