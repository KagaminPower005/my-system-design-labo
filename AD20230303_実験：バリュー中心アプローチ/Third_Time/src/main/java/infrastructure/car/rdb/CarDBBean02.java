package infrastructure.car.rdb;

import domain.car.entity.car.car_row;
import domain.car.entity.car.id;
import domain.car.entity.car.name;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

public class CarDBBean02 implements Serializable
{
    private Vector<String> colname;
    private ArrayList<car_row> data;

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

                id myId = new id(rs.getInt(id.class.getSimpleName()));
                name myName = new name(rs.getString(name.class.getSimpleName()));
                car_row myCar_tableRow = new car_row(myId,myName);

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
    public ArrayList<car_row> getData()
    {
        return data;
    }
    public Vector<String> getColname()
    {
        return colname;
    }
}