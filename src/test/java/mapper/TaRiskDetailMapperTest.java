package mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.mapper.TaRiskDetailMapper;
import com.icinfo.tax.biz.mapper.TaRiskMapper;
import com.icinfo.tax.biz.model.TaRiskDetail;

public class TaRiskDetailMapperTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("entry/dev/spring-entry.xml");
	}
	
	@Test
	public void test1(){
		TaRiskDetailMapper mapper = ac.getBean("taRiskDetailMapper",TaRiskDetailMapper.class);
//		List<TaRiskDetail> list = mapper.findByFxId("1");
//		for(TaRiskDetail risk:list){
//			System.out.println(risk);
//		}
	}
	
	@Test
	public void test2(){
		TaRiskMapper mapper = ac.getBean("taRiskMapper",TaRiskMapper.class);
		Map<String,Integer> map = mapper.countRisk();
		Set<String> set = map.keySet();
		for(String s:set){
			System.out.println(s+","+map.get(s));
		}
	}
	
	@Test
	public void test3(){
		TaRiskMapper mapper = ac.getBean("taRiskMapper",TaRiskMapper.class);
		TaRiskDto dto = new TaRiskDto();
		dto.setRiskMonthLeft("201703");
		List<TaRiskDto> list = mapper.searchPeopleWorkCount(dto);
		for(TaRiskDto d:list){
			System.out.println(d);
		}
	}
	@Test
	public void test4(){
		TaRiskMapper mapper = ac.getBean("taRiskMapper",TaRiskMapper.class);
		TaRiskDto dto = new TaRiskDto();
		dto.setRiskMonthLeft("201703");
		dto.setRiskMonthRight("201704");
		Map<String,Object> map = mapper.searchResultCount(dto);
		Set<String> set = map.keySet();
		for(String s:set){
			System.out.println(s+map.get(s));
		}
	}
	
	@Test
	public void test5(){
		TaRiskDetailMapper mapper = ac.getBean("taRiskDetailMapper",TaRiskDetailMapper.class);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fxId", "31");
		map.put("riskMonth", "201703");
		List<TaRiskDetail> list = mapper.findByFxId(map);
		for(TaRiskDetail detail:list){
			System.out.println(detail);
		}
	}
}
