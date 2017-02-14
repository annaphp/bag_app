package repository;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Type;

public class TypeRepository {
	
	JdbcTemplate jdbc;

	public TypeRepository(DataSource ds) {
		this.jdbc = new JdbcTemplate(ds);
	}
	
	public Integer save(Type type){
		jdbc.update("insert into bag_type (name) values ('" + type.getName() + "')");
		return jdbc.queryForObject("select max(id) latest_id from bag_type",
				(ResultSet rs, int rowNum)->{ return rs.getInt("latest_id");});			
	}
	
	public List<Type> findAll(){
		return jdbc.query("select * from bag_type",
				(ResultSet rs, int rowNum)-> {return new Type(rs.getString("name"), rs.getLong("id"));});
	}
	
	public Type findByName(String name){
		return jdbc.queryForObject("select * from bag_type where name='" + name + "' ",
				(ResultSet rs, int rowNum) -> {return new Type(rs.getString("name"), rs.getLong("id"));});
	}

}
