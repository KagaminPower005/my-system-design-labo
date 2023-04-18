package infrastructure.car_owner.rdb.bean;

import domain.car_owner.value.car.Car_Row;
import domain.car_owner.value.car.Id;
import domain.car_owner.value.car.Name;
import infrastructure.car_owner.rdb.sql.CarList_Query;
import infrastructure.support.rdb.DBClose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

public class CarList_Ver02 implements Serializable
{
    private Vector<String> col_name;
    private ArrayList<Car_Row> data;

    public CarList_Ver02()
    {
        try{
            //データベースへの接続
            Connection cn = new CarOwnerDbConnection().get();

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry = CarList_Query.get();

            //問い合わせ
            ResultSet rs = st.executeQuery(qry);

            //列数の取得
            ResultSetMetaData rm = rs.getMetaData();
            int col_num = rm.getColumnCount();
            col_name = new Vector<>(col_num);

            //列名の取得
            for(int i=1; i<=col_num; i++){
                col_name.addElement(rm.getColumnName(i));
            }

            //行の取得
            data = new ArrayList<>();
            while(rs.next()){

                Id myId = new Id(rs.getInt(Id.class.getSimpleName()));
                Name myName = new Name(rs.getString(Name.class.getSimpleName()));
                Car_Row myCar_tableRow = new Car_Row(myId,myName);

                data.add(myCar_tableRow);
            }

            //接続のクローズ
            new DBClose(rs,st,cn);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Car_Row> getData()
    {
        return data;
    }
    public Vector<String> getCol_name()
    {
        return col_name;
    }
}