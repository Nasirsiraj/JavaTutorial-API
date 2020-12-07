package titan.io.tjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import titan.io.tjava.model.Tutorial;

@Repository
public interface Tutorial_Repository extends JpaRepository<Tutorial, Integer> {
}
