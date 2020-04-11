package biblioteka;

import java.sql.Date;
import java.util.ArrayList;

public class PodizanjeKnjige {

	private int brojRacuna;
	private int brojKnjige;
	private java.util.Date date;
	private String date2;

	public PodizanjeKnjige() {
	}

	public PodizanjeKnjige(int brojRacuna, int brojKnjige) {

		java.util.Date date = new java.util.Date();

		this.brojRacuna = brojRacuna;
		this.brojKnjige = brojKnjige;
		this.date2 = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();

		if (postojiLiRacun() == true) {

			if (postojiLiKnjiga() == true && jeLiKnjigaDostupna() == true) {

				if (vratiRacun().getBrojPosudjenihKnjiga() > 2) {
					System.out.println("Vec imate 3 posudjene knjige");
				}

				else {
					vratiKnjigu().setStatusKnjige(false);
					vratiRacun().setBrojPosudjenihKnjigaPovecaj();
					vratiRacun().pohranjeniKnjigeNaRacunu.add(vratiKnjigu());
					vratiRacun().pohranjeniKnjigeNaRacunu.get(vratiRacun().pohranjeniKnjigeNaRacunu.size() - 1)
							.setDatum(this.date2);
					System.out.println(vratiRacun().getBrojPosudjenihKnjiga());
					System.out.println(vratiKnjigu().getStatusKnjige());
				}
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
