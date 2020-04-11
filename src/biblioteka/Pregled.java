package biblioteka;

public class Pregled {

	private int brojRacuna;
	
	public Pregled() {
	}

	public Pregled(int brojRacuna) {
	this.brojRacuna = brojRacuna;
	System.out.println("Korisnik " + vratiRacun().getImeMusterije() + " je podigao slijedece knjige : ");
	for (int i = 0; i < vratiRacun().pohranjeniKnjigeNaRacunu.size(); i++) {
	
		
		System.out.println(vratiRacun().pohranjeniKnjigeNaRacunu.get(i).getImeKnjige() + ", datum: "
	    + vratiRacun().pohranjeniKnjigeNaRacunu.get(i).getDatum());
	
		
	}
	
	
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
