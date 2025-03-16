package ec.com.efsr.usecases.movement.impl;

import ec.com.efsr.exceptions.AccountNotFoundException;
import ec.com.efsr.exceptions.BalanceNotAvailableException;
import ec.com.efsr.exceptions.MovementNotSaveException;
import ec.com.efsr.models.Account;
import ec.com.efsr.models.Movement;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.repository.MovementRepositoryPort;
import ec.com.efsr.usecases.account.impl.UpdateAccountInteractor;
import ec.com.efsr.usecases.enums.TypeTransaction;
import ec.com.efsr.usecases.movement.ISaveMovementInteractor;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaveMovementInteractor implements ISaveMovementInteractor {
    private final MovementRepositoryPort movementRepositoryPort;
    private final AccountRepositoryPort accountRepositoryPort;
    private final UpdateAccountInteractor   updateAccountInteractor;

    public SaveMovementInteractor(MovementRepositoryPort movementRepositoryPort, AccountRepositoryPort accountRepositoryPort, UpdateAccountInteractor updateAccountInteractor) {
        this.movementRepositoryPort = movementRepositoryPort;
        this.accountRepositoryPort = accountRepositoryPort;
        this.updateAccountInteractor = updateAccountInteractor;
    }
    @Transactional
    @Override
    public Movement saveMovement(Movement movement) {

        Account  accountUpdate = accountRepositoryPort.findAccountById(movement.getAccount().getIdAccount()).orElse(null);
        if (accountUpdate == null) {
            throw new AccountNotFoundException("La cuenta no existe");
        }

        BigDecimal newBalance = accountUpdate.getOpeningBalance().add(movement.getAmount());
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new BalanceNotAvailableException("Saldo no disponible");
        }

        accountUpdate.setOpeningBalance(newBalance);
        updateAccountInteractor.updateAccount(accountUpdate, false);

        movement.setDate(LocalDateTime.now());

        String detail;
        if (movement.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            detail = TypeTransaction.RETIRO.name() + " " + movement.getAmount().abs();
        } else {
            detail = TypeTransaction.DEPOSITO.name() + " " + movement.getAmount();
        }

        movement.setDetailMovement(detail);
        movement.setBalance(newBalance);
        movement.setIdAccount(accountUpdate.getIdAccount());
        Movement movementSaved = this.movementRepositoryPort.saveMovement(movement);
        if (movementSaved == null) {
            throw new MovementNotSaveException("Error creando movimiento");
        }


        return movementSaved;
    }
}
