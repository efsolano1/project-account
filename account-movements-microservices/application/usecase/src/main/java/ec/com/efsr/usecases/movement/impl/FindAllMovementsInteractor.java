package ec.com.efsr.usecases.movement.impl;

import ec.com.efsr.exceptions.MovementsNotFoundException;
import ec.com.efsr.models.Movement;
import ec.com.efsr.repository.MovementRepositoryPort;
import ec.com.efsr.usecases.movement.IFindAllMovementsInteractor;

import java.util.List;

public class FindAllMovementsInteractor implements IFindAllMovementsInteractor {
    private final MovementRepositoryPort movementRepositoryPort;

    public FindAllMovementsInteractor(MovementRepositoryPort movementRepositoryPort) {
        this.movementRepositoryPort = movementRepositoryPort;
    }

    @Override
    public List<Movement> findAllMovements() {
        List<Movement> movements = movementRepositoryPort.findAllMovements();
        if(movements.isEmpty()){
            throw new MovementsNotFoundException("No se encontraron movimientos");
        }
        return movements;
    }
}
