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
        String query = "select * from marks;";

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

class Add extends conn
{
    Add() throws SQLException {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter roll number of the student");
        int Roll_Number=scan.nextInt();
        System.out.println("Enter Marks of the student");
        int Marks=scan.nextInt();

        String query = "insert into marks values (Roll_Number,Marks);";

         s.executeUpdate(query);

         String query1 = "select * from marks;";
        ResultSet r = s.executeQuery(query1);
        System.out.println("New Table");
        System.out.println("Roll_Number"+"      "+"Marks" );
        while(r.next()) {
            int roll = r.getInt("Roll_Number");
            int Mark = r.getInt("Marks");
            System.out.println(roll+"                "+Mark );
            }

        s.close();
        c.close();

    }
}

public class Main
{
    public static void main(String[] args) throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your choice");
        int n=scan.nextInt();

        switch (n){
            case 1:
                new Display();
                break;
            case 2:
                new Add();
                break;
        }


    }
}
