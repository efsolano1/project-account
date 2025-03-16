package ec.com.efsr.controller;

import ec.com.efsr.dto.accountDto.AccountInDto;
import ec.com.efsr.dto.accountDto.AccountOutDto;
import ec.com.efsr.dto.reportDto.AccountReportOutDto;
import ec.com.efsr.mediator.AccountMediator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class AccountRestController {
    private final AccountMediator accountMediator;

    public AccountRestController(AccountMediator accountMediator) {
        this.accountMediator = accountMediator;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountOutDto> findAccountById(@PathVariable String id) {
        var response = accountMediator.findAccountById(id);
        return response != null ?
                ResponseEntity.status(200).body(response) :
                ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity<List<AccountOutDto>> findAllAccounts() {
        List<AccountOutDto> response = accountMediator.findAllAccounts();
        return response.isEmpty() ?
                ResponseEntity.status(204).build() :
                ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public ResponseEntity<AccountOutDto> createAccount(@RequestBody @Valid AccountInDto accountInDto) {
        var response = accountMediator.saveAccount(accountInDto);
        return response != null ?
                ResponseEntity.status(201).body(response) :
                ResponseEntity.status(500).build();
    }

    @PutMapping
    public ResponseEntity<AccountOutDto> updateAccount(@RequestBody @Valid AccountInDto accountInDto) {
        var response = accountMediator.updateAccount(accountInDto);
        return response != null ?
                ResponseEntity.status(200).body(response) :
                ResponseEntity.status(500).build();
    }

    @GetMapping("/reportes")
    public ResponseEntity<List<AccountReportOutDto>> getReport(
            @RequestParam("dateRange") String dateRange,
            @RequestParam("identification") String customerId) {
        var response = accountMediator.findAccountReport(dateRange, customerId);
        return response.isEmpty() ?
                ResponseEntity.status(204).build() :
                ResponseEntity.status(200).body(response);
    }
}
