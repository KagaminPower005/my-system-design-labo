package infrastructure.car_owner.rdb.data;

import application.car_owner.repository.CarListRepository;
import infrastructure.car_owner.rdb.connection.CarOwnerDbConnection;
import infrastructure.car_owner.rdb.sql.CarList_Query;
import infrastructure.support.rdb.DBClose;

import java.util.*;
import java.io.*;
import java.sql.*;

public class CarList_Ver01 implements Serializable, CarListRepository
{
    private Vector<String> col_name;
    private Vector<Vector<String>> data;

    public CarList_Ver01()
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

            //列名の取得
            col_name = new Vector<>(col_num);
            for(int i=1; i<=col_num; i++){
                col_name.addElement(rm.getColumnName(i));
            }

            //行の取得
            data = new Vector<>();
            while(rs.next()){
                Vector<String> row_data = new Vector<>();
                for(int i=1; i<=col_num; i++){
                    row_data.addElement(rs.getObject(i).toString());
                }
                data.addElement(row_data);
            }

            //接続のクローズ
            new DBClose(rs,st,cn);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Vector<Vector<String>> getData()
    {
        return data;
    }
    public Vector<String> getCol_name()
    {
        return col_name;
    }
}