package ex1;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Meteo met = new Meteo();
		Modele m = new Modele(8, met);
		Vue v = new Vue(m);
		m.addObserver(v);
		new Thread(m).start();
	}

}
