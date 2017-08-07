package com.icinfo.tax.biz.controller;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.model.DmCzry;
import com.icinfo.tax.biz.model.TaRiskDetail;
import com.icinfo.tax.biz.model.TaRiskMonth;
import com.icinfo.tax.biz.service.IDmCzryService;
import com.icinfo.tax.biz.service.ITaRiskDetailService;
import com.icinfo.tax.biz.service.ITaRiskMonthService;
import com.icinfo.tax.biz.service.ITaRiskService;
import com.icinfo.tax.biz.util.FileUtil;
import com.icinfo.tax.biz.util.FxUtil;
/**
 * 风险信息
 * 
 * @author zhuyong
 */
@Controller
@RequestMapping("/risk")
public class TaRiskController extends BaseController {
	
	@Autowired
	private ITaRiskService taRiskService;
	
	@Autowired
	private ITaRiskDetailService taRiskDetailService;
	
	@Resource(name="taRiskMonthServiceImpl")
	private ITaRiskMonthService TaRiskMonthService;
	
	@Autowired
	private IDmCzryService dmCzryService;
	
	/**
     * 进入事前风险查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/doEnRiskSearchBefore")
    public String doEnRiskSearchBefore(HttpServletRequest req) throws Exception {
    	Map<String,Object> map = new HashMap<String,Object>();
//    	List<TaRiskMonth> list = TaRiskMonthService.findTaRiskMonthList(map);
//    	req.setAttribute("data", list);
        return "biz/risk_search_before";
    }

    /**
     * 系统数据JSON数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public PageResponse<TaRiskDto> listJSON(PageRequest request) throws Exception {
        List<TaRiskDto> data = taRiskService.queryPage(request);
        if("CURRENT".equals(request.getParams().get("riskType"))&& data.size()>0){
        	data =taRiskService.doBuildCurrentList(data);
        }
        return new PageResponse<TaRiskDto>(data);
    }
    
    /**
     * 进入事中风险查询
     * @author zjj
     * 20170424
     */
    @RequestMapping("/doEnRiskSearchAfter")
    public String doEnRiskSearchAfter(HttpServletRequest req) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<TaRiskMonth> list = TaRiskMonthService.findTaRiskMonthList(map);
    	req.setAttribute("data", list);
    	return "biz/risk_search_after";
    }
    
	/**
	 * 查看核查结果
	 * @author ylr
	 * @throws Exception 
	 * @date20170424
	 */
	@RequestMapping("/showQueryDetail")
	public ModelAndView showQueryDetail(String fxId) throws Exception{
		ModelAndView mv = new ModelAndView("biz/query_detail");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fxId", fxId);
		List<TaRiskDetail> list = taRiskDetailService.findByFxId(map);
		mv.addObject("data", list);
		return mv;
	}
    
    /**
     * 获取处理情况查询信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/queryprocesslist.json", "queryprocesslist.xml"})
    @ResponseBody
    public PageResponse<TaRiskDto> doGetQueryProcessList(PageRequest request) throws Exception {
        List<TaRiskDto> data = taRiskService.doGetQueryProcessList(request);
        return new PageResponse<TaRiskDto>(data);
    }
    /**
     * 查看具体风险点
     * @author fanzhen
     * @throws Exception 
     * @date20170424
     */
    @RequestMapping("/showRiskDetail")
    public String showRiskDetail(String fxId,HttpServletRequest req) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("fxId", fxId);
    	List<TaRiskDetail> list = taRiskDetailService.findByFxId(map);
    	req.setAttribute("data", list);
    	return "biz/risk_detail";
    }
    
    
    /**
     * 进入事前预警待处理页面
     * @author ylr
     * 20170425
     */
    @RequestMapping("/doEnWarnProcessAdvance")
    public ModelAndView doEnWarnProcess(@RequestParam String userID) throws Exception{
    	ModelAndView mv = new ModelAndView("biz/warn_process_advance");
    	DmCzry dmCzry = dmCzryService.doSelectUserInfo(userID);
    	// TODO... 根据userid获取用户相关信息
    	mv.addObject("uid",dmCzry.getCzrydm());
    	mv.addObject("name",dmCzry.getCzrymc());
    	mv.addObject("examManagerDepart",dmCzry.getSwjgdm());
    	mv.addObject("riskType","ADVANCE");
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<TaRiskMonth> list = TaRiskMonthService.findTaRiskMonthList(map);
    	mv.addObject("data", list);
    	return mv;
    }
    
    /**
     * 进入预警处理页面
     * @author ylr
     * 20170426
     */
    @RequestMapping("/doEnWarnProcessDetail")
    public ModelAndView doEnWarnProcessDetail(String fxId,String uid,String name,String examManagerDepart) throws Exception{
    	ModelAndView mv = new ModelAndView("biz/warn_process_detail");
//    	Map<String,Object> map = new HashMap<String,Object>();
    	mv.addObject("uid",uid);
    	mv.addObject("name",name);
    	mv.addObject("examManagerDepart",examManagerDepart);
    	mv.addObject("fxId",fxId);
//    	map.put("fxId", fxId);
//    	List<TaRiskDetail> list = taRiskDetailService.findByFxId(map);
//    	mv.addObject("data", list);
    	return mv;
    }
    
    /**
     * 进入事前预警处理页面
     * @author ylr
     * 20170426
     */
    @RequestMapping("/doEnWarnProcessAdvanceDetail")
    public ModelAndView doEnWarnProcessAdvanceDetail(String fxId,String uid,String name,String examManagerDepart) throws Exception{
    	ModelAndView mv = new ModelAndView("biz/warn_process_advance_detail");
    	Map<String,Object> map = new HashMap<String,Object>();
    	mv.addObject("uid",uid);
    	mv.addObject("name",name);
    	mv.addObject("examManagerDepart",examManagerDepart);
    	mv.addObject("fxId",fxId);
    	map.put("fxId", fxId);
    	List<TaRiskDetail> list = taRiskDetailService.findByFxId(map);
    	mv.addObject("data", list);
    	return mv;
    }
    /**
     * 进入事前预警处理页面
     * @author ylr
     * 20170426
     */
    @RequestMapping("/doEnWarnProcessCurrentDetail")
    public ModelAndView doEnWarnProcessCurrentDetail(String fxId,String uid,String name,String examManagerDepart) throws Exception{
    	ModelAndView mv = new ModelAndView("biz/warn_process_current_detail");
    	Map<String,Object> map = new HashMap<String,Object>();
    	mv.addObject("uid",uid);
    	mv.addObject("name",name);
    	mv.addObject("examManagerDepart",examManagerDepart);
    	mv.addObject("fxId",fxId);
    	map.put("fxId", fxId);
    	List<TaRiskDetail> list = taRiskDetailService.findByFxId(map);
    	mv.addObject("data", list);
    	return mv;
    }
    
    
    /**
     * 预警处理
     * @author ylr
     * 20170426
     */
    @RequestMapping("/doUpdateWarnProcessDetail")
    @ResponseBody
    public AjaxResult doUpdateWarnProcessDetail(HttpServletRequest req) throws Exception{
    	String riskResult = req.getParameter("riskResult");
    	String fxId = req.getParameter("fxId");
    	String examManagerDepart = req.getParameter("examManagerDepart");
    	String uid = req.getParameter("uid");
    	String name = req.getParameter("name");
    	String ids = req.getParameter("ids");
    	String taxAmount = req.getParameter("taxAmount");
    	String results = req.getParameter("results");
    	String[] id_s = ids.split(",");
    	String[] result_s = results.split(",");
    	
    	Date date = new Date();
    	Map<String, Object> qryMap = new HashMap<String, Object>();
    	for(int i=0;i<id_s.length;i++){
    		qryMap.put("id", id_s[i]);
    		qryMap.put("examResult", result_s[i]);
    		qryMap.put("examDate", date);
        	taRiskDetailService.updateTaRiskDetail(qryMap);
        	qryMap.clear();
    	}
    	
    	qryMap.put("fxId", fxId);
    	qryMap.put("examPeopleId", uid);
    	qryMap.put("examPeople", name);
    	qryMap.put("examManagerDepart", examManagerDepart);
    	qryMap.put("examDate", date);
    	qryMap.put("riskResult", riskResult);
    	qryMap.put("taxAmount", taxAmount);
    	taRiskService.updateTaRisk(qryMap);
    	
    	return AjaxResult.success("成功");
    }
    
    
    
    
    /**
     * 获取预警待处理
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/warnprocesslist.json", "warnprocesslist.xml"})
    @ResponseBody
    public PageResponse<TaRiskDto> doGetWarnProcessList(PageRequest request) throws Exception {
        List<TaRiskDto> data = taRiskService.doGetWarnProcessList(request);
        return new PageResponse<TaRiskDto>(data);
    }
    
    /**
     * 生成Excel文件并下载
     * fanzhen
     * 20170425
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/download")    
    public ResponseEntity<byte[]> download(TaRiskDto riskDto,HttpServletRequest req,HttpServletResponse response) throws Exception {    
    	riskDto.setRiskName(FxUtil.transRiskName(riskDto.getRiskName()));
    	Map<String,Object> map = FxUtil.toMap(riskDto);
    	List<TaRiskDto> list = taRiskService.selectTaRiskListByDto(map);
    	long time = new Date().getTime();
	    response.reset();   
	    response.setContentType("application/msexcel ");    
	    response.setHeader("Content-Disposition", "filename=" + java.net.URLEncoder.encode(time+".xls", "UTF-8"));   
	    OutputStream out = response.getOutputStream();  
	    FileUtil.exportExcel("生成Excel",  list, out, riskDto.getRiskType());
	    out.close();  
    	return null; 
    }
    
    /**
     * 显示历史核查记录详情
     * @author fanzhen
     * @date20170426
     * @param fxId
     * @return
     * @throws Exception 
     */
    @RequestMapping("/showHistoryDetail")
    public String showHistoryDetail(String fxId,String riskMonth,HttpServletRequest seq) throws Exception{
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("fxId", fxId);
    	map.put("riskMonth", riskMonth);
    	List<TaRiskDetail> list = taRiskDetailService.findByFxId(map);
    	seq.setAttribute("data", list);
    	return "biz/query_detail";
    }
    /**
     * 进入事前处理情况查询
     * @author fz
     * 20170515
     */
    @RequestMapping("/doEnQueryAdvanceProcess")
    public ModelAndView doEnQueryAdvanceProcess() throws Exception{
    	ModelAndView mv = new ModelAndView("biz/query_process_advance");
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<TaRiskMonth> list = TaRiskMonthService.findTaRiskMonthList(map);
    	mv.addObject("data", list);
    	return mv;
    }
    /**
     * 进入事中处理情况查询
     * @author fz
     * 20170515
     */
    @RequestMapping("/doEnQueryCurrentProcess")
    public ModelAndView doEnQueryCurrentProcess() throws Exception{
    	ModelAndView mv = new ModelAndView("biz/query_process_current");
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<TaRiskMonth> list = TaRiskMonthService.findTaRiskMonthList(map);
    	mv.addObject("data", list);
    	return mv;
    }
    
    /**
     * 进入事中预警待处理页面
     * @author fanzhen
     * 20170515
     */
    @RequestMapping("/doEnWarnProcessCurrent")
    public ModelAndView doEnWarnProcessCurrent(@RequestParam String userID) throws Exception{
    	ModelAndView mv = new ModelAndView("biz/warn_process_current");
    	DmCzry dmCzry = dmCzryService.doSelectUserInfo(userID);
    	// TODO... 根据userid获取用户相关信息
    	mv.addObject("uid",dmCzry.getCzrydm());
    	mv.addObject("name",dmCzry.getCzrymc());
    	mv.addObject("examManagerDepart",dmCzry.getSwjgdm());
    	mv.addObject("riskType","CURRENT");
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<TaRiskMonth> list = TaRiskMonthService.findTaRiskMonthList(map);
    	mv.addObject("data", list);
    	return mv;
    }
    
    
}















