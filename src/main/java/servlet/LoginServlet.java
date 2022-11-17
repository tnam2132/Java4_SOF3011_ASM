package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private final AuthenticationService authenService = new AuthenticationService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Account acc = authenService.authentica(username, password);
		HttpSession session = req.getSession();
		if (acc == null) {
			resp.getWriter().println("<script type=\"text/javascript\">");
			resp.getWriter().println("alert('Tài khoản mật khẩu không chính xác');");
			resp.getWriter().println("location.replace('/assignment/login');");
			resp.getWriter().println("</script>");
		} else {
			session.setAttribute("username", acc.getUsername());
			session.setAttribute("role", acc.getRole());
			resp.getWriter().println("<script type=\"text/javascript\">");
			resp.getWriter().println("alert('Đăng nhập thành công');");
			resp.getWriter().println("location.replace('/assignment/may-giat');");
			resp.getWriter().println("</script>");
		}
	}
}
