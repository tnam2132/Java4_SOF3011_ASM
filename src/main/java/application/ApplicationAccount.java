package application;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Account;
import model.AccountRole;
import repository.AccountRepository;
import service.AuthenticationService;
import utility.HibernateUtil;

public class ApplicationAccount {
	public static void main(String[] args) {
//		Account acc = new Account();
//		acc.setUsername("namnt");
//		acc.setHoten("Thanh Nam");
//		acc.setPassword("12345678@");
//		acc.setRole(AccountRole.ADMIN);
//		add(acc);
		read();
	}

	public static void read() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<Account> query = session.createQuery("SELECT ac FROM Account ac", Account.class);
		List<Account> accs = query.getResultList();
		for (Account acc : accs) {
			System.out.println(acc);
		}
		session.close();
	}

	public static void add(Account acc) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(acc);
		trans.commit();
		session.close();
	}
}
