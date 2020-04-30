package br.com.anbima.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.com.anbima.models.SelicModel;

/**
 * Class Service Data SELIC
 * 
 * @author oscaroaj
 *
 */
public class SelicService {

	/**
	 * API Service
	 */
	private ApiService apiService = new ApiService();

	/**
	 * Method Get data SELIC returned from the API by Year and Month
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public List<SelicModel> getEstimateByMonth(int year, int month) {
		String url = "estimate/month?year=" + year;

		if (month != 0) {
			url = url.concat("&month=" + month);
		}

		return this.getJsonParseListByUrl(url);
	}

	/**
	 * Method Get all data data SELIC returned from API
	 * 
	 * @return
	 */
	public List<SelicModel> getEstimate() {
		return this.getJsonParseListByUrl("estimate");
	}

	/**
	 * Method Get data SELIC returned from the API by URL
	 * 
	 * @param url
	 * @return
	 */
	public List<SelicModel> getJsonParseListByUrl(String url) {
		List<SelicModel> selicList = new ArrayList<SelicModel>();
		SimpleDateFormat dateFormatInput = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormatOutput = new SimpleDateFormat("dd/MM/yyyy");

		List<Map<String, Object>> response = apiService.getJsonFromUrl(url);

		response.forEach(obj -> {
			Date dateObject;
			String date = null;
			try {
				dateObject = dateFormatInput.parse(obj.get("date").toString());
				date = dateFormatOutput.format(dateObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			float tax = Float.parseFloat(obj.get("taxa").toString());

			SelicModel selicData = new SelicModel(date, tax);
			selicList.add(selicData);
		});

		return selicList;
	}
}
