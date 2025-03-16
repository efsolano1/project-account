package ec.com.efsr.mapper;

import ec.com.efsr.dto.movementDto.MovementInDto;
import ec.com.efsr.dto.movementDto.MovementOutDto;
import ec.com.efsr.models.Account;
import ec.com.efsr.models.Movement;

public class MovementMapper {
    public static MovementOutDto movementToMovementOutDto(Movement movement) {
        if (movement == null) {
            return null;
        }
        MovementOutDto movementOutDto = new MovementOutDto();
        movementOutDto.setIdMovement(movement.getIdMovement());
        movementOutDto.setDate(movement.getDate());
        movementOutDto.setTypeMovement(movement.getTypeMovement());
        movementOutDto.setAmount(movement.getAmount());
        movementOutDto.setBalance(movement.getBalance());
        movementOutDto.setDetailMovement(movement.getDetailMovement());
        movementOutDto.setIdAccount(movement.getAccount().getIdAccount());
        return movementOutDto;
    }

    public static Movement movementInDtoToMovement(MovementInDto movementInDto) {
        if (movementInDto == null) {
            return null;
        }
        Movement movement = new Movement();
        movement.setIdMovement(movementInDto.getIdMovement());
        movement.setTypeMovement(movementInDto.getTypeMovement());
        movement.setAmount(movementInDto.getAmount());
        movement.setDetailMovement(movementInDto.getDetailMovement());
        movement.setAccount(new Account(movementInDto.getIdAccount()));
        return movement;
    }

}
