package cn.enn.springServlet;

import javax.sql.DataSource;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.druid.pool.DruidDataSource;

import cn.enn.config.AppConfigure;
import cn.enn.config.Profile;

@Configuration 
@ComponentScan(basePackages = {"cn.enn.springServlet"})  
@EnableScheduling 
public class AppConfig {
	
	@Bean(name="mysqlDatasource")
	public DataSource dataSource() throws Exception{
		System.out.println("数据库");
		Profile profile = AppConfigure.getProfile();
		cn.enn.config.DataSource dataSource = profile.getDataSource();
		
		System.out.println("数据库信息："+Json.toJson(dataSource));
		
		DruidDataSource ds=new DruidDataSource();
		ds.setUrl(dataSource.getUrl());
		ds.setPassword(dataSource.getPassword());
		ds.setUsername(dataSource.getUser());
		ds.setDriverClassName(dataSource.getDriver());
		ds.setMaxActive(30);
		ds.setMaxWait(5 * 1000);
		ds.addFilters("stat");
		return ds;
	}
	
	@Autowired
	@Bean
	public Dao dao(DataSource dataSource) {
		System.out.println("dao");
		NutDao dao = new NutDao(dataSource);
		return dao;
	}
}
