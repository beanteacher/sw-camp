package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";

        if(sqlSessionFactory == null) {
            try {
                InputStream is = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            } catch (Exception e ) {
                System.out.println(e);
            }
        }

        return sqlSessionFactory.openSession(false);
    }
}
