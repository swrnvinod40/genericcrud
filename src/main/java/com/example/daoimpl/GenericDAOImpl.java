package com.example.daoimpl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.dao.GenericDAO;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;

@Component
public class GenericDAOImpl implements GenericDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	 final String sql = "{call dbo.customer_proc(:keys)}";

	
	public void testTVP(){
		
		
		try {
			SQLServerDataTable servertable = new SQLServerDataTable();
			servertable.addColumnMetadata("id",Types.VARCHAR);
			servertable.addColumnMetadata("firstname",Types.VARCHAR);
			servertable.addColumnMetadata("lastname",Types.VARCHAR);
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("keys", servertable);
			NamedParameterJdbcTemplate namesTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
			namesTemplate.update(sql, param);
			System.out.println("executed successfully");
			
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
