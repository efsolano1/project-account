package ec.com.efsr.usecases.movement.impl;

import ec.com.efsr.exceptions.MovementNotFoundException;
import ec.com.efsr.models.Movement;
import ec.com.efsr.repository.MovementRepositoryPort;
import ec.com.efsr.usecases.movement.IFindMovementByIdInteractor;

public class FindMovementByIdInteractor implements IFindMovementByIdInteractor {
    private final MovementRepositoryPort movementRepositoryPort;;

    public FindMovementByIdInteractor(MovementRepositoryPort movementRepositoryPort) {
        this.movementRepositoryPort = movementRepositoryPort;
    }

    @Override
    public Movement findMovementById(String id) {
        return movementRepositoryPort.findMovementById(id)
                .orElseThrow(()-> new MovementNotFoundException("Movimiento no encontrado"));
    }
}
