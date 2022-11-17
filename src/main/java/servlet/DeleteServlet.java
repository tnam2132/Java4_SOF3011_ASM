package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;

import service.MayGiatService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utility.HibernateUtil;

@WebServlet("/may-giat/delete")
public class DeleteServlet extends HttpServlet {
	MayGiatService maygiatService = new MayGiatService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String ma = req.getParameter("ma");
			maygiatService.delete(ma);
			resp.getWriter().println("<script type=\"text/javascript\">");
			resp.getWriter().println("alert('Xóa thành công');");
			resp.getWriter().println("location.replace('/assignment/may-giat');");
			resp.getWriter().println("</script>");
		} catch (Exception e) {
			resp.getWriter().println("<script type=\"text/javascript\">");
			resp.getWriter().println("alert('Xóa không thành công');");
			resp.getWriter().println("location.replace('/assignment/may-giat');");
			resp.getWriter().println("</script>");
		}
	}
}
