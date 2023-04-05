package com.main.listify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection_helper {

    public static void esegui_query(String query){
        Connection con = null;
        String username, pass, ip, port, database;

        ip="meteo.itisarezzo.cloud";
        database="va2666q7_meteo";
        username="va2666q7_1";
        pass="meteo2022";
        port="8443";

        Connection connection=null;
        String ConnectionURL=null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "databasename="+ database+";user="+username+";password="+pass+";";
            connection= DriverManager.getConnection(ConnectionURL);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next())
                //System.out.println(rs.getString(0));
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
