package ex1;

import java.util.Random;

public class Meteo {
	int jour;
	int mois;
	int annee;
	int saison;
	int temp;
	int ensol;
	int humid;
	Random r = new Random();
	int prixTom = 8;
	int prixSal = 10;
	int prixCar = 9;
	
	public Meteo() {
		jour = 1;
		mois = 1;
		annee = 2023;
		saison = 1;
		temp = 20;
		ensol = 50;
		humid = 50;
	}
	
	public void increment() {
		jour++;
		if(jour==32) {
			jour=1;
			mois++;
			modifPrix();
		}
		if(mois==13) {
			mois=1;
			annee++;
			
		}
		if(mois==12) saison = 1;
		if(mois ==3) saison = 2;
		if(mois ==6) saison = 3;
		if(mois ==9) saison = 4;
	}
	
	public String getDate() {
		String str ="";
		str += jour + "/" + mois +"/" + annee;
		return str;
	}
	
	public String getTemp() {
		String str ="";
		str += "Temperature : " + temp + "°C\n";
		return str;
	}
	
	public String getEnsol() {
		String str ="";
		str += "Ensoleilement : " + ensol + "%\n";
		return str;
	}
	
	public String getHumid() {
		String str ="";
		str += "Humidite : " + humid + "%\n";
		return str;
	}
	
	
	public void temps() {
		int delta;
		if(r.nextDouble()<0.5)
	        delta=-1;
	    else
	        delta=1;
		
		if(saison== 1) temp = Math.min(15, temp+delta);
		if(saison == 2) temp = Math.max(Math.min(25, temp+delta),15);
		if(saison == 3) temp = Math.max(20, temp+delta);
		if(saison == 4) temp = Math.max(Math.min(20, temp+delta),10);
		
		if(r.nextDouble()<0.5)
	        ensol = Math.max(50,ensol-5);
	    else
	    	ensol = Math.min(100,ensol+5);
		
		if(r.nextDouble()<0.5)
	        humid = Math.max(40,humid-5);
	    else
	    	humid = Math.min(100,humid+5);
		
		
		
		
	}
	
	public void modifPrix() {
		
		if(r.nextDouble()<0.5)
	        prixSal = Math.max(8,prixSal-1);
	    else
	    	prixSal = Math.min(12,prixSal+1);
		
		if(r.nextDouble()<0.5)
	        prixCar = Math.max(7,prixCar-1);
	    else
	    	prixCar = Math.min(11,prixCar+1);
		
		if(r.nextDouble()<0.5)
	        prixTom = Math.max(6,prixTom-1);
	    else
	    	prixTom = Math.min(10,prixTom+1);
	}
	
	public int getPrix(int type) {
		int prix = 10;
		if(type==0) prix = prixSal;
		if(type==1) prix = prixCar;
		if(type==2) prix = prixTom;
		return prix;
	}
	
	public int fact() {
		int fact = 0;
		if(ensol>90) fact++;
		if(humid<80 && humid >60) fact++;
		if(temp>15 && temp<30) fact++;
		return fact;
	}

}
