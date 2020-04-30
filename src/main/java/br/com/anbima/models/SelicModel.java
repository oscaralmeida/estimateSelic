package br.com.anbima.models;

/**
 * Class Model Data SELIC
 * 
 * @author oscaroaj
 *
 */
public class SelicModel {
	public String date;
	public float taxa;

	public SelicModel(String date, float taxa) {
		this.date = date;
		this.taxa = taxa;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}
