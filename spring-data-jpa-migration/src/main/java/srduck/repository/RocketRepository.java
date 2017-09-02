package srduck.repository;

import org.springframework.data.repository.CrudRepository;
import srduck.dao.Rocket;

public interface RocketRepository extends CrudRepository<Rocket, Integer> {
}
