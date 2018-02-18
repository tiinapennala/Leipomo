package bean;

public class Tuote {
	private int tuotenro;
	private String nimi, tyyppi, kuvaus;
	private double hinta;
	private boolean lopetettu;
	public Tuote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tuote(int tuotenro, String nimi, String tyyppi, String kuvaus, double hinta, boolean lopetettu) {
		super();
		this.tuotenro = tuotenro;
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.kuvaus = kuvaus;
		this.hinta = hinta;
		this.lopetettu = lopetettu;
	}
	public int getTuotenro() {
		return tuotenro;
	}
	public void setTuotenro(int tuotenro) {
		this.tuotenro = tuotenro;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getTyyppi() {
		return tyyppi;
	}
	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}
	public String getKuvaus() {
		return kuvaus;
	}
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public boolean isLopetettu() {
		return lopetettu;
	}
	public void setLopetettu(boolean lopetettu) {
		this.lopetettu = lopetettu;
	}
	@Override
	public String toString() {
		return "Tuote [tuotenro=" + tuotenro + ", nimi=" + nimi + ", tyyppi=" + tyyppi + ", kuvaus=" + kuvaus
				+ ", hinta=" + hinta + ", lopetettu=" + lopetettu + "]";
	}
	
	
	
}
