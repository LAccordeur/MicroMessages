package com.guoyang.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by L'Accordeur on 2016/10/14.
 */
public class DBUtil {

    public SqlSession getSqlSesion() throws IOException{
        //读取配置文件信息获得数据库连接信息
        Reader reader = Resources.getResourceAsReader("com/guoyang/config/Configuration.xml");
        //创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //获得SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
