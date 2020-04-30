package com.jing.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
	private static SqlSessionFactory  factory;
	static{
		InputStream in;
		try {
			in = Resources.getResourceAsStream("Sql.Map.Config.xml");
			factory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}

	

}
