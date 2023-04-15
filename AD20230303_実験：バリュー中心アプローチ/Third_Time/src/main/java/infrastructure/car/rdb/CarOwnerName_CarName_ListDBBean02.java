package infrastructure.car.rdb;

import domain.car.value.car_owner_name_car_name_list.Car_name;
import domain.car.value.car_owner_name_car_name_list.Car_owner_name;
import domain.car.value.car_owner_name_car_name_list.Car_owner_name_Car_name_List_Row;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CarOwnerName_CarName_ListDBBean02 implements Serializable
{
    private Vector<String> colname;
    private ArrayList<Car_owner_name_Car_name_List_Row> data;

    public CarOwnerName_CarName_ListDBBean02()
    {
        try{
            //接続の準備
            String drv = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///carownerdb";
            String usr = "root";
            String pw = "admin";

            //データベースへの接続
            Class.forName(drv);
            Connection cn = DriverManager.getConnection(url, usr, pw);

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry = "SELECT" +
                    " c.Name As '" + Car_owner_name.class.getSimpleName() + "'" +
                    " ,a.Name As '" + Car_name.class.getSimpleName() + "'" +
                    " FROM car a " +
                    " Join car_owner_car_relation b on a.id = b.car_id" +
                    " Join car_owner c on c.id = b.car_owner_id";

            //問い合わせ
            ResultSet rs = st.executeQuery(qry);

            //列数の取得
            ResultSetMetaData rm = rs.getMetaData();
            int cnum = rm.getColumnCount();
            colname = new Vector<>(cnum);

            //列名の取得
            for(int i=1; i<=cnum; i++){
                colname.addElement(rm.getColumnName(i));
            }

            //行の取得
            data = new ArrayList<>();
            while(rs.next()){

                Car_owner_name myCar_owner_name
                        = new Car_owner_name(rs.getString(Car_owner_name.class.getSimpleName()));
                Car_name myCar_name
                        = new Car_name(rs.getString(Car_name.class.getSimpleName()));
                Car_owner_name_Car_name_List_Row myCar_owner_name_Car_name_ListRow
                        = new Car_owner_name_Car_name_List_Row(myCar_owner_name,myCar_name);

                data.add(myCar_owner_name_Car_name_ListRow);
            }

            //接続のクローズ
            rs.close();
            st.close();
            cn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Car_owner_name_Car_name_List_Row> getData()
    {
        return data;
    }
    public Vector<String> getColname()
    {
        return colname;
    }
}