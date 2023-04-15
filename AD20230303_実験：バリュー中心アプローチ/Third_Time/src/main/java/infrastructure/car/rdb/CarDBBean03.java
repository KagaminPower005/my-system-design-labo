package infrastructure.car.rdb;

import domain.car.entity.car.Id;
import domain.car.entity.car.Name;

import java.io.Serializable;
import java.util.Vector;
import java.sql.*;

public class CarDBBean03 implements Serializable
{
    private Vector<String> colname;
    private Vector<Vector> data;

    public CarDBBean03()
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
            colname = new Vector<String>(cnum);

            //列名の取得
            for(int i=1; i<=cnum; i++){
                colname.addElement(rm.getColumnName(i).toString());
            }

            //行の取得
            data = new Vector<Vector>();
            while(rs.next()){
                Vector<String> rowdata = new Vector<String>();

                rowdata.addElement(rs.getObject(Id.class.getSimpleName()).toString());
                rowdata.addElement(rs.getObject(Name.class.getSimpleName()).toString());

                data.addElement(rowdata);
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
    public Vector getData()
    {
        return data;
    }
    public Vector getColname()
    {
        return colname;
    }
}