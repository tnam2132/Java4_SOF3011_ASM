package repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.MayGiat;
import utility.HibernateUtil;

public class MayGiatRepository {
	public List<MayGiat> getAll() {
		List<MayGiat> mayGiats = null;
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<MayGiat> query = session.createQuery("FROM MayGiat mg", MayGiat.class);
		mayGiats = query.getResultList();
		session.close();
		return mayGiats;
	}

	public List<MayGiat> getAllUser() {
		List<MayGiat> mayGiats1 = null;
		List<MayGiat> mayGiats2 = new ArrayList<>();
		mayGiats1 = getAll();
		for (MayGiat mayGiat : mayGiats1) {
			if (mayGiat.isDaXoa() == false) {
				mayGiats2.add(mayGiat);
			}
		}
		return mayGiats2;
	}

	public void insert(MayGiat mayGiat) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(mayGiat);
		trans.commit();
		session.close();
	}

	public void update(MayGiat mayGiat) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(mayGiat);
		trans.commit();
		session.close();
	}

	public List<MayGiat> getByFilter(String tenTimKiem, Boolean daxoa, BigDecimal giaTu, BigDecimal giaDen,
			String soLuong) {
		String hql = "FROM MayGiat mg WHERE mg.ten LIKE :ten";
		if (giaTu != null && giaDen != null) {
			hql += " AND mg.gia BETWEEN :giaTu AND :giaDen";
		}
		if (daxoa != null) {
			hql += " AND mg.daXoa = :daxoa";
		}
		if (soLuong != null) {
			if (soLuong.equalsIgnoreCase("DESC")) {
				hql += " ORDER BY mg.soLuong DESC";
			}
			if (soLuong.equalsIgnoreCase("ASC")) {
				hql += " ORDER BY mg.soLuong ASC";
			}
		}
		List<MayGiat> mayGiats = new ArrayList<>();
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<MayGiat> query = session.createQuery(hql, MayGiat.class);

		query.setParameter("ten", "%" + tenTimKiem + "%");
		if (giaTu != null && giaDen != null) {
			query.setParameter("giaTu", giaTu);
			query.setParameter("giaDen", giaDen);
		}
		if (daxoa != null) {
			query.setParameter("daxoa", daxoa);
		}
		mayGiats = query.getResultList();
		session.close();
		return mayGiats;
	}

	public void delete(MayGiat mayGiat) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(mayGiat);
		trans.commit();
		session.close();
	}

	public MayGiat selectById(Integer ma) {
		MayGiat mayGiat = null;
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		mayGiat = session.find(MayGiat.class, ma);
		session.close();
		return mayGiat;
	}
}
