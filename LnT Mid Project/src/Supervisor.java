
public class Supervisor extends Karyawan{

	public double getBonusSupervisor() {
		return bonusSupervisor;
	}

	public void setBonusSupervisor(double bonusSupervisor) {
		this.bonusSupervisor = bonusSupervisor;
	}

	public Supervisor(String kode, String nama, String gender, String jabatan, int gaji, double bonusSupervisor) {
		super(kode, nama, gender, jabatan, gaji);
		this.bonusSupervisor = bonusSupervisor;
	}

	private double bonusSupervisor = 0;

}
