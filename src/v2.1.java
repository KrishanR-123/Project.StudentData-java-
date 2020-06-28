package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int n;
        System.out.println("How many student data you want to add");
        n=s.nextInt();
        int[] rollNo=new int[n];
        System.out.println("Enter Roll Number");
        for(int i=0; i<rollNo.length; i++){
            rollNo[i]= s.nextInt();
        }

        System.out.println("Enter marks respectively");
        int[] marks= new int[n];

        for(int j=0; j<marks.length; j++){
            marks[j]=s.nextInt();
          }



        System.out.println("Roll_No"+ "     " +"Marks" );

        for(int k=0;k<marks.length;k++){
            System.out.println(rollNo[k]+ "            " +marks[k]);
        }

            int r;
            System.out.println("Enter the Roll number you want to search today");
            r = s.nextInt();
        try {
            System.out.println(rollNo[Arrays.binarySearch(rollNo, r)] + "            " + marks[Arrays.binarySearch(rollNo, r)]);
        } catch (Exception e){
            System.err.println("Roll Number not found");
        }
    }
}
