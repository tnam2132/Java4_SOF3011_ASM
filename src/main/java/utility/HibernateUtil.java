package utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.hql.internal.ast.tree.Statement;
import org.hibernate.service.ServiceRegistry;

import model.Account;
import model.MayGiat;

public class HibernateUtil {
	private static final SessionFactory FACTORY;

	static {
		Configuration conf = new Configuration();
		// Cấu hình kết nối
		Properties properties = new Properties();
		properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
		properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=dsMayGiat;encrypt=true;trustServerCertificate=true;");
		properties.put(Environment.USER, "sa");
		properties.put(Environment.PASS, "songlong");
		properties.put(Environment.SHOW_SQL, "true");
		// tự động tạo DB
//		properties.put(Environment.HBM2DDL_AUTO, "create");
		conf.setProperties(properties);
		// Khai báo class đã ánh xạ
		conf.addAnnotatedClass(MayGiat.class);
		conf.addAnnotatedClass(Account.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		FACTORY = conf.buildSessionFactory(registry);

	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}

}
