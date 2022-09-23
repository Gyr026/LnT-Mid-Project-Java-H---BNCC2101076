
public class Manager extends Karyawan{

	private double bonusManager = 0;

	public Manager(String kode, String nama, String gender, String jabatan, int gaji, double bonusManager) {
		super(kode, nama, gender, jabatan, gaji);
		this.bonusManager = bonusManager;
	}

	public double getBonusManager() {
		return bonusManager;
	}

	public void setBonusManager(double bonusManager) {
		this.bonusManager = bonusManager;
	}

}
