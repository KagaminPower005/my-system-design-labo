package infrastructure.car_owner.rdb;

import java.util.*;
import java.io.*;
import java.sql.*;

public class CarDBBean implements Serializable
{
    private Vector<String> col_name;
    private Vector<Vector<String>> data;

    public CarDBBean()
    {
        try{
            //データベースへの接続
            Connection cn = new DBConnection().getConnection();

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry = "SELECT * FROM car";

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