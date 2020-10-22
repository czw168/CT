package cn.ubot.service.production.impl;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridFootResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.production.JoMapper_;
import cn.ubot.mapper.generator.JoMapper;
import cn.ubot.pojo.diy.production.Jo_;
import cn.ubot.pojo.generator.Jo;
import cn.ubot.service.production.JOService;
import cn.ubot.utils.DateUtils;
import cn.ubot.utils.ExceptionUtils;

@Service
public class JOServiceImpl implements JOService {
	@Autowired
	private JoMapper_ JoMapper_;
	@Autowired
	private JoMapper joMapper;

	public EUDataGridResult listJO(Integer page, Integer rows, String joNo) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<Jo_> joList = this.JoMapper_.listJo(joNo);
		result.setRows(joList);
		PageInfo<Jo_> pageInfo = new PageInfo<Jo_>(joList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult getMaxJoNo() {
		String joNo = null;
		Integer year = Integer.valueOf(DateUtils.getYear(new java.util.Date()));
		String maxJoNo = this.JoMapper_.getMaxJoNo();
		if (null == maxJoNo) {
			joNo = "V01JC" + year + "-00001";
		} else {
			CharSequence y = year + "";
			if (maxJoNo.contains(y)) {
				String substringNum = maxJoNo.substring(10);
				Integer num = Integer.valueOf(Integer.parseInt(substringNum) + 1);
				NumberFormat nf = new DecimalFormat("00000");
				String formatNum = nf.format(num);
				joNo = "V01JC" + year + "-" + formatNum;
			} else {
				joNo = "V01JC" + year + "-00001";
			}
		}
		return AjaxResult.ok(joNo);
	}

	public AjaxResult newJO(List<Jo> listJo) {
		try {
			for (int i = 0; i < listJo.size(); i++) {
				Jo jo = (Jo) listJo.get(i);
				Date currentDate = new Date(System.currentTimeMillis());
				jo.setCreateTime(currentDate);
				jo.setItem(Integer.valueOf(i + 1));
				this.joMapper.insertSelective(jo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public EUDataGridFootResult listDetailsJO(Integer page, Integer rows, String joNo) {
		EUDataGridFootResult result = new EUDataGridFootResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<Jo_> joDetailsList = this.JoMapper_.listDetailsJo(joNo);
		result.setRows(joDetailsList);
		PageInfo<Jo_> pageInfo = new PageInfo<Jo_>(joDetailsList);
		result.setTotal(pageInfo.getTotal());
		List<Map<String, Object>> footer = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uom", "Total:");
		map.put("orderQuantity", ((Jo_) joDetailsList.get(0)).getTotal());
		footer.add(map);
		result.setFooter(footer);
		return result;
	}

	public AjaxResult addJO(Jo jo) {
		try {
			Integer maxItem = this.JoMapper_.getMaxItem(jo.getUbotJo());
			if (null != maxItem) {
				jo.setItem(Integer.valueOf(maxItem.intValue() + 1));
			} else {
				jo.setItem(Integer.valueOf(1));
			}
			jo.setCreateTime(new Date(System.currentTimeMillis()));
			this.joMapper.insertSelective(jo);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateJO(Jo jo) {
		try {
			Date currentDate = new Date(System.currentTimeMillis());
			jo.setUpdateTime(currentDate);
			this.joMapper.updateByPrimaryKeySelective(jo);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}
}
