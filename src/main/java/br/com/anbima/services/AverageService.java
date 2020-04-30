package br.com.anbima.services;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.anbima.models.AverageModel;

/**
 * Class Service Average data SELIC
 * 
 * @author oscaroaj
 *
 */
public class AverageService {

	/**
	 * API Service
	 */
	private final ApiService apiService = new ApiService();
	private static DecimalFormatSymbols symbols = new DecimalFormatSymbols(
			Locale.ENGLISH);
	private static DecimalFormat df = new DecimalFormat("#.##", symbols);

	/**
	 * Method Get all data data SELIC returned from API
	 * 
	 * 
	 * @return
	 */
	public List<AverageModel> getAverage() {
		return this.getJsonParseListByUrl("average");
	}

	/**
	 * Method Get data SELIC returned from the API by URL
	 * 
	 * @param url
	 * @return
	 */
	public List<AverageModel> getJsonParseListByUrl(String url) {
		List<AverageModel> averageList = new ArrayList<AverageModel>();

		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator('.');

		List<Map<String, Object>> response = apiService.getJsonFromUrl(url);

		response.forEach(obj -> {
			String year = obj.get("year").toString();
			double averageD = Double.parseDouble(obj.get("average").toString());

			float average = Float.parseFloat(df.format(averageD));

			AverageModel selicData = new AverageModel(year, average);
			averageList.add(selicData);
		});

		return averageList;
	}
}
