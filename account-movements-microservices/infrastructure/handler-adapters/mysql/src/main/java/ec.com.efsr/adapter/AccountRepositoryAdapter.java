package ec.com.efsr.adapter;

import ec.com.efsr.entities.AccountEntity;
import ec.com.efsr.exceptions.AccountNotFoundException;
import ec.com.efsr.exceptions.AccountNotSaveException;
import ec.com.efsr.exceptions.AccountNotUpdateException;
import ec.com.efsr.mappers.AccountMapper;
import ec.com.efsr.models.Account;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.repository.IAccountJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AccountRepositoryAdapter implements AccountRepositoryPort {
    private final IAccountJpaRepository accountJpaRepository;

    public AccountRepositoryAdapter(IAccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Optional<Account> findAccountById(String id) {
        AccountEntity accountEntity = accountJpaRepository.findById(id).orElse(null);
        if (accountEntity == null) {
            throw new AccountNotFoundException("Cuenta no encontrada");
        }
        return Optional.of(AccountMapper.accountEntityToModel(accountEntity));
    }

    @Override
    public List<Account> findAllAccounts() {
        List<AccountEntity> accounts = accountJpaRepository.findAll();
        if (accounts == null) {
            throw new AccountNotFoundException("No hay cuentas en la BD.");
        }
        return accounts.stream()
                .map(AccountMapper::accountEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        return AccountMapper.accountEntityToModel(accountJpaRepository.findByAccountNumber(accountNumber));
    }

    @Override
    public Optional<Account> saveAccount(Account account) {
        AccountEntity accountEntity = accountJpaRepository.save(AccountMapper.accountToAccountEntity(account));
        if (accountEntity == null) {
            throw new AccountNotSaveException("Error al guardar la cuenta.");
        }
        return Optional.of(AccountMapper.accountEntityToModel(accountEntity));
    }

    @Override
    public Optional<Account> updateAccount(Account account) {
        AccountEntity accountEntity = accountJpaRepository.save(AccountMapper.accountToAccountEntity(account));
        if (accountEntity == null) {
            throw new AccountNotUpdateException("Error al actualizar la cuenta.");
        }
        return Optional.of(AccountMapper.accountEntityToModel(accountEntity));
    }

    @Override
    public Account findByIdCustomer(String idCustomer) {
        AccountEntity accountEntity = accountJpaRepository.findByIdCustomer(idCustomer);
        if (accountEntity == null) {
            throw new AccountNotFoundException("Cuenta no encontrada para el cliente: " + idCustomer);
        }
        return AccountMapper.accountEntityToModel(accountEntity);
    }
}
