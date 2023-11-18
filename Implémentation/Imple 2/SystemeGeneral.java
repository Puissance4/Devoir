import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class SystemeGeneral extends Systeme {
	private Carte[] _cartes;
	private ArrayList<Integer> IDs = new ArrayList<Integer>();

	public boolean verifierCarte(Date aExpDate, int aNumero, int aPin) {
		throw new UnsupportedOperationException();
	}

	public boolean verifierCommande(Commande aCom) {
		throw new UnsupportedOperationException();
	}

	public String creerID() {
		int id = (int) (Math.random() * 1000000000);
		while (IDs.contains(id)) {
			id = (int) (Math.random() * 1000000000);
		}
		IDs.add(id);
		return Integer.toString(id);
	}
		
}