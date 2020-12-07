package titan.io.tjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import titan.io.tjava.model.Writer;

@Repository
public interface Writer_Repository extends JpaRepository<Writer, Integer> {
}
