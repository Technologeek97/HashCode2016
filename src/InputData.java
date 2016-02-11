package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputData {
	
	public ArrayList<Integer> Data = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		InputData inputData = new InputData();
		
		File inputFile = new File(args[0]);
		System.out.println("File loaded");

		
		try {
			BufferedReader buff = new BufferedReader(new FileReader(inputFile));
			
			try {
				String line;
				while ((line = buff.readLine()) != null) {
					System.out.println(line);
					String[] bruteDataTab = line.split(" ");
					for (String s : bruteDataTab) {
						inputData.Data.add(Integer.parseInt(s));
					}
					
				}
			} finally {
				buff.close();
			}
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		System.out.println("Don't forget to call a function");
		
	}	
	
	public int getTotalRow() {
		System.out.println("Total Row is :"+ Data.get(0));
		return Data.get(0);
	}
	
	public int getTotalColumn() {
		System.out.println("Total Column : "+ Data.get(1));
		return Data.get(1);
	}
	
	public int getNumberDrones() {
		System.out.println("Drones nbr : "+ Data.get(2));
		return Data.get(2);
	}
	
	/**
	 * @return number of turns till deadline
	 */
	public int getDeadLine() {
		System.out.println("Deadline is : "+Data.get(3));
		return Data.get(3);
	}
	
	/**
	 * @param int actualTurn
	 * @return number of turn left
	 */
	public int getWhenIsDeadLine(int actualTurn) {
		System.out.println("Deadline is in : "+(getDeadLine()-actualTurn)+" turn");
		return getDeadLine()-actualTurn;
	}
	
	/**
	 * 
	 * @return Retourne charge max d'un drone
	 */
	public int getMaxLoad() {
		System.out.println("Max Load by Drone is : "+Data.get(4));
		return Data.get(4);
	}
	
	/**
	 * 
	 * @return Nombre de types de produits
	 */
	public int getNumberTypeProducts() {
		System.out.println("There are : "+Data.get(5)+" products");
		return Data.get(5);
	}
	
	/**
	 * 
	 * @return ArrayList<Integer> contenant les poids de tous les produits
	 */
	public ArrayList<Integer> getWeightAllTypeProducts() {
		ArrayList<Integer> weights = new ArrayList<Integer>();
		for (int i=1; i<=getNumberTypeProducts(); i++) {
			weights.add(Data.get(5+i));
		}
		System.out.println("Weight of all products are : "+weights.toString());
		return weights;
	}
	
	/**
	 * 
	 * @param idProduct
	 * @return Retourne le poids du produit : idProduct
	 */
	public int getWeightOfProduct(int idProduct) {
		int nbrProd = getNumberTypeProducts(); 
		if (idProduct>nbrProd || idProduct<nbrProd) {
			System.out.println("Erreur : produit non contenu dans la liste");
			return -1;
		}
		System.out.println("The weight of the id["+idProduct+"] is "
				+Data.get(getWeightAllTypeProducts().get(idProduct)));
		return Data.get(getWeightAllTypeProducts().get(idProduct));
	}
	
	/**
	 * 
	 * @return Retourne le nombre de Warehouse
	 */
	public int getNumberWarehouse() {
		System.out.println("There are : "
				+Data.get(6+getNumberTypeProducts())+" warehouses");
		return Data.get(5+getNumberTypeProducts());
	}
	
	/**
	 * 
	 * @return ArrayList<Integer[]> Retourne les coordonnées de toutes les Warehouses, 2 par 2
	 */
	public ArrayList<Integer[]> getCoordAllWarehouses() {
		ArrayList<Integer[]> coordWarehouse = new ArrayList<Integer[]>();
		for(int i=5+getNumberTypeProducts()+2; i<(5+getNumberTypeProducts()+2)+((2+getNumberTypeProducts())*getNumberWarehouse()); i+=2+getNumberTypeProducts()) {
			coordWarehouse.add(new Integer[]{Data.get(i), Data.get(i+1)});
		}
		System.out.println("Coord of all warehouses : "+coordWarehouse.toString());
		return coordWarehouse;
	}
	
	/**
	 * 
	 * @param idWarehouse
	 * @return La pair de coordonnée de la Warehouse spécifiée
	 */
	public Integer[] getCoordOfWarehouse(int idWarehouse) {
		System.out.println("La warehouse d'id : "+idWarehouse+" se trouve aux coordonnées : "+getCoordAllWarehouses().get(idWarehouse));
		return getCoordAllWarehouses().get(idWarehouse);
	}
	
	/**
	 * 
	 * @param idWarehouse
	 * @return ArrayList<Integer> de Tous les produits d'une Warehouse
	 */
	public ArrayList<Integer> getAllProductsOfAWarehouse(int idWarehouse) {
		ArrayList<Integer> products = new ArrayList<Integer>();
		for (int i=7+getNumberTypeProducts()+((2+getNumberTypeProducts())*idWarehouse); 
				i<(7+getNumberTypeProducts()+((2+getNumberTypeProducts())*idWarehouse))+getNumberTypeProducts(); i++){
			products.add(2+Data.get(i));
		}
		System.out.println("La warehouse d'id : "+idWarehouse+" a en stock : "+products.toString());
		return products;
	}
	
	/**
	 * 
	 * @param idProduct
	 * @param idWarehouse
	 * @return Le stock d'un produit spécifique d'une warehouse spécifique
	 */
	public int getStockOfProductsOfTypeFromWarehouse(int idProduct, int idWarehouse) {
		System.out.println("Le produit d'id : "+idProduct+" de la warehouse : "
				+idWarehouse+" est présent en : "+getAllProductsOfAWarehouse(idWarehouse)
				.get(idProduct)+" exemplaires");
		return getAllProductsOfAWarehouse(idWarehouse).get(idProduct);
	}

	
	
}
