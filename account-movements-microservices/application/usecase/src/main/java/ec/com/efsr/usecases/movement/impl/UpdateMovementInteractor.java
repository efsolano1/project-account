package ec.com.efsr.usecases.movement.impl;

import ec.com.efsr.exceptions.MovementNotUpdatedException;
import ec.com.efsr.models.Movement;
import ec.com.efsr.repository.MovementRepositoryPort;
import ec.com.efsr.usecases.movement.IUpdateMovementInteractor;

public class UpdateMovementInteractor implements IUpdateMovementInteractor {
    private final MovementRepositoryPort movementRepositoryPort;

    public UpdateMovementInteractor(MovementRepositoryPort movementRepositoryPort) {
        this.movementRepositoryPort = movementRepositoryPort;
    }

    @Override
    public Movement updateMovement(Movement movement) {
        Movement movementUpdated = movementRepositoryPort.updateMovement(movement);
        if (movementUpdated == null) {
            throw new MovementNotUpdatedException("Error al actualizar el movimiento.");
        }
        return movementUpdated;
    }
}
