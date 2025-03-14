package ec.com.efsr.usecases.account.impl;

import ec.com.efsr.models.Account;
import ec.com.efsr.repository.AccountRepositoryPort;
import ec.com.efsr.usecases.account.ISaveAccountInteractor;

public class SaveAccountInteractor implements ISaveAccountInteractor {
    private final AccountRepositoryPort accountRepository;
   // private final ISendAndReceiveInformation sendAndReceiveInformation;

    public SaveAccountInteractor(AccountRepositoryPort accountRepository ) {
        this.accountRepository = accountRepository;
       // this.sendAndReceiveInformation = sendAndReceiveInformation;
    }

    @Override
    public Account saveAccount(Account account) {
//        if(accountRepository.findAccountByAccountNumber(account.getAccountNumber()).isPresent()){
//            throw new RuntimeException("La cuenta ya existe");
//        }
//        Object response;
//        String idCustomer;
//
//        response = sendAndReceiveInformation.sendAndReceiveInformation(account.getIdCustomer());
//        idCustomer = response.toString();
//
//        if(response == null || response == "" || idCustomer == null || idCustomer == ""){
//            throw new RuntimeException("No se pudo obtener el id del cliente");
//        }
//        account.setIdCustomer(idCustomer);

        Account accountSaved = accountRepository.saveAccount(account).orElse(null);
        if(accountSaved == null){
            throw new RuntimeException("No se pudo guardar la cuenta");
        }
        return accountSaved;
    }
}
