package com.ohgiraffers.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Template {
    /* SqlSessionFactory : 애플리케이션 실행하는 동안 존재해야하며 여러 차례 다시 빌드하지 않는 것이 좋은 형태이다.
    * => singleton (오로지 1개의 객체만 생성) 하는 패턴을 이용하는 것이 가장 좋다. */
    private static SqlSessionFactory sqlSessionFactory;
    /* 한번의 요청 당 1개의 SqlSession 객체가 필요하므로 필요 시 호출할 메소드 */
    public static SqlSession getSqlSession() {
        String resource = "mybatis-config.xml";

        if(sqlSessionFactory == null) {
            try {
                InputStream is = Resources.getResourceAsStream(resource);

                /* SqlSessionFactoryBuilder : SqlSessionFactory를 생성한 뒤 유지할 필요가 없으므로
                * 메소드 스코프로 만들면 된다. */
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            } catch (Exception e ) {
                System.out.println(e);
            }
        }

        /* SqlSession : Thread에 안전하지 않고 공유되지 않아야 하므로 요청 시 마다 생성한다. */
        return sqlSessionFactory.openSession(false);
    }
}
