package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icinfo.tax.biz.model.Industry;
import com.icinfo.tax.biz.model.TaRiskMonth;
import com.icinfo.tax.biz.service.IIndustryService;
import com.icinfo.tax.biz.service.ITaRiskMonthService;

public class TaRiskMonthServiceTest {
	
	private ApplicationContext ac;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("entry/dev/spring-entry.xml");
	}
	
	@Test
	public void test1() throws Exception{
		ITaRiskMonthService service = ac.getBean("taRiskMonthServiceImpl",ITaRiskMonthService.class);
		Map<String,Object> map = new HashMap<String,Object>();
		List<TaRiskMonth> list = service.findTaRiskMonthList(map);
		for(TaRiskMonth month:list){
			System.out.println(month);
		}
	}
	@Test
	public void test2() throws Exception{
		IIndustryService service = ac.getBean("industryService",IIndustryService.class);
		List<Industry> list = service.findAllIndustry();
		System.out.println(list.size());
		for(Industry i:list){
			System.out.println(i);
		}
	}
}
