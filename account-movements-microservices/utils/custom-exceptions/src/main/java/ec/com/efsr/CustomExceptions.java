package ec.com.efsr;

import ec.com.efsr.exceptions.AccountNotFoundException;
import ec.com.efsr.exceptions.AccountNotSaveException;
import ec.com.efsr.exceptions.AccountNotUpdateException;
import ec.com.efsr.exceptions.AccountNumberExistException;
import ec.com.efsr.exceptions.AccountNumberNotFoundException;
import ec.com.efsr.exceptions.AccountsNotFoundException;
import ec.com.efsr.exceptions.CustomerNotFoundException;
import ec.com.efsr.exceptions.MovementNotFoundException;
import ec.com.efsr.exceptions.MovementsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptions {

    @ExceptionHandler(MovementsNotFoundException.class)
    public ResponseEntity<Map<String, String>> movementsNotFoundExceptionHandler(MovementsNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovementNotFoundException.class)
    public ResponseEntity<Map<String, String>> movementNotFoundExceptionHandler(MovementNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNotUpdateException.class)
    public ResponseEntity<Map<String, String>> accountNotUpdateExceptionHandler(AccountNotUpdateException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, String>> customerNotFoundExceptionHandler(CustomerNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNotSaveException.class)
    public ResponseEntity<Map<String, String>> accountNotSaveExceptionHandler(AccountNotSaveException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNumberExistException.class)
    public ResponseEntity<Map<String, String>> accountNumberExistExceptionHandler(AccountNumberExistException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNumberNotFoundException.class)
    public ResponseEntity<Map<String, String>> accountNumberNotFoundExceptionHandler(AccountNumberNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountsNotFoundException.class)
    public ResponseEntity<Map<String, String>> accountsNotFoundExceptionHandler(AccountsNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String, String>> accountNotFoundExceptionHandler(AccountNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> runtimeExceptionHandler(RuntimeException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validatorExceptionsHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalExceptionsHandler(Exception ex) {
        return new ResponseEntity<>("Error interno del servidor ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
