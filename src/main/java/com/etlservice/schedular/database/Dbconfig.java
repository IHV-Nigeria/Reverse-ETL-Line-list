package com.etlservice.schedular.database;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Dbconfig {

    Connection dbConn ;
    public Dbconfig(){

    }
    public  Connection getConnection() {

        try {
            // Create Properties object.
            Properties props = new Properties();

          //  String dbSettingsPropertyFile = "C:\\Users\\ihvn\\IdeaProjects\\src\\main\\resources\\application.properties";


            InputStream dbSettingsPropertyFile= Dbconfig.class.getClassLoader().getResourceAsStream("application.properties");
//
            // Properties will use a FileReader object as input.
           // FileReader fReader = new FileReader(dbSettingsPropertyFile);

            // Load jdbc related properties in above file.
            //props.load(fReader);
            props.load(dbSettingsPropertyFile);

            // Get each property value.
            String dbDriverClass = props.getProperty("spring.datasource.driver-class-name");

            String dbConnUrl = props.getProperty("spring.datasource.url");

            String dbUserName = props.getProperty("spring.datasource.username");

            String dbPassword = props.getProperty("spring.datasource.password");

            if (!"" .equals(dbDriverClass) && !"" .equals(dbConnUrl)) {
                /* Register jdbc driver class. */
                Class.forName(dbDriverClass);

                // Get database connection object.
                Connection dbConn = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

                // Get dtabase meta data.
                DatabaseMetaData dbMetaData = dbConn.getMetaData();

                // Get database name.
                String dbName = dbMetaData.getDatabaseProductName();

                // Get database version.
                String dbVersion = dbMetaData.getDatabaseProductVersion();

                System.out.println("Database Name : " + dbName);

                System.out.println("Database Version : " + dbVersion);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dbConn;
    }
}
