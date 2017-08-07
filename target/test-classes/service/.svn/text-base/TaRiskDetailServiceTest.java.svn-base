package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.model.TaRiskDetail;
import com.icinfo.tax.biz.service.ITaRiskDetailService;
import com.icinfo.tax.biz.service.ITaRiskService;
import com.icinfo.tax.biz.service.impl.TaRiskDetailServiceImpl;

public class TaRiskDetailServiceTest {

private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("entry/dev/spring-entry.xml");
	}
	
	@Test
	public void test1() throws Exception{
		ITaRiskDetailService service = ac.getBean("taRiskDetailService",TaRiskDetailServiceImpl.class);
//		List<TaRiskDetail> list = service.findByFxId("1");
//		for(TaRiskDetail risk:list){
//			System.out.println(risk);
//		}
	}
	@Test
	public void test2() throws Exception{
		ITaRiskService service = ac.getBean("taRiskService",ITaRiskService.class);
		TaRiskDto dto = new TaRiskDto();
		dto.setRiskMonthLeft("201704");
		List<TaRiskDto> list = service.searchPeopleWorkCount(dto);
		for(TaRiskDto d:list){
			System.out.println(d);
		}
	}
	
	@Test
	public void test3() throws Exception{
		ITaRiskService service = ac.getBean("taRiskService",ITaRiskService.class);
		TaRiskDto dto = new TaRiskDto();
		dto.setRiskMonthLeft("201704");
		Map<String,Object> map = service.searchResultCount(dto);
		Set<String> set = map.keySet();
		for(String s:set){
			System.out.println(s+","+map.get(s));
		}
	}
	
	@Test
	public void test4() throws Exception{
		ITaRiskDetailService service = ac.getBean("taRiskDetailService",TaRiskDetailServiceImpl.class);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fxId", "31");
		map.put("riskMonth", "201703");
		List<TaRiskDetail> list = service.findByFxId(map);
		for(TaRiskDetail detail:list){
			System.out.println(detail);
		}
	}
	
//	@Test
//	public void test5() throws Exception{
//		ITaRiskService service = ac.getBean("taRiskService",ITaRiskService.class);
//		TaRiskDto dto = new TaRiskDto();
//		dto.setRiskType("ADVANCE");
//		dto.setIndustry("");
//		dto.setExamStatus("3");
//		dto.setIdentityStatus("");
//		dto.setManagerDepart("");
//		dto.setRiskName("");
//		dto.setRiskMonth("");
//		List<TaRiskDto> list = service.selectTaRiskListByDto(dto);
//		for(TaRiskDto d:list){
//			System.out.println(d);
//		}
//	}
}
