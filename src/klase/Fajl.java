package klase;

import java.util.LinkedList;
import java.util.zip.Checksum;

public class Fajl {
	
	private String naziv;
	private long velicina; //u bajtovima
	private LinkedList<Segment> listaSegmenata;
	String checksum;
	public int brojSeedera; 
	
	
	
	public Fajl(String naziv, long velicina, LinkedList<Segment> listaSegmenata, String checksum) {
		super();
		this.naziv = naziv;
		this.velicina = velicina;
		this.listaSegmenata = listaSegmenata;
		this.checksum = checksum;
		this.brojSeedera = 1;
	}



	public String getNaziv() {
		return naziv;
	}



	public String getChecksum() {
		return checksum;
	}



	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public long getVelicina() {
		return velicina;
	}



	public void setVelicina(long velicina) {
		this.velicina = velicina;
	}



	public LinkedList<Segment> getListaSegmenata() {
		return listaSegmenata;
	}



	public void setListaSegmenata(LinkedList<Segment> listaSegmenata) {
		this.listaSegmenata = listaSegmenata;
	}
	
	
	
}
