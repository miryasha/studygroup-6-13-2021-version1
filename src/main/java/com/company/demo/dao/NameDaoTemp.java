package com.company.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NameDaoTemp {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_NAME_SQL =
            "insert into car (name) values( ?)";


@Autowired
    public NameDaoTemp(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}


}
