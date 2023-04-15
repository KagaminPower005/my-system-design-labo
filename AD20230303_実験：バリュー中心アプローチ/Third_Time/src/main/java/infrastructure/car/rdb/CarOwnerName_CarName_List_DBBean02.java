package infrastructure.car.rdb;

import domain.car.value.car_owner_name_car_name_list.CarName;
import domain.car.value.car_owner_name_car_name_list.CarOwnerName;
import domain.car.value.car_owner_name_car_name_list.CarOwnerName_CarName_List_Row;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CarOwnerName_CarName_List_DBBean02 implements Serializable
{
    private Vector<String> col_name;
    private ArrayList<CarOwnerName_CarName_List_Row> data;

    public CarOwnerName_CarName_List_DBBean02()
    {
        try{
            //接続の準備
            String drv = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///CarOwnerDb";
            String usr = "root";
            String pw = "admin";

            //データベースへの接続
            Class.forName(drv);
            Connection cn = DriverManager.getConnection(url, usr, pw);

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry
                    = "SELECT" +
                    " c.Name As '" + CarOwnerName.class.getSimpleName() + "'" +
                    " ,a.Name As '" + CarName.class.getSimpleName() + "'" +
                    " FROM Car a " +
                    " Join CarOwner_Car_Relation b on a.Id = b.CarId" +
                    " Join CarOwner c on c.Id = b.CarOwnerId";

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

                CarOwnerName myCar_ownerName
                        = new CarOwnerName(rs.getString(CarOwnerName.class.getSimpleName()));
                CarName myCar_name
                        = new CarName(rs.getString(CarName.class.getSimpleName()));

                CarOwnerName_CarName_List_Row
                        myCar_owner_name_Car_name_ListRow
                         = new CarOwnerName_CarName_List_Row(myCar_ownerName,myCar_name);

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
    public ArrayList<CarOwnerName_CarName_List_Row> getData()
    {
        return data;
    }
    public Vector<String> getCol_name()
    {
        return col_name;
    }
}