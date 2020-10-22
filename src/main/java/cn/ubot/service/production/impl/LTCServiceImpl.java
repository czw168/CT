package cn.ubot.service.production.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.production.LtcMapper_;
import cn.ubot.mapper.generator.LtcMapper;
import cn.ubot.pojo.diy.production.Ltc_;
import cn.ubot.pojo.generator.Ltc;
import cn.ubot.service.production.LTCService;
import cn.ubot.utils.DateUtils;
import cn.ubot.utils.ExceptionUtils;

@Service
public class LTCServiceImpl implements LTCService {
	@Autowired
	private LtcMapper_ ltcMapper_;
	@Autowired
	private LtcMapper ltcMapper;

	public EUDataGridResult listLTC(Integer page, Integer rows, String ltc) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<Ltc_> ltcList = this.ltcMapper_.listLtc(ltc);
		result.setRows(ltcList);
		PageInfo<Ltc_> pageInfo = new PageInfo<Ltc_>(ltcList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult newLTC(Ltc ltc) {
		java.util.Date productionDate = ltc.getProductionDate();
		try {
			String yy = DateUtils.format(productionDate, "yy");
			String mm = null;
			int month = DateUtils.getMonth(productionDate);
			if (month == 10) {
				mm = "X";
			} else if (month == 11) {
				mm = "Y";
			} else if (month == 12) {
				mm = "Z";
			} else {
				mm = month + "";
			}
			String dd = DateUtils.format(productionDate, "dd");
			String ltcNo = ltc.getSourceBatchCode() + ltc.getLotType() + ltc.getProductType() + yy + mm + dd
					+ ltc.getLotSerics() + ltc.getSublotSerics();
			ltc.setLtc(ltcNo);
			ltc.setCreateTime(new Date(System.currentTimeMillis()));
			this.ltcMapper.insertSelective(ltc);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateLTC(Ltc ltc) {
		ltc.setUpdateTime(new Date(System.currentTimeMillis()));
		try {
			this.ltcMapper.updateByPrimaryKeySelective(ltc);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}
}
