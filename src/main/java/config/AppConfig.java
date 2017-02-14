package config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repository.BagRepository;
import repository.TypeRepository;

@Configuration
public class AppConfig {
	
	  @Bean
	  public DataSource dataSource(){
		  BasicDataSource ds = new BasicDataSource();
		  ds.setDriverClassName("com.mysql.jdbc.Driver");
		  ds.setUrl("jdbc:mysql://localhost:3306/bags_app");
		  ds.setUsername("root");
		  ds.setPassword("root");	 
		  ds.setInitialSize(5);
		  ds.setMaxActive(20);
		  return ds;  
	  }
	  
	 @Bean
	 public TypeRepository typeRepository(){
		 return new TypeRepository(dataSource());
		 
	 }
	 
	 @Bean
	 public BagRepository bagRepository(){
		 return new BagRepository(dataSource());
		 
	 }
	
  

}
