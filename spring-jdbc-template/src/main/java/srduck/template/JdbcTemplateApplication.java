package srduck.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class JdbcTemplateApplication implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main (String... args){
        SpringApplication.run(JdbcTemplateApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Создание таблиц");
        createTable();
        read();
        log.info("========================>After create table");

        create("Soyuz", 1);
        create("Falcon", 2);
        create("Angara",3);
        read();
        log.info("========================> After insert");

        update("Soyuz 2", 1);
        update("Falcon 9", 2);
        update("Angara A5", 3);
        read();
        log.info("=======================> After update");

        delete("Soyuz 2");
        read();
        log.info("=======================> After delete 1");

        delete("Falcon 9");
        read();
        log.info("=======================> After delete 2");

        delete("Angara");
        read();
        log.info("=======================> After delete 3");

        delete("Angara A5");
        read();
        log.info("=======================> After delete 4");


    }

    private void createTable(){
        String sql = "CREATE TABLE ROCKETS ( "+
                     "id integer PRIMARY KEY NOT NULL, " +
                     "model varchar(32) NOT NULL)";
        jdbcTemplate.execute(sql);
    }

    private void delete(String model){
        jdbcTemplate.update("DELETE FROM ROCKETS WHERE model = ?", model);

    }

    private void update(String model, int id){
        jdbcTemplate.update("UPDATE ROCKETS SET model = ? WHERE id = ?", model, id);
    }

    private void create(String model, int id){
        jdbcTemplate.update("INSERT INTO ROCKETS VALUES (?,?)", id, model);
    }


    private void read(){
        List<Rocket> list = jdbcTemplate.query("SELECT * FROM ROCKETS",
                (rs, rowNum) -> new Rocket(rs.getInt("id"),
                                  rs.getString("model")));

        if (list.size() == 0){;
            log.info("NO RECORDS");
        }
        else{
            for (Rocket rocket : list){
                log.info(rocket.toString());
            }
        }

    }
}
