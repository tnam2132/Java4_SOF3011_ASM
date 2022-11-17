package service;

import model.Account;
import model.AccountRole;
import repository.AccountRepository;

public class AccountService {
	private final AccountRepository accountRepo = new AccountRepository();

	public Account getByUserName(String username) {
		return accountRepo.getByUserName(username);
	}

	public void addAccount(String username, String hoten, String password, AccountRole role) {
		Account acc = new Account();
		acc.setUsername(username);
		acc.setHoten(hoten);
		acc.setPassword(password);
		acc.setRole(role);
		accountRepo.addAccount(acc);
	}
}
