package ec.com.efsr.repository;

import ec.com.efsr.models.Movement;


import java.util.List;
import java.util.Optional;

public interface MovementRepositoryPort {
    Optional<Movement> findMovementById(String id);
    List<Movement> findAllMovements();
    Movement saveMovement(Movement movement);
    Movement updateMovement(Movement movement);
    //List<Movement> findMovementsByReport(Specification<Movement> spec);
    List<Movement> findMovementsByIdAccount(String idAccount);
}
