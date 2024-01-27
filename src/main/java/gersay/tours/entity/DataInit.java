package gersay.tours.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update("INSERT INTO users (username,password, enabled) VALUES (?,?,?)", "admin", passwordEncoder().encode("admin"), true);
        jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?,?,?)", "user", passwordEncoder().encode("user"), true);

        jdbcTemplate.update("INSERT INTO authorities (username, authorities) VALUES (?,?)", "admin", "ROLE_ADMIN");
        jdbcTemplate.update("INSERT INTO authorities (username, authorities) VALUES (?,?)", "user", "ROLE_USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
