package infrastructure.car_owner.rdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private Connection cn;

    DBConnection(){
        try{

            //接続の準備
            String drv = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///CarOwnerDb";
            String usr = "root";
            String pw = "admin";

            //データベースへの接続
            Class.forName(drv);
            cn = DriverManager.getConnection(url, usr, pw);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public Connection getConnection(){
        return cn;
    }
}