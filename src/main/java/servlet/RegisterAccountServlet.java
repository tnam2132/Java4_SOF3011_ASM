package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountRole;
import service.AccountService;
import service.AuthenticationService;

@WebServlet("/register")
public class RegisterAccountServlet extends HttpServlet {
	private final AccountService accountService = new AccountService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String hoten = req.getParameter("hoten");
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("confirmpassword");
		AccountRole role = AccountRole.USER;
		if (username == null || hoten == null || password == null) {
			req.setAttribute("message", "Vui lòng nhập đầy đủ các trường");
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
			return;
		}
		if (username.trim().isEmpty() || hoten.trim().isEmpty() || password.trim().isEmpty()) { // check rong
			req.setAttribute("message", "Vui lòng nhập đầy đủ các trường");
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("username", username);
		if (accountService.getByUserName(username) != null) { //Check trùng
			req.setAttribute("message", "Tên tài khoản đã tồn tại");
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
		} else if (!password.matches(".{8,16}")) { 
			req.setAttribute("message", "Mật khẩu phải từ 8-16 ký tự");
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
		} else if (!password.matches("[^A-Z]+")) {
			req.setAttribute("message", "Mật khẩu không chứa ký tự viết hoa");
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
		} else if (password.matches("[a-z0-9]+")) { 
			req.setAttribute("message", "Mật khẩu phải chứa ký tự đặc biệt");
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
		}else if (!confirmpassword.equalsIgnoreCase(password)) {
			req.setAttribute("message", "Xác nhận mật khẩu không chính xác");
			req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
		}
		else {
			accountService.addAccount(username, hoten, password, role);
			resp.getWriter().println("<script type=\"text/javascript\">");
			resp.getWriter().println("alert('Đăng ký thành công');");
			resp.getWriter().println("location.replace('/assignment/login');");
			resp.getWriter().println("</script>");
		}

	}
}
