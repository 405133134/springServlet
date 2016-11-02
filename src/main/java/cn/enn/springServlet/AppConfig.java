package cn.enn.springServlet;

import javax.sql.DataSource;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration 
@ComponentScan(basePackages = {"cn.enn.springServlet"})  
@EnableScheduling 
public class AppConfig {
	
	@Bean(name="mysqlDatasource")
	public DataSource dataSource(){
		
		DruidDataSource ds=new DruidDataSource();
		ds.setUrl("jdbc:mysql://database.ennwifi.cn:8000/enn-v3");
		ds.setPassword("enn1807");
		ds.setUsername("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setMaxActive(30);
		ds.setMaxWait(5 * 1000);
		return ds;
	}
	
	@Autowired
	@Bean
	public Dao dao(DataSource dataSource) {
		NutDao dao = new NutDao(dataSource);
		return dao;
	}
}
