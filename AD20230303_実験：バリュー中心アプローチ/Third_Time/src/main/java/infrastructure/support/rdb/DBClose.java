package infrastructure.support.rdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBClose {
    public DBClose(ResultSet rs, Statement st, Connection cn){
        try{
            rs.close();
            st.close();
            cn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}