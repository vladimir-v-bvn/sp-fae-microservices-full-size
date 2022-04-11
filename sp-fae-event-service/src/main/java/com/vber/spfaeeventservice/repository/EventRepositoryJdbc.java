package com.vber.spfaeeventservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.vber.spfaeeventservice.util.RecordSetToJSONConversion;

//@Slf4j
@Repository
public class EventRepositoryJdbc implements EventRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;
//private SimpleJdbcCall simpleJdbcCall;

  @Override
  public String vEvent() {
    return jdbcTemplate.query("SELECT * FROM v_events_camel",  new VTopEventsExtractor());
  }

  @Override
  public int eventCount() {
    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM v_events", Integer.class);
  }

  private static final class VTopEventsExtractor implements ResultSetExtractor<String> {
    @Override
    public String extractData(ResultSet resultSet) throws SQLException {
      return RecordSetToJSONConversion.convertResultSetToJSONArray(resultSet);
    }
  }
}
