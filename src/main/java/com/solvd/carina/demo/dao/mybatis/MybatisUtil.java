package com.solvd.carina.demo.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {

    private static final Logger LOGGER = LogManager.getLogger(MybatisUtil.class);

    private static final SqlSessionFactory factory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        } catch (IOException e) {
            LOGGER.error(e);
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    private MybatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}
