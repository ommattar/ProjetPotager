package ex1;

public class Legume {

	private boolean mure;
	private int tmpM;
	private int tmp;
	private int type;
	private String nom;
	
	public Legume(int type) {
		tmp = 0;
		mure = false;
		this.type = type;
		switch(type) {
		case 0: nom = "salade";
		case 1: nom = "carotte";
		case 2: nom = "tomate";
		}
		tmpM = 100;
		
	}
	
	public int getSize() {
		double size;
		size = (tmp/tmpM)*100;
		return (int) size;
	}
	
	public int getType() {
		return type;
	}
	
	public boolean getMure() {
		return mure;
	}
	
	public void setMure(boolean m) {
		mure = m;
	}
	
	public int getTmp() {
		return tmp;
	}
	
	public int getTmpM() {
		return tmpM;
	}
	
	public void setTmp(int t) {
		tmp = t;
	}
	
	public void pousse(Meteo met) {
		estMure();
		if(type==0) setTmp(tmp+1+met.fact());
		if(type==1) setTmp(tmp+3+met.fact());
		if(type==2) setTmp(tmp+2+met.fact());
		
		
	}
	
	public void estMure() {
		if(!mure) {
			if(tmpM<tmp) {
				mure = true;
			}
		}
		
	}
	
	
}
