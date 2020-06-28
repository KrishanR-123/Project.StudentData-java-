package com.company;

import java.util.Arrays;
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
