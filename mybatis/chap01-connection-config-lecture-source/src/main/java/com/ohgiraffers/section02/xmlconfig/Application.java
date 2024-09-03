package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        /* selectOne : 조회 결과가 1행인 경우 사용하는 메소드
        * mapper.xml 파일의 namespace가 select 태그의 id를 통해 수행 구문을 찾아온다. (namespace.id) */
        Date date = sqlSession.selectOne("mapper.selectDate");
        System.out.println("date : " + date);

        sqlSession.close();
    }
}
