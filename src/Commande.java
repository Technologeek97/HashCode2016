package hash_code_2016;

import java.util.ArrayList;
import java.util.List;

public class Commande 
{
	int x;
	int y;
	List<Integer> liste_type_produit;
	
	public Commande(int x,int y) 
	{
		this.x=x;
		this.y=y;
		this.liste_type_produit=new ArrayList<Integer>();
	}
	
	void ajout(int type_produit)
	{
		liste_type_produit.add(type_produit);
	}
	
	void ajout(List<Integer> liste_type_produit)
	{
		this.liste_type_produit.addAll(liste_type_produit);
	}
	
	void retire(int type_produit)
	{
		liste_type_produit.remove(type_produit);
	}
	
	boolean est_finie()
	{
		return this.liste_type_produit.size()==0;
	}
}
