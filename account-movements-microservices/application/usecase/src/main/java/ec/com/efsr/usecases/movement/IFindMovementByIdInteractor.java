package ec.com.efsr.usecases.movement;

import ec.com.efsr.models.Movement;

public interface IFindMovementByIdInteractor {
    Movement findMovementById(String id);
}
