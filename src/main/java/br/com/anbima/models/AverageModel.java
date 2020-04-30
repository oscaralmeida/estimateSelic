package br.com.anbima.models;

/**
 * Class Model Data Average SELIC
 * 
 * @author oscaroaj
 *
 */
public class AverageModel {
	float average = 0;
	String year = null;

	public AverageModel(String year, float average) {
		this.year = year;
		this.average = average;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
