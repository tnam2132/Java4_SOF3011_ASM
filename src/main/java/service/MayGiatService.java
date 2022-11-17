package service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import model.MayGiat;
import repository.AccountRepository;
import repository.MayGiatRepository;

public class MayGiatService {
	private final MayGiatRepository MayGiatRepo = new MayGiatRepository();

	public List<MayGiat> getAll() {
		List<MayGiat> listMayGiat = MayGiatRepo.getAll();
		return listMayGiat;
	}

	public List<MayGiat> getAllUser() {
		List<MayGiat> listMayGiat = MayGiatRepo.getAllUser();
		return listMayGiat;
	}

	public void insert(MayGiat mg) {
		MayGiatRepo.insert(mg);
	}

	public void update(MayGiat mg) {
		MayGiatRepo.update(mg);
	}

	public void delete(String ma) {
		Integer ma2 = Integer.parseInt(ma);
		MayGiat mg = new MayGiat();
		mg.setMa(ma2);
		MayGiatRepo.delete(mg);
		;
	}

	public MayGiat selectById(Integer ma) {
		MayGiat MayGiat = MayGiatRepo.selectById(ma);
		return MayGiat;
	}

	public List<MayGiat> sapXep(String tenTimKiem, Boolean daxoa, BigDecimal giaTu, BigDecimal giaDen, String soLuong) {
		List<MayGiat> listMayGiat = MayGiatRepo.getByFilter(tenTimKiem, daxoa, giaTu, giaDen, soLuong);
		return listMayGiat;
	}
}
