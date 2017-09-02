package srduck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import srduck.dao.Rocket;
import srduck.repository.RocketRepository;

import java.util.List;

@SpringBootApplication
@EntityScan(basePackageClasses = srduck.dao.Rocket.class)
@EnableJpaRepositories("srduck.repository")
public class JpaSpringApplicaition implements CommandLineRunner {

    private final static Logger log = LoggerFactory.getLogger(JpaSpringApplicaition.class);
    private List<Rocket> rocketList;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    RocketRepository rocketRepository;

    public static void main (String... args){
        SpringApplication.run(JpaSpringApplicaition.class);
    }

    @Override
    public void run(String... args) throws Exception {

        read();

        Rocket soyuz = create("Soyuz");
        Rocket falcon = create("Falcon");
        Rocket angara = create("Angara");
        read();
        log.info("====================== After create");

        update(soyuz, "Soyuz 2");
        update(falcon, "Falcon 9");
        update(angara, "Angara A5");
        read();
        log.info("===================== After update");


        delete(falcon);
        read();
        log.info("===================== After delete 1");

        delete(soyuz);
        read();
        log.info("===================== After delete 2");

        delete(soyuz);
        read();
        log.info("===================== After delete 3");

        delete(angara);
        read();
        log.info("===================== After delete 4");

    }

    private void delete(Rocket rocket){
        rocketRepository.delete(rocket);
    }

    private void update(Rocket rocket, String model) {
        rocket.setModel(model);
        rocketRepository.save(rocket);
    }

    private Rocket create(String model){
        Rocket rocket = new Rocket();
        rocket.setModel(model);
        rocketRepository.save(rocket);
        return rocket;
    }

    private void read(){
        rocketList = (List<Rocket>) rocketRepository.findAll();
        if (rocketList.size() == 0){
            log.info("NO RECORDS");
        }
        else {
            rocketList.stream().forEach(rocket -> log.info(rocket.toString()));
        }
    }
}
