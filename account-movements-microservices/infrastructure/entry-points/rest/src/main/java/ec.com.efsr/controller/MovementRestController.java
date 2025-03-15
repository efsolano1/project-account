package ec.com.efsr.controller;

import ec.com.efsr.dto.movementDto.MovementInDto;
import ec.com.efsr.dto.movementDto.MovementOutDto;
import ec.com.efsr.mediator.MovementMediator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovementRestController {
    private final MovementMediator movementMediator;

    public MovementRestController(MovementMediator movementMediator) {
        this.movementMediator = movementMediator;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementOutDto> findMovementById(@PathVariable String id) {
        var response = movementMediator.findMovementById(id);
        return response != null ?
                ResponseEntity.status(200).body(response) :
                ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity<List<MovementOutDto>> findAllMovements() {
        var response = movementMediator.findAllMovements();
        return response.isEmpty() ?
                ResponseEntity.status(204).build():
                ResponseEntity.status(200).body(response) ;

    }

    @PostMapping
    public ResponseEntity<MovementOutDto> saveMovement(@RequestBody @Valid MovementInDto movementInDto){
        var response = movementMediator.saveMovement(movementInDto);
        return response != null ?
                ResponseEntity.status(201).body(response) :
                ResponseEntity.status(500).build();
    }
}
