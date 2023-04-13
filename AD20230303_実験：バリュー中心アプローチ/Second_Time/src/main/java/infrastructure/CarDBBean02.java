package infrastructure;

import domain.car_table.car_table_row;
import domain.car_table.id;
import domain.car_table.name;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CarDBBean02 implements Serializable
{
    private Vector<String> colname;
    private ArrayList<car_table_row> data;

    public CarDBBean02()
    {
        try{
            //接続の準備
            String drv = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///cardb";
            String usr = "root";
            String pw = "admin";

            //データベースへの接続
            Class.forName(drv);
            Connection cn = DriverManager.getConnection(url, usr, pw);

            //問い合わせの準備
            Statement st = cn.createStatement();
            String qry = "SELECT * FROM car_table";

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
                car_table_row myCar_tableRow = new car_table_row(myId,myName);

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
    public ArrayList<car_table_row> getData()
    {
        return data;
    }
    public Vector<String> getColname()
    {
        return colname;
    }
}