package com.example.GROUP2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@Slf4j
@SpringBootTest
class GROUP2Tests {


	@Autowired
	JdbcTemplate jdbcTemplate;
//	@Autowired
//	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {
//		jdbcTemplate.queryForObject("select * from sys_product");
//		jdbcTemplate.queryForList("select * from sys_product",)
		Long along = jdbcTemplate.queryForObject
				("select count(*) from sys_user",
						Long.class);
		log.info("记录总数:{}",along);
		new Thread(()->{

		}).start();
//		//查看一下默认的数据源：com.zaxxer.hikari.HikariDataSource
//		System.out.println(dataSource.getClass());
//		System.out.println(dataSource.getConnection());
	}

}
