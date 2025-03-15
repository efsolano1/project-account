package ec.com.efsr.mappers;

import ec.com.efsr.entities.AccountEntity;
import ec.com.efsr.entities.MovementEntity;
import ec.com.efsr.models.Account;
import ec.com.efsr.models.Movement;

public class MovementMapper {
    public static Movement movementEntityToMovement(MovementEntity movementEntity){
        if (movementEntity == null) {
            return null;
        }
        Movement movement = new Movement();
        movement.setIdMovement(movementEntity.getIdMovement());
        movement.setDate(movementEntity.getDate());
        movement.setTypeMovement(movementEntity.getTypeMovement());
        movement.setAmount(movementEntity.getAmount());
        movement.setBalance(movementEntity.getBalance());
        movement.setDetailMovement(movement.getDetailMovement());
        movement.setAccount(new Account(movementEntity.getAccount().getIdAccount()));
        return movement;
    }

    public static MovementEntity movementToMovementEntity(Movement movement){
        if (movement == null) {
            return null;
        }
        MovementEntity movementEntity = new MovementEntity();
        movementEntity.setIdMovement(movement.getIdMovement());
        movementEntity.setDate(movement.getDate());
        movementEntity.setTypeMovement(movement.getTypeMovement());
        movementEntity.setAmount(movement.getAmount());
        movementEntity.setBalance(movement.getBalance());
        movementEntity.setDetailMovement(movement.getDetailMovement());
        movementEntity.setAccount(new AccountEntity(movement.getAccount().getIdAccount()));
        return movementEntity;
    }
}
