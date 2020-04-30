package br.com.anbima;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.anbima.models.SelicModel;
import br.com.anbima.services.SelicService;


@SuppressWarnings("deprecation")
@ManagedBean(name="selic")
@SessionScoped
public class SelicBean {
	
	private static int year = 0;
	private static int month = 0;

	private static List<SelicModel> selicData = new ArrayList<SelicModel>();

	public List<SelicModel> getSelicData() {
		return selicData;
	}
	
	public void setYear(int year) {
		SelicBean.year = year;
	}

	public void setMonth(int month) {
		SelicBean.month = month;
	}
	
	public static void setSelicData(List<SelicModel> selicData) {
		SelicBean.selicData = selicData;
	}
	
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
	
	public void getEstimateByMonth() {
		SelicService selicService = new SelicService();
		
		List<SelicModel> selicList = null;
				
		if (year == 0) {
			setMonth(0);
		}
		
		
		if (year != 0) {
			selicList = selicService.getEstimateByMonth(year, month);		
		} else if(year == 0 && month == 0) {
			selicList = selicService.getEstimate();
		} 
		
		setSelicData(selicList);
	}
}
