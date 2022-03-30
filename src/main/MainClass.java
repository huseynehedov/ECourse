package main;

import dao.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        try {
            Connection c = DbHelper.getConnection();

            if (c != null){
                System.out.println("Connnected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
