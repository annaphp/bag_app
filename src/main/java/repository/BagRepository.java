package repository;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Bag;
import model.Type;

public class BagRepository {

	JdbcTemplate jdbc;

	public BagRepository(DataSource ds) {
		jdbc = new JdbcTemplate(ds);
	}

	public Integer save(Bag bag) {
		if (bag.getType().getId() != 0) {

			jdbc.update("insert into bag (bag_type_id, name, description, price) values (" + bag.getType().getId() + ", '"
					+ bag.getName() + "' , '" + bag.getDescription() + "', " + bag.getPrice() + ")");
			return jdbc.queryForObject("select max(id) latest_id from bag", (ResultSet rs, int rowNum) -> {
				return rs.getInt("latest_id");
			});
		} else {
			return 0;
		}
	}

	public List<Bag> findAll() {
		return jdbc.query("select * from ( bag join bag_type on bag_type.id = bag.bag_type_id)",
				(ResultSet rs, int rowNum) -> {
					return new Bag(rs.getLong("id"), new Type(rs.getString("name"), rs.getLong("bag_type_id")),
							rs.getString("name"), rs.getString("description"), rs.getLong("price"));
				});

	}

	public List<Bag> findByType(Type type) {

		return jdbc.query("select * from bag where bag_type_id = " + type.getId(), (ResultSet rs, int rowNum) -> {
			return new Bag(rs.getLong("id"), type, rs.getString("name"), rs.getString("description"),
					rs.getLong("price"));
		});
	}

	public void updatePrice(Bag bag, Long price) {
		jdbc.update("update bag set price = " + price + " where id = " + bag.getId());
	}

	public void delete(Bag bag) {
		jdbc.update("delete from bag where id =" + bag.getId());
	}

	public Bag findByName(String name) {

		try {
			return jdbc.queryForObject("select * from (bag join bag_type on bag_type.id = bag.bag_type_id)"
					+ " where bag.name =" + "'" + name + "'", (ResultSet rs, int rowNum) -> {
						return new Bag(rs.getLong("id"), new Type(rs.getString("name"), rs.getLong("bag_type_id")),
								rs.getString("name"), rs.getString("description"), rs.getLong("price"));
					});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
