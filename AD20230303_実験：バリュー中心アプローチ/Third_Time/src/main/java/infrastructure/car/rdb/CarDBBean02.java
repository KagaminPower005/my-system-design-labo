package infrastructure.car.rdb;

import domain.car.value.car.Car_Row;
import domain.car.value.car.Id;
import domain.car.value.car.Name;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

public class CarDBBean02 implements Serializable
{
    private Vector<String> colname;
    private ArrayList<Car_Row> data;

    public CarDBBean02()
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
            String qry = "SELECT * FROM car";

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

                Id myId = new Id(rs.getInt(Id.class.getSimpleName()));
                Name myName = new Name(rs.getString(Name.class.getSimpleName()));
                Car_Row myCar_tableRow = new Car_Row(myId,myName);

                data.add(myCar_tableRow);
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
    public ArrayList<Car_Row> getData()
    {
        return data;
    }
    public Vector<String> getColname()
    {
        return colname;
    }
}