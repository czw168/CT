package cn.ubot.service.shipping.impl;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridFootResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.shipping.TpoMapper_;
import cn.ubot.mapper.generator.Tpo1Mapper;
import cn.ubot.mapper.generator.Tpo2Mapper;
import cn.ubot.pojo.diy.shipping.Tpo;
import cn.ubot.pojo.generator.Tpo1;
import cn.ubot.pojo.generator.Tpo1Example;
import cn.ubot.pojo.generator.Tpo2;
import cn.ubot.pojo.generator.Tpo2Example;
import cn.ubot.service.shipping.TpoService;
import cn.ubot.utils.DateUtils;
import cn.ubot.utils.ExceptionUtils;

@Service
public class TpoServiceImpl implements TpoService {
	@Autowired
	private TpoMapper_ tpoMapper_;
	@Autowired
	private Tpo1Mapper tpo1Mapper;
	@Autowired
	private Tpo2Mapper tpo2Mapper;

	public AjaxResult getMaxTpo() {
		String tpo = null;

		Integer year = Integer.valueOf(DateUtils.getYear(new java.util.Date()));
		String maxTpo = this.tpoMapper_.getMaxTpo();
		if (StringUtils.isEmpty(maxTpo)) {

			tpo = "TPC" + year + "-00001";
		} else {

			CharSequence y = year + "";
			if (maxTpo.contains(y)) {

				String substringNum = maxTpo.substring(8);
				Integer num = Integer.valueOf(Integer.parseInt(substringNum) + 1);
				NumberFormat nf = new DecimalFormat("00000");
				String formatNum = nf.format(num);
				tpo = "TPC" + year + "-" + formatNum;
			} else {

				tpo = "TPC" + year + "-00001";
			}
		}
		return AjaxResult.ok(tpo);
	}

	public AjaxResult newTpo1(Tpo1 tpo1) {
		AjaxResult tpoResult = getMaxTpo();
		tpo1.setTpo((String) tpoResult.getData());
		tpo1.setCreateTime(new Date(System.currentTimeMillis()));
		Integer maxId = this.tpoMapper_.getMaxId();

		try {
			if (null == maxId) {
				maxId = Integer.valueOf(1);
			} else {
				maxId = Integer.valueOf(maxId.intValue() + 1);
			}
			this.tpo1Mapper.insertSelective(tpo1);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok(maxId);
	}

	public AjaxResult updateTpo1(Tpo1 tpo1) {
		try {
			this.tpo1Mapper.updateByPrimaryKeySelective(tpo1);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateTpo2(Tpo2 tpo2) {
		try {
			this.tpo2Mapper.updateByPrimaryKeySelective(tpo2);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public EUDataGridResult listTpo(Integer page, Integer rows, String tpo) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<Tpo> tpoList = this.tpoMapper_.getTpoList(tpo);
		result.setRows(tpoList);

		PageInfo<Tpo> pageInfo = new PageInfo<Tpo>(tpoList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public EUDataGridFootResult listTpo2(Integer page, Integer rows, Integer id) {
		EUDataGridFootResult result = new EUDataGridFootResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		Tpo2Example example = new Tpo2Example();
		Tpo2Example.Criteria criteria = example.createCriteria();
		criteria.andTidEqualTo(id);
		List<Tpo2> tpo2List = this.tpo2Mapper.selectByExample(example);
		result.setRows(tpo2List);

		PageInfo<Tpo2> pageInfo = new PageInfo<Tpo2>(tpo2List);
		result.setTotal(pageInfo.getTotal());

		List<Map<String, Object>> footer = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uom", "Total:");
		map.put("qty", this.tpoMapper_.getTpoTotalById(id));
		footer.add(map);
		result.setFooter(footer);

		return result;
	}

	public EUDataGridResult listNotToChooseTpo2(Integer page, Integer rows, Integer id) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		Tpo2Example example = new Tpo2Example();
		Tpo2Example.Criteria criteria = example.createCriteria();
		criteria.andTidEqualTo(id);
		criteria.andStatusEqualTo(Integer.valueOf(0));
		List<Tpo2> tpo2List = this.tpo2Mapper.selectByExample(example);
		result.setRows(tpo2List);

		PageInfo<Tpo2> pageInfo = new PageInfo<Tpo2>(tpo2List);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addTpo(Tpo2 tpo2, String createBy) {
		Integer tid = tpo2.getTid();

		try {
			Integer maxItem = this.tpoMapper_.getMaxItem(tid);
			if (null == maxItem) {
				tpo2.setItem(Integer.valueOf(1));
			} else {
				tpo2.setItem(Integer.valueOf(maxItem.intValue() + 1));
			}
			tpo2.setStatus(Integer.valueOf(0));
			this.tpo2Mapper.insertSelective(tpo2);

			Tpo1 tpo1 = new Tpo1();
			tpo1.setId(tid);
			tpo1.setUpdateTime(new Date(System.currentTimeMillis()));
			tpo1.setUpdateBy(createBy);
			this.tpo1Mapper.updateByPrimaryKeySelective(tpo1);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateTpo(List<Tpo2> tpo2s, Tpo1 tpo1_1, Tpo1 tpo1_2) {
		try {
			if (tpo2s.size() != 0) {
				for (Tpo2 tpo2 : tpo2s) {
					this.tpo2Mapper.updateByPrimaryKeySelective(tpo2);
				}
			}
			Tpo1 tpo1 = new Tpo1();
			tpo1.setId(tpo1_1.getId());
			tpo1.setUpdateBy(tpo1_1.getUpdateBy());
			tpo1.setCustomer(tpo1_1.getCustomer());
			tpo1.setBillTo(tpo1_1.getBillTo());
			tpo1.setShipTo(tpo1_1.getShipTo());
			tpo1.setCustomerPo(tpo1_1.getCustomerPo());
			tpo1.setCreateDate(tpo1_1.getCreateDate());

			tpo1.setRemark(tpo1_2.getRemark());
			tpo1.setShipmode(tpo1_2.getShipmode());
			tpo1.setTerms(tpo1_2.getTerms());
			tpo1.setRequiredShipdate(tpo1_2.getRequiredShipdate());

			tpo1.setUpdateTime(new Date(System.currentTimeMillis()));
			this.tpo1Mapper.updateByPrimaryKeySelective(tpo1);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult getIdByTpo(String tpo) {
		Tpo1Example example = new Tpo1Example();
		Tpo1Example.Criteria criteria = example.createCriteria();
		criteria.andTpoEqualTo(tpo);
		List<Tpo1> Tpo1List = this.tpo1Mapper.selectByExample(example);
		return AjaxResult.ok(((Tpo1) Tpo1List.get(0)).getId());
	}
}
