package com.company;

import java.util.Scanner;
import java.sql.*;

class conn{
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3308/student","root","root");
            s =c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
class Display extends conn
{
    Display() throws SQLException {
        String query = "select * fROM marks;";

        ResultSet r = s.executeQuery(query);
        System.out.println("Roll_Number"+"      "+"Marks" );
        while(r.next()) {
            int roll = r.getInt("Roll_Number");
            int Marks = r.getInt("Marks");
            System.out.println(roll+"                "+Marks );

        }
        s.close();
        c.close();

    }
}

