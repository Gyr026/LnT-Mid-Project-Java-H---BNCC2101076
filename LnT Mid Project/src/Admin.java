
public class Admin extends Karyawan{

	private double bonusAdmin = 0;

	public double getBonusAdmin() {
		return bonusAdmin;
	}

	public void setBonusAdmin(double bonusAdmin) {
		this.bonusAdmin = bonusAdmin;
	}

	public Admin(String kode, String nama, String gender, String jabatan, int gaji, double bonusAdmin) {
		super(kode, nama, gender, jabatan, gaji);
		this.bonusAdmin = bonusAdmin;
	}

}
