package br.com.anbima;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.anbima.models.AverageModel;
import br.com.anbima.services.AverageService;

/**
 * Class Bean Average Page
 * 
 * @author oscaroaj
 *
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "average")
@SessionScoped
public class AverageBean {

	private static List<AverageModel> averageData = new ArrayList<AverageModel>();

	public List<AverageModel> getAverageData() {
		return averageData;
	}

	/**
	 * Method Set Data Average
	 * 
	 * @param averageData
	 */
	public void setAverageData(List<AverageModel> averageData) {
		AverageBean.averageData = averageData;
	}

	/**
	 * Method Set Data Average
	 */
	public void setAverage() {
		AverageService averageService = new AverageService();

		List<AverageModel> averageList = averageService.getAverage();

		setAverageData(averageList);
	}
}
