import java.util.Date;

public class Carte {
	private String expDate;
	private String numero;
	private String pin;
	public String acheteur;

	public Carte(String date, String numero,String pin,String acheteur){
		this.acheteur=acheteur;
		this.expDate=date;
		this.numero=numero;
		this.pin=pin;
	} 
	public String getExpDate() {
		return this.expDate;
	}

	public String getNumero() {
		return this.numero;
	}

	public String getPin() {
		return this.pin;
	}
	public String getAcheteur() {
		return this.acheteur;
	}
}