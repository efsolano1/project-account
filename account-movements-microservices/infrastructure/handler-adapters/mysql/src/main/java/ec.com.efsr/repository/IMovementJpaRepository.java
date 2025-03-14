package ec.com.efsr.repository;

import ec.com.efsr.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovementJpaRepository extends JpaRepository<MovementEntity, String> {
}
