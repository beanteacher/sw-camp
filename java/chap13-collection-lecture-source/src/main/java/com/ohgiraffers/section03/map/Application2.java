package com.ohgiraffers.section03.map;

import java.io.*;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {
        /* Properties 에 대해 이해하고 사용할 수 있다. */
        Properties props = new Properties();

        /* DB 설정 정보를 Properties 객체에 저장한다. */
        props.setProperty("driver", "org.mariadb.jdbc.Driver");
        props.setProperty("url", "jdbc:mariadb://localhost:3306/test");
        props.setProperty("user", "root");
        props.setProperty("password", "root");

        System.out.println("properties: " + props);

        /* Properties 객체 값을 파일로 출력 */
        try {
            props.store(new FileOutputStream("driver.properties"), "My Properties File");
            props.store(new FileWriter("driver.txt"), "My Properties File");
            props.storeToXML(new FileOutputStream("driver.xml"), "My Properties File");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /* 파일의 내용을 Properties 객체에 읽어온다. */
        Properties props2 = new Properties();
        try {
//            props2.load(new FileInputStream("driver.properties"));
//            props2.load(new FileReader("driver.txt"));
            props2.loadFromXML(new FileInputStream("driver.xml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(props2.getProperty("driver"));
        System.out.println(props2.getProperty("url"));
        System.out.println(props2.getProperty("user"));
        System.out.println(props2.getProperty("password"));

    }
}
