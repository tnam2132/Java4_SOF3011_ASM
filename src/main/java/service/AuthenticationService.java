package service;

import model.Account;
import model.AccountRole;
import repository.AccountRepository;

public class AuthenticationService {
	private final AccountRepository accountRepo = new AccountRepository();

	public Account authentica(String username, String password) {
		Account acc = accountRepo.getByUserName(username);
		if (acc == null) {
			return null;
		}
		if (!acc.getPassword().equals(password)) {
			return null;
		}
		return acc;
	}
}
