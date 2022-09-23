import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<Karyawan> karyawan = new Vector<Karyawan>();

	public Main() {
		String menu = "";

		do {
			System.out.println("Program Pengolah Data Karyawan");
			System.out.println("==============================");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			System.out.print(">> ");
			menu = scan.nextLine();

			switch (menu) {
			case "1":
				insertData();
				break;
			case "2":
				viewData();
				break;
			case "3":
				updateData();
				break;
			case "4":
				deleteData();
				break;
			case "5":
				System.out.println("Menutup program..");
				break;
			default:
				System.out.println("Input tidak valid!");
				System.out.println("ENTER to return");
				scan.nextLine();
				break;
			}
		} while (!menu.equals("5"));
	}

	private void deleteData() {
		if (karyawan.isEmpty()) {
			System.out.println("No data!");
			System.out.println("ENTER to return");
			scan.nextLine();
		} else {
			dataList();
			int pilih = 0;

			do {
				System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
				try {
					pilih = scan.nextInt();
				} catch (Exception e) {
					pilih = 0;
				}
				scan.nextLine();
			} while (pilih < 1 || pilih > karyawan.size());

			System.out.printf("Karyawan dengan kode %s berhasil dihapus", karyawan.get(pilih-1).getKode());
			karyawan.remove(pilih - 1);
			System.out.println();
			System.out.println("ENTER to return");
			scan.nextLine();
		}
	}

	private void updateData() {
		if (karyawan.isEmpty()) {
			System.out.println("No data!");
			System.out.println("ENTER to return");
			scan.nextLine();
		} else {
			dataList();

			int pilih = 0;

			do {
				System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
				try {
					pilih = scan.nextInt();
				} catch (Exception e) {
					pilih = 0;
				}
				scan.nextLine();
			} while (pilih < 1 || pilih > karyawan.size());

			String kodeLama = karyawan.get(pilih-1).getKode();
			if (pilih != 0 && karyawan.get(pilih - 1) != null) {
				String kodeBaru = "";
				do {					
					System.out.print("Apakah anda mau mengupdate kode karyawan ini? [Y/N] (Case Sensitive): ");
					kodeBaru = scan.nextLine();
					if (kodeBaru.equals("Y")) {						
						char randomChar = (char) ('A' + rand.nextInt(26));
						char randomChar2 = (char) ('A' + rand.nextInt(26));
						int randomNumber = 0 + rand.nextInt(9);
						int randomNumber2 = 0 + rand.nextInt(9);
						int randomNumber3 = 0 + rand.nextInt(9);
						int randomNumber4 = 0 + rand.nextInt(9);
						
						String kode = String.valueOf(randomChar) + String.valueOf(randomChar2) + "-" + String.valueOf(randomNumber)
						+ String.valueOf(randomNumber2) + String.valueOf(randomNumber3) + String.valueOf(randomNumber4);
						karyawan.get(pilih-1).setKode(kode);
					} else if (kodeBaru.equals("N")) {
						break;
					}
				} while (!(kodeBaru.equals("Y") || kodeBaru.equals("N")));
				
				String nama = "";
				int hitung = 0;

				do {
					System.out.print("Input nama karyawan [>= 3]: ");
					nama = scan.nextLine();

					for (int i = 0; i < nama.length(); i++) {
						if (Character.isAlphabetic(nama.charAt(i))) {
							hitung += 1;
						}
					}

					if (hitung < 3) {
						hitung = 0;
					}
					
					if (nama.equals("0")) {
						break;
					} else {						
						karyawan.get(pilih-1).setNama(nama);
					}

				} while (hitung < 3);
				
				String gender = "";

				do {
					System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
					gender = scan.nextLine();
					
					if (gender.equals("0")) {
						break;
					} else {
						karyawan.get(pilih-1).setGender(gender);						
					}
				} while (!(gender.equals("Laki-Laki") || gender.equals("Perempuan")));
				
				String jabatan = "";

				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					jabatan = scan.nextLine();
					
					if (jabatan.equals("0")) {
						break;
					} else {
						karyawan.get(pilih-1).setJabatan(jabatan);						
					}
				} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
				
				int gaji = 0;
				
				if (jabatan.equals("Manager") || jabatan.equals("0")) {
					String pilihan = "";
					do {						
						System.out.print("Apakah anda mau mengubah gaji karyawan ini? [Y/N] (Case Sensitive): ");
						pilihan = scan.nextLine();
						if (pilihan.equals("Y")) {
							System.out.print("Input gaji karyawan yang baru: ");
							gaji = scan.nextInt();
							scan.nextLine();
							karyawan.get(pilih-1).setGaji(gaji);
						}
					} while (!(pilihan.equals("Y") || pilihan.equals("N")));
				} else if (jabatan.equals("Supervisor") || jabatan.equals("0")) {
					String pilihan = "";
					do {						
						System.out.print("Apakah anda mau mengubah gaji karyawan ini? [Y/N] (Case Sensitive): ");
						pilihan = scan.nextLine();
						if (pilihan.equals("Y")) {
							System.out.print("Input gaji karyawan yang baru: ");
							gaji = scan.nextInt();
							scan.nextLine();
							karyawan.get(pilih-1).setGaji(gaji);
						}
					} while (!(pilihan.equals("Y") || pilihan.equals("N")));
				} else if (jabatan.equals("Admin") || jabatan.equals("0")) {
					String pilihan = "";
					do {						
						System.out.print("Apakah anda mau mengubah gaji karyawan ini? [Y/N] (Case Sensitive): ");
						pilihan = scan.nextLine();
						if (pilihan.equals("Y")) {
							System.out.print("Input gaji karyawan yang baru: ");
							gaji = scan.nextInt();
							scan.nextLine();
							karyawan.get(pilih-1).setGaji(gaji);
						}
					} while (!(pilihan.equals("Y") || pilihan.equals("N")));
				}
			}
			System.out.println("Berhasil mengupdate karyawan dengan id "+kodeLama);
			System.out.println("ENTER to return");
			scan.nextLine();
		}
	}

	private void viewData() {
		if (karyawan.isEmpty()) {
			System.out.println("No data!");
			System.out.println("ENTER to return");
			scan.nextLine();
		} else {
			dataList();
			System.out.println("ENTER to return");
			scan.nextLine();
		}
	}

	private void dataList() {
		Collections.sort(karyawan, new Comparator<Karyawan>() {

			@Override
			public int compare(Karyawan o1, Karyawan o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getNama().compareTo(o2.getNama()));
			}
		});

		Collections.sort(karyawan, (o1, o2) -> (o1.getNama().compareTo(o2.getNama())));

		int i = 0;
		System.out.println("=====================================================================================");
		System.out.printf("| %-2s | %-10s | %-15s | %-10s | %-10s | %-10s |", "No", "Kode Karyawan", "Nama Karyawan",
				"Jenis Kelamin", "Jabatan", "Gaji Karyawan");
		System.out.println();
		System.out.println("=====================================================================================");
		for (Karyawan karyawan2 : karyawan) {
			System.out.printf("| %-2d | %-13s | %-15s | %-13s | %-10s | %-13d |", (i + 1), karyawan2.getKode(),
					karyawan2.getNama(), karyawan2.getGender(), karyawan2.getJabatan(), karyawan2.getGaji());
			System.out.println();
			i++;
		}
		System.out.println("=====================================================================================");
	}

	private void insertData() {
		char randomChar = (char) ('A' + rand.nextInt(26));
		char randomChar2 = (char) ('A' + rand.nextInt(26));
		int randomNumber = 0 + rand.nextInt(9);
		int randomNumber2 = 0 + rand.nextInt(9);
		int randomNumber3 = 0 + rand.nextInt(9);
		int randomNumber4 = 0 + rand.nextInt(9);

		String kode = String.valueOf(randomChar) + String.valueOf(randomChar2) + "-" + String.valueOf(randomNumber)
				+ String.valueOf(randomNumber2) + String.valueOf(randomNumber3) + String.valueOf(randomNumber4);

		String nama = "";
		int hitung = 0;

		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();

			for (int i = 0; i < nama.length(); i++) {
				if (Character.isAlphabetic(nama.charAt(i))) {
					hitung += 1;
				}
			}

			if (hitung < 3) {
				hitung = 0;
			}

		} while (hitung < 3);

		String gender = "";

		do {
			System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		} while (!(gender.equals("Laki-Laki") || gender.equals("Perempuan")));

		String jabatan = "";

		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));

		int gaji = 0;

		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			karyawan.add(new Manager(kode, nama, gender, jabatan, gaji, 0.1));
		} else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			karyawan.add(new Supervisor(kode, nama, gender, jabatan, gaji, 0.075));
		} else if (jabatan.equals("Admin")) {
			gaji = 4000000;
			karyawan.add(new Admin(kode, nama, gender, jabatan, gaji, 0.05));
		}
		
		double tempBonus = 0;
		for (Karyawan karyawan2 : karyawan) {
			if (karyawan2 instanceof Manager) {
				Manager mg = (Manager) karyawan2;
				tempBonus = mg.getBonusManager();
			} else if (karyawan2 instanceof Supervisor) {
				Supervisor sv = (Supervisor) karyawan2;
				tempBonus = sv.getBonusSupervisor();
			} else if (karyawan2 instanceof Admin) {
				Admin ad = (Admin) karyawan2;
				tempBonus = ad.getBonusAdmin();
			}
		}
		
		System.out.println("Berhasil menambahkan karyawan dengan id "+kode);
		int counterM = 0, counterS = 0, counterA = 0;
		
		for (int i = 0; i < karyawan.size(); i++) {
			if (karyawan.get(i).getJabatan().compareTo("Manager") == 0) {
				counterM++;
			} else if (karyawan.get(i).getJabatan().compareTo("Supervisor") == 0) {
				counterS++;
			} else if (karyawan.get(i).getJabatan().compareTo("Admin") == 0) {
				counterA++;
			}
		}
		
		int entityCount = 0;
		
		if (counterM % 3 == 0 && counterM != 0 && jabatan.compareTo("Manager") == 0) {
			for (int i = 0; i < karyawan.size(); i++) {
				if (karyawan.get(i).getJabatan().compareTo("Manager") == 0) {
					int tempGaji = karyawan.get(i).getGaji();
					int bonus = (int) (tempGaji*tempBonus);
					int totalGaji = tempGaji+bonus;
					karyawan.get(i).setGaji(totalGaji);
					if (entityCount == 0) {
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id "+karyawan.get(i).getKode());
						entityCount = 1;
					} else {
						System.out.print(", "+karyawan.get(i).getKode());
					}
				}
			}
			System.out.println();
		} else if (counterS % 3 == 0 && counterS != 0 && jabatan.compareTo("Supervisor") == 0) {
			for (int i = 0; i < karyawan.size(); i++) {
				if (karyawan.get(i).getJabatan().compareTo("Supervisor") == 0) {
					int tempGaji = karyawan.get(i).getGaji();
					int bonus = (int) (tempGaji*tempBonus);
					int totalGaji = tempGaji+bonus;
					karyawan.get(i).setGaji(totalGaji);
					if (entityCount == 0) {
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id "+karyawan.get(i).getKode());
						entityCount = 1;
					} else {
						System.out.print(", "+karyawan.get(i).getKode());
					}
				}
			}
			System.out.println();
		} else if (counterA % 3 == 0 && counterA != 0 && jabatan.compareTo("Admin") == 0) {
			for (int i = 0; i < karyawan.size(); i++) {
				if (karyawan.get(i).getJabatan().compareTo("Admin") == 0) {
					int tempGaji = karyawan.get(i).getGaji();
					int bonus = (int) (tempGaji*tempBonus);
					int totalGaji = tempGaji+bonus;
					karyawan.get(i).setGaji(totalGaji);
					if (entityCount == 0) {
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id "+karyawan.get(i).getKode());
						entityCount = 1;
					} else {
						System.out.print(", "+karyawan.get(i).getKode());
					}
				}
			}
			System.out.println();
		}
		System.out.println("ENTER to return");
		scan.nextLine();
	}

	public static void main(String[] args) {
		new Main();

	}

	class SortAscend implements Comparator<Karyawan> {

		@Override
		public int compare(Karyawan arg0, Karyawan arg1) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

}
