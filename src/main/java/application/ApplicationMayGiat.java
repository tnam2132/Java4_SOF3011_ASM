package application;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.MayGiat;
import service.MayGiatService;
import utility.HibernateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ApplicationMayGiat {
	public static void main(String[] args) {
//		MayGiat mg1 = new MayGiat(18, "LG MXT", "Nam ngang", 1000, "Thiet ke theo cong nghe Nhat Ban", BigDecimal.valueOf(10000), 200,
//				"namnt", new Date(), "namnt", new Date(), false);
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		String thoidiemtao = ("2022/08/03 17:21:39.327");
		try {
			Date thoidiemtao2 =  dateFormat.parse(thoidiemtao);
			System.out.println(thoidiemtao2);
		} catch (ParseException e) {
			System.out.println("lỗi");
			e.printStackTrace();
		}
		
//		MayGiat mg1 = new MayGiat();
//		mg1.setMa(17);
//		mg1.setThoiDiemTao(null);
//		update("17", mg1);
//		read();
	}

	public static void read() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<MayGiat> query = session.createQuery("SELECT mg FROM MayGiat mg", MayGiat.class);
		List<MayGiat> listMayGiat = query.getResultList();
		for (MayGiat mayGiat2 : listMayGiat) {
			System.out.println(mayGiat2);
		}
		session.close();
	}

	public static void add(MayGiat mayGiat) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(mayGiat);
		trans.commit();
		session.close();
	}
	
	public static void update(String id, MayGiat mayGiat) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(id, mayGiat);
		trans.commit();
		session.close();
	}
	
	public static void delete(MayGiat mayGiat) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(mayGiat);
		trans.commit();
		session.close();
	}
}
