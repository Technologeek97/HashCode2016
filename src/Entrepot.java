import java.util.ArrayList;

public class Entrepot {
	int x;
	int y;

	public ArrayList<Integer> stock = new ArrayList<Integer>();

	public Entrepot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Entrepot(int x, int y, ArrayList<Integer> stock) {
		this.x = x;
		this.y = y;
		this.stock = stock;
	}

	public int contient(int prod) {
		if (stock.contains(prod)) {
			return 1;
		}
		return -1;
	}

	public int ajout(int prod) {
		this.stock.add(prod);

		return 1;
	}

	public int retrait(int prod) {
		if (stock.contains(prod)) {
			stock.remove((Integer) prod);
			return 1;
		}
		System.out.println("Article manquant !");
		return -1;
	}
}
