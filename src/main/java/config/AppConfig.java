package config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import repository.BagRepository;
import repository.TypeRepository;

@Configuration
public class AppConfig {

	@Bean
	@Profile("production")
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bags_app");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setInitialSize(5);
		ds.setMaxActive(20);
		return ds;
	}

	@Bean(name = "dataSource")
	@Profile("test")
	public DataSource embededDataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder
				.setType(EmbeddedDatabaseType.H2)
				.addScript("init.sql")
				.build();
	}

	@Bean
	public TypeRepository typeRepository(DataSource dataSource) {
		return new TypeRepository(dataSource);

	}

	@Bean
	public BagRepository bagRepository(DataSource dataSource) {
		return new BagRepository(dataSource);

	}

}
