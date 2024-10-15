package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;


public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "swcamp";
    private static String PASSWORD = "swcamp";

    public static void main(String[] args) {
        /* DB 접속에 관한 설정
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 자동 커밋 */
        Environment env = new Environment("dev", // 환경 정보 이름
                new JdbcTransactionFactory(), // 트랜잭션 매니저 종류 (Jdbc or managed)
                new PooledDataSource(DRIVER, URL, USER, PASSWORD)); // Connection Pool 사용 유무 (Pooled or unPooled) -> unPooled 요청이 발생할 때마다 커넥션을 생성

        /* 생성한 환경 설정 정보로 MyBatis 설정 객체 생성 */
        Configuration configuration = new Configuration(env);
        /* 설정 객체에 Mapper 등록 */
        configuration.addMapper(Mapper.class);
        /* SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현체를 생성하기 위한 빌드 역할
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /* openSession() : sqlSession 타입의 인터페이스를 반환하는 메소드로 boolean 타입으로 인자 전달
        * - false : DML 수행 후 auto commit 옵션을 false로 지정 */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        /* getMapper() : Configuration에 등록된 매퍼를 동일 타입에 대해 반환 */
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        Date date = mapper.selectDate();
        System.out.println("date = " + date);

        sqlSession.close();
    }
}
