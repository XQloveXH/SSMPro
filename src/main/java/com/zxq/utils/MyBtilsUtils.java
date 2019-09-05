package com.zxq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBtilsUtils {
    private  static final SqlSessionFactory sqlSessionFactory ;
    static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("applicationContext.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

         sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

}
