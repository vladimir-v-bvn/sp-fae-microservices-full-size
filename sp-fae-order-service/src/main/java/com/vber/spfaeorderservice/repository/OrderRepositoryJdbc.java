package com.vber.spfaeorderservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.vber.spfaeorderservice.util.RecordSetToJSONConversion;

//@Slf4j
@Repository
public class OrderRepositoryJdbc implements OrderRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;
//private SimpleJdbcCall simpleJdbcCall;

  @Override
  public String vOrder() {
    return jdbcTemplate.query("SELECT * FROM v_order_camel",  new VTopEventsExtractor());
  }

  @Override
  public int orderCount() {
    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM v_order_camel", Integer.class);
  }

  private static final class VTopEventsExtractor implements ResultSetExtractor<String> {
    @Override
    public String extractData(ResultSet resultSet) throws SQLException {
      return RecordSetToJSONConversion.convertResultSetToJSONArray(resultSet);
    }
  }

}
