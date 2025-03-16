package ec.com.efsr.repository;

import ec.com.efsr.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovementJpaRepository extends JpaRepository<MovementEntity, String> {
    @Query("SELECT m FROM MovementEntity m WHERE m.account.idAccount = :idAccount " +
            "ORDER BY m.date DESC")
    List<MovementEntity> findMovementsByIdAccount(@Param("idAccount") String idAccount);
}
