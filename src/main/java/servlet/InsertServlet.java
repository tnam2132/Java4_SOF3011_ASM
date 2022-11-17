package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.MayGiat;
import service.MayGiatService;
import utility.HibernateUtil;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	public final MayGiatService mayGiatService = new MayGiatService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/InsertMayGiat.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String ten = req.getParameter("ten");
		String loaiMayGiat = req.getParameter("loaiMayGiat");
		String congSuat = req.getParameter("congSuat");
		String moTa = req.getParameter("moTa");
		String gia = req.getParameter("gia");
		String soLuong = req.getParameter("soLuong");
		String nguoiTao = req.getParameter("nguoiTao");
		String nguoiThayDoiCuoi = req.getParameter("nguoiThayDoiCuoi");
		
		try {
			MayGiat mg = new MayGiat();
			mg.setTen(ten);
			mg.setLoaiMayGiat(loaiMayGiat);
			mg.setCongSuat(Integer.valueOf(congSuat));
			mg.setMoTa(moTa);
			mg.setGia(BigDecimal.valueOf(Double.parseDouble(gia)));
			mg.setSoLuong(Integer.valueOf(soLuong));
			mg.setThoiDiemTao(new Date());
			mg.setThoiDiemThayDoiCuoi(new Date());
			mg.setNguoiTao(nguoiTao);
			mg.setNguoiThayDoiCuoi(nguoiThayDoiCuoi);
			mg.setDaXoa(false);
			mayGiatService.insert(mg);
			req.setAttribute("mg", mg);
			req.getRequestDispatcher("/WEB-INF/view/Xuat.jsp").forward(req, resp);
		} catch (Exception e) {
			resp.getWriter().append("<h1>Thêm mới thất bại</h1>");
		}
	}
}
