package repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Account;
import model.MayGiat;
import utility.HibernateUtil;

public class AccountRepository {

	public List<Account> getAll() {
		List<Account> accs = null;
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<Account> query = session.createQuery("FROM Account acc", Account.class);
		accs = query.getResultList();
		session.close();
		return accs;
	}

	public Account getByUserName(String username) {
		List<Account> accs = getAll();
		for (Account acc : accs) {
			if (acc.getUsername().equals(username)) {
				return acc;
			}
		}
		return null;
	}
	
	public void addAccount(Account acc) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(acc);
		trans.commit();
		session.close();
	}

}
