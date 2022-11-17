package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountRole;
import model.MayGiat;
import repository.MayGiatRepository;
import service.MayGiatService;

@WebServlet("/may-giat")
public class MayGiatServlet extends HttpServlet {

	private MayGiatService mayGiatService = new MayGiatService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String a = "a";
		if (req.getParameter("a") != null) {
			a = req.getParameter("a");
		}
		Integer ma = null;
		if (req.getParameter("ma") != null) {
			ma = Integer.parseInt(req.getParameter("ma"));
		}
		if (a.equals("dangxuat")) { // Đăng xuất
			HttpSession session = req.getSession();
			session.removeAttribute("username");
			session.removeAttribute("role");
			resp.getWriter().println("<script type=\"text/javascript\">");
			resp.getWriter().println("alert('Đăng xuất thành công');");
			resp.getWriter().println("location.replace('/assignment/login');");
			resp.getWriter().println("</script>");
		} else if (ma != null) { // tim theo mã
			MayGiat MayGiat = mayGiatService.selectById(ma);
			if (MayGiat == null) {
				resp.getWriter().println("<script type=\"text/javascript\">");
				resp.getWriter().println("alert('Mã sản phẩm không tồn tại');");
				resp.getWriter().println("location.replace('/assignment/may-giat');");
				resp.getWriter().println("</script>");
			} else {
				MayGiat[] dsmaygiat = new MayGiat[] { MayGiat };
				req.setAttribute("dsMayGiat", dsmaygiat);
				req.getRequestDispatcher("/WEB-INF/view/MayGiat.jsp").forward(req, resp);
			}
		} else { // Duyệt danh sách theo vai trò
			HttpSession session = req.getSession();
			List<MayGiat> mayGiats = null;
			if (session.getAttribute("role") == AccountRole.ADMIN) {
				mayGiats = mayGiatService.getAll();
			} else {
				mayGiats = mayGiatService.getAllUser();
			}
			req.setAttribute("dsMayGiat", mayGiats);
			req.getRequestDispatcher("/WEB-INF/view/MayGiat.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String timkiem = "";
		String giatu = null;
		BigDecimal giatu2 = null;
		String giaden = null;
		BigDecimal giaden2 = null;
		String soluong = null;
		String daxoa = null;
		Boolean daxoa2 = null;
		if (req.getParameter("timkiem") != null) {
			timkiem = req.getParameter("timkiem");
		}
		if (req.getParameter("daxoa") != null) {
			daxoa = req.getParameter("daxoa");
			if (daxoa.equals("false")) {
				daxoa2 = false;
			}
			if (daxoa.equals("true")) {
				daxoa2 = true;
			}
		}
		if (req.getParameter("giatu") != null && req.getParameter("giaden") != null) {
			giatu = req.getParameter("giatu");
			giaden = req.getParameter("giaden");
			try {
				giatu2 = BigDecimal.valueOf(Double.parseDouble(giatu));
				giaden2 = BigDecimal.valueOf(Double.parseDouble(giaden));
			} catch (Exception e) {
			}
		}
		if (req.getParameter("soluong") != null) {
			soluong = req.getParameter("soluong");
		}

		List<MayGiat> mayGiats = mayGiatService.sapXep(timkiem, daxoa2, giatu2, giaden2, soluong);
		req.setAttribute("dsMayGiat", mayGiats);
		req.getRequestDispatcher("/WEB-INF/view/MayGiat.jsp").forward(req, resp);
	}
}
