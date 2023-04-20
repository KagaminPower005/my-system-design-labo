package infrastructure.car_owner.rdb.data;

import infrastructure.car_owner.rdb.connection.CarOwnerDbConnection;
import infrastructure.car_owner.rdb.sql.CarOwnerName_CarName_List_Query;
import infrastructure.support.rdb.DBClose;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class CarOwnerName_CarName_List_ColName implements Serializable
{
    private Vector<String> colName;

    public CarOwnerName_CarName_List_ColName()
    {
        try{
            //データベースへの接続
            Connection cn = new CarOwnerDbConnection().get();

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry = CarOwnerName_CarName_List_Query.get();

            //問い合わせ
            ResultSet rs = st.executeQuery(qry);

            //列数の取得
            ResultSetMetaData rm = rs.getMetaData();
            int col_num = rm.getColumnCount();

            //列名の取得
            colName = new Vector<>(col_num);
            for(int i=1; i<=col_num; i++){
                colName.addElement(rm.getColumnName(i));
            }

            //接続のクローズ
            new DBClose(rs,st,cn);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Vector<String> get()
    {
        return colName;
    }
}