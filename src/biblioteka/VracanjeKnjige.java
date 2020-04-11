package biblioteka;

public class VracanjeKnjige {

	private int brojRacuna;
	private int brojKnjige;
	private java.util.Date date;

	public VracanjeKnjige() {
	}

	public VracanjeKnjige(int brojRacuna, int brojKnjige) {

		this.brojRacuna = brojRacuna;
		this.brojKnjige = brojKnjige;

		if (postojiLiRacun() == true) {

			if (postojiLiKnjiga() == true && jeLiKnjigaDostupna() == false) {

				vratiKnjigu().setStatusKnjige(true);
				vratiRacun().setBrojPosudjenihKnjigaSmanji();
				System.out.println(vratiRacun().getBrojPosudjenihKnjiga());
				System.out.println(vratiKnjigu().getStatusKnjige());

			}

			else
				System.out.println("Knjiga ne postoji ili nije dostupna");
		}

		else
			System.out.println("Vas racun nije pronaden");

	}

	public boolean postojiLiRacun() {

		for (int i = 0; i < Racun.pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return true;
			}
		}

		return false;
	}

	public boolean postojiLiKnjiga() {

		for (int i = 0; i < Knjiga.pohranjeneKnjige.size(); i++) {
			if (Knjiga.pohranjeneKnjige.get(i).getBrojKnjige() == brojKnjige) {
				return true;
			}
		}

		return false;
	}

	public boolean jeLiKnjigaDostupna() {

		for (int i = 0; i < Knjiga.pohranjeneKnjige.size(); i++) {
			if (Knjiga.pohranjeneKnjige.get(i).getBrojKnjige() == brojKnjige) {
				if (Knjiga.pohranjeneKnjige.get(i).getStatusKnjige() == true) {
					return true;
				}
			}
		}

		return false;
	}

	public Knjiga vratiKnjigu() {

		for (int i = 0; i < Knjiga.pohranjeneKnjige.size(); i++) {
			if (Knjiga.pohranjeneKnjige.get(i).getBrojKnjige() == brojKnjige) {
				return Knjiga.pohranjeneKnjige.get(i);
			}
		}

		Knjiga knjiga2 = new Knjiga();
		return knjiga2;

	}

	public Racun vratiRacun() {

		for (int i = 0; i < Racun.pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return Racun.pohranjeniRacuni.get(i);
			}
		}

		Racun racun = new Racun();
		return racun;

	}

}
