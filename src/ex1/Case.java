package ex1;

import java.util.Random;

public class Case {
	private boolean hasL;
	private Legume leg;
	private boolean arrose;
	private boolean laboure;
	Random r = new Random();
	
	
	public Case() {
		hasL = false;
		arrose = false;
		laboure = true;
	}
	
	public Case(Legume leg) {
		hasL = true;
		this.leg = leg;
		arrose = true;
		laboure = true;
	}
	
	public Legume getLegume() {
		return leg;
	}
	
	public void setLegume(Legume a) {
		leg = a;
	}
	
	public boolean getArr() {
		return arrose;
	}
	
	public boolean getLab() {
		return laboure;
	}
	
	public void setArr(boolean arr) {
		arrose = arr;
	}
	
	public void setLab(boolean lab) {
		laboure = lab;
	}
	
	public boolean hasLegume() {
		return hasL;
	}
	
	public void evol(Meteo m) {
		if(hasL) {
			leg.pousse(m);
		}
		else {
			if(laboure && !arrose) {
				if(r.nextDouble()<0.0005){
					setLab(false);
				}
			}
			if(arrose) {
				if(r.nextDouble()<0.0005){
					setArr(false);
				}
			}
		}
		
	}
}
