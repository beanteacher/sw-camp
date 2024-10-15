package com.ohgiraffers.section03.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "swcamp";
    private static String PASSWORD = "swcamp";

    public static SqlSession getSqlSession() {

        if(sqlSessionFactory == null) {
            try {
                Environment environment = new Environment("dev", new JdbcTransactionFactory(), new PooledDataSource(DRIVER, URL, USER, PASSWORD));

                Configuration configuration = new Configuration(environment);
                configuration.addMapper(MenuMapper.class);
                configuration.setMapUnderscoreToCamelCase(true);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            } catch (Exception e ) {
                System.out.println(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }
}
