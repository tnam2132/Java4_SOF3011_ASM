package model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class MayGiat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ma;

	@Column(length = 50, nullable = true)
	private String ten;

	@Column(length = 50, nullable = true)
	private String loaiMayGiat;

	@Column(nullable = true)
	private double congSuat;

	@Column(length = 250, nullable = true)
	private String moTa;

	@Column(nullable = true)
	private BigDecimal gia;

	@Column(nullable = true)
	private int soLuong;

	@Column(length = 50, nullable = true)
	private String nguoiTao;

	@Column(nullable = true)
	private Date thoiDiemTao;

	@Column(length = 50, nullable = true)
	private String nguoiThayDoiCuoi;

	@Column(nullable = true)
	private Date thoiDiemThayDoiCuoi;

	@Column
	private boolean daXoa;

	public MayGiat() {

	}

	public MayGiat(int ma, String ten, String loaiMayGiat, double congSuat, String moTa, BigDecimal gia, int soLuong,
			String nguoiTao, Date thoiDiemTao, String nguoiThayDoiCuoi, Date thoiDiemThayDoiCuoi, boolean daXoa) {
		this.ma = ma;
		this.ten = ten;
		this.loaiMayGiat = loaiMayGiat;
		this.congSuat = congSuat;
		this.moTa = moTa;
		this.gia = gia;
		this.soLuong = soLuong;
		this.nguoiTao = nguoiTao;
		this.thoiDiemTao = thoiDiemTao;
		this.nguoiThayDoiCuoi = nguoiThayDoiCuoi;
		this.thoiDiemThayDoiCuoi = thoiDiemThayDoiCuoi;
		this.daXoa = daXoa;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLoaiMayGiat() {
		return loaiMayGiat;
	}

	public void setLoaiMayGiat(String loaiMayGiat) {
		this.loaiMayGiat = loaiMayGiat;
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) {
		this.congSuat = congSuat;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public Date getThoiDiemTao() {
		return thoiDiemTao;
	}

	public void setThoiDiemTao(Date thoiDiemTao) {
		this.thoiDiemTao = thoiDiemTao;
	}

	public String getNguoiThayDoiCuoi() {
		return nguoiThayDoiCuoi;
	}

	public void setNguoiThayDoiCuoi(String nguoiThayDoiCuoi) {
		this.nguoiThayDoiCuoi = nguoiThayDoiCuoi;
	}

	public Date getThoiDiemThayDoiCuoi() {
		return thoiDiemThayDoiCuoi;
	}

	public void setThoiDiemThayDoiCuoi(Date thoiDiemThayDoiCuoi) {
		this.thoiDiemThayDoiCuoi = thoiDiemThayDoiCuoi;
	}

	public boolean isDaXoa() {
		return daXoa;
	}

	public void setDaXoa(boolean daXoa) {
		this.daXoa = daXoa;
	}

	@Override
	public String toString() {
		return "MayGiat [ma=" + ma + ", ten=" + ten + ", loaiMayGiat=" + loaiMayGiat + ", congSuat=" + congSuat
				+ ", moTa=" + moTa + ", gia=" + gia + ", soLuong=" + soLuong + ", nguoiTao=" + nguoiTao
				+ ", thoiDiemTao=" + thoiDiemTao + ", nguoiThayDoiCuoi=" + nguoiThayDoiCuoi + ", thoiDiemThayDoiCuoi="
				+ thoiDiemThayDoiCuoi + ", daXoa=" + daXoa + "]";
	}
	
}
