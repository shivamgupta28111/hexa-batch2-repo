package com.hexaware.carsdemo.util;

import com.hexaware.carsdemo.persistence.DBConnection;

public class CliMain {
    
    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();
        dbc.getConnect();
    }
}
