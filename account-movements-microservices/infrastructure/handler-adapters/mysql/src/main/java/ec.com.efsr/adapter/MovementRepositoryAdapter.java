package ec.com.efsr.adapter;

import ec.com.efsr.entities.MovementEntity;
import ec.com.efsr.exceptions.MovementNotFoundException;
import ec.com.efsr.exceptions.MovementNotSaveException;
import ec.com.efsr.exceptions.MovementNotUpdatedException;
import ec.com.efsr.exceptions.MovementsNotFoundException;
import ec.com.efsr.mappers.MovementMapper;
import ec.com.efsr.models.Account;
import ec.com.efsr.models.Movement;
import ec.com.efsr.repository.IMovementJpaRepository;
import ec.com.efsr.repository.MovementRepositoryPort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovementRepositoryAdapter implements MovementRepositoryPort {
    public final IMovementJpaRepository movementRepository;

    public MovementRepositoryAdapter(IMovementJpaRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Optional<Movement> findMovementById(String id) {
         MovementEntity movementEntity = movementRepository.findById(id).orElse(null);
         if(movementEntity == null){
             throw new MovementNotFoundException("Movimiento no encontrado");
         }
         return Optional.of(MovementMapper.movementEntityToMovement(movementEntity));
    }

    @Override
    public List<Movement> findAllMovements() {
        List<MovementEntity> movements = movementRepository.findAll();
        if(movements.isEmpty()){
            throw new MovementsNotFoundException("No hay movimientos en la BD");
        }
        return movements.stream()
                .map(MovementMapper::movementEntityToMovement)
                .collect(Collectors.toList());
    }

    @Override
    public Movement saveMovement(Movement movement) {
        Account account = new Account(movement.getIdAccount());
        movement.setAccount(account);
        var movementEntity = movementRepository.save(MovementMapper.movementToMovementEntity(movement));
        if(movementEntity == null){
            throw new MovementNotSaveException("Error al guardar el movimiento.");
        }
        return MovementMapper.movementEntityToMovement(movementEntity);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        Account account = new Account(movement.getIdAccount());
        movement.setAccount(account);
        var movementEntity = movementRepository.save(MovementMapper.movementToMovementEntity(movement));
        if(movementEntity == null){
            throw new MovementNotUpdatedException("Error al actualizar el movimiento");
        }
        return MovementMapper.movementEntityToMovement(movementEntity);
    }

//    @Override
//    public List<Movement> findMovementsByReport(Specification<Movement> spec) {
//        return List.of();
//    }

    @Override
    public List<Movement> findMovementsByIdAccount(String idAccount) {
        List<MovementEntity> movementList = movementRepository.findMovementsByIdAccount(idAccount);
        return movementList
                .stream()
                .map(MovementMapper::movementEntityToMovement)
                .collect(Collectors.toList());
    }
}
