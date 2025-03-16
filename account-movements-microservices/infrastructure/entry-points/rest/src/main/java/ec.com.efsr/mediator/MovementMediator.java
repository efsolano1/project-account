package ec.com.efsr.mediator;

import ec.com.efsr.dto.movementDto.MovementInDto;
import ec.com.efsr.dto.movementDto.MovementOutDto;
import ec.com.efsr.mapper.MovementMapper;
import ec.com.efsr.usecases.movement.IFindAllMovementsInteractor;
import ec.com.efsr.usecases.movement.IFindMovementByIdInteractor;
import ec.com.efsr.usecases.movement.ISaveMovementInteractor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovementMediator {
    private final IFindMovementByIdInteractor findMovementByIdInteractor;
    private final IFindAllMovementsInteractor findAllMovementsInteractor;
    private final ISaveMovementInteractor saveMovementInteractor;
    ;

    public MovementMediator(IFindMovementByIdInteractor findMovementByIdInteractor, IFindAllMovementsInteractor findAllMovementsInteractor, ISaveMovementInteractor saveMovementInteractor) {
        this.findMovementByIdInteractor = findMovementByIdInteractor;
        this.findAllMovementsInteractor = findAllMovementsInteractor;
        this.saveMovementInteractor = saveMovementInteractor;
    }

    public MovementOutDto findMovementById(String id) {
        return MovementMapper.movementToMovementOutDto(findMovementByIdInteractor.findMovementById(id));
    }

    public List<MovementOutDto> findAllMovements() {
        return findAllMovementsInteractor.findAllMovements()
                .stream()
                .map(MovementMapper::movementToMovementOutDto)
                .collect(Collectors.toList());
    }

    public MovementOutDto saveMovement(MovementInDto movementInDto) {
        return MovementMapper.movementToMovementOutDto(saveMovementInteractor.saveMovement(MovementMapper.movementInDtoToMovement(movementInDto)));
    }
}
