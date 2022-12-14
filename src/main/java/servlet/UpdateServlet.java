package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.query.Query;

import model.MayGiat;
import service.MayGiatService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/may-giat/update")
public class UpdateServlet extends HttpServlet {
	MayGiatService maygiatService = new MayGiatService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		String nguoiThayDoiCuoi = (String) session.getAttribute("username");
		Integer ma = Integer.parseInt(req.getParameter("ma"));
		MayGiat mg = maygiatService.selectById(ma);
		mg.setNguoiThayDoiCuoi(nguoiThayDoiCuoi);
		req.setAttribute("mg", mg);
		req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		Integer ma = Integer.parseInt(req.getParameter("ma"));
		String ten = req.getParameter("ten");
		String loaiMayGiat = req.getParameter("loaiMayGiat");
		String congSuat = req.getParameter("congSuat");
		Double congSuat2 = 1.0;
		String moTa = req.getParameter("moTa");
		String gia = req.getParameter("gia");
		BigDecimal gia2 = null;
		String soLuong = req.getParameter("soLuong");
		Integer soLuong2 = 1;
		String nguoiTao = req.getParameter("nguoiTao");
		Date thoiDiemThayDoiCuoi = new Date();
		String nguoiThayDoiCuoi = req.getParameter("nguoiThayDoiCuoi");
		String trangThai = req.getParameter("daXoa");
		Boolean daXoa = Boolean.valueOf(trangThai);
		MayGiat mg = maygiatService.selectById(ma);

		try {
			congSuat2 = Double.parseDouble(congSuat);
		} catch (Exception e) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "C??ng su???t ph???i l?? s???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		}
		try {
			gia2 = BigDecimal.valueOf(Double.parseDouble(gia));
		} catch (Exception e) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "Gi?? ph???i l?? s???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		}
		try {
			soLuong2 = Integer.parseInt(soLuong);
		} catch (Exception e) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "S??? l?????ng ph???i l?? s???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		}

		if (ten == null || loaiMayGiat == null || congSuat == null || moTa == null || gia == null || soLuong == null) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "Vui l??ng nh???p ?????y ????? c??c tr?????ng");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
			return;
		}
		if (ten.trim().isEmpty() || loaiMayGiat.trim().isEmpty() || req.getParameter("congSuat").trim().isEmpty()
				|| moTa.trim().isEmpty() || req.getParameter("gia").trim().isEmpty()
				|| req.getParameter("soLuong").trim().isEmpty()) { // check rong
			req.setAttribute("mg", mg);
			req.setAttribute("message", "Vui l??ng nh???p ?????y ????? c??c tr?????ng");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
			return;
		}
		if (ten.length() > 50) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "T??n ph???i d?????i 50 k?? t???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (loaiMayGiat.length() > 50) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "Lo???i m??y gi???t ph???i d?????i 50 k?? t???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (moTa.length() > 250) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "M?? t??? ph???i d?????i 250 k?? t???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (!congSuat.matches(".{0,16}")) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "C??ng su???t ph???i t??? 0-16 k?? t???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (congSuat2 < 0) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "C??ng su???t ph???i l???n h??n 0");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (!gia.matches(".{0,16}")) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "Gi?? ph???i t??? 0-16 k?? t???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (Double.parseDouble(gia) < 0) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "Gi?? ph???i l???n h??n 0");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (!soLuong.matches(".{0,10}")) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "S??? l?????ng ph???i t??? 0-10 k?? t???");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else if (soLuong2 < 0) {
			req.setAttribute("mg", mg);
			req.setAttribute("message", "S??? l?????ng ph???i l???n h??n 0");
			req.getRequestDispatcher("/WEB-INF/view/updateMayGiat.jsp").forward(req, resp);
		} else {
			mg.setTen(ten);
			mg.setLoaiMayGiat(loaiMayGiat);
			mg.setCongSuat(congSuat2);
			mg.setMoTa(moTa);
			mg.setGia(gia2);
			mg.setSoLuong(soLuong2);
			mg.setNguoiTao(nguoiTao);
			mg.setThoiDiemThayDoiCuoi(thoiDiemThayDoiCuoi);
			mg.setNguoiThayDoiCuoi(nguoiThayDoiCuoi);
			mg.setDaXoa(daXoa);
			maygiatService.update(mg);
			resp.getWriter().println("<script type=\"text/javascript\">");
			resp.getWriter().println("alert('C???p nh???p th??nh c??ng');");
			resp.getWriter().println("location.replace('/assignment/may-giat');");
			resp.getWriter().println("</script>");
		}
	}
}
