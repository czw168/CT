package cn.ubot.service.shipping.impl;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.shipping.ShippingLabelMapper_;
import cn.ubot.mapper.generator.ShippingLabel1Mapper;
import cn.ubot.mapper.generator.ShippingLabel2Mapper;
import cn.ubot.mapper.generator.ShippingLotMapper;
import cn.ubot.mapper.generator.Tpo1Mapper;
import cn.ubot.mapper.generator.Tpo2Mapper;
import cn.ubot.pojo.diy.shipping.ShippingLabel;
import cn.ubot.pojo.generator.ShippingLabel1;
import cn.ubot.pojo.generator.ShippingLabel2;
import cn.ubot.pojo.generator.ShippingLabel2Example;
import cn.ubot.pojo.generator.ShippingLot;
import cn.ubot.pojo.generator.Tpo1;
import cn.ubot.pojo.generator.Tpo1Example;
import cn.ubot.pojo.generator.Tpo2;
import cn.ubot.pojo.generator.Tpo2Example;
import cn.ubot.service.shipping.ShippingLabelService;
import cn.ubot.utils.DateUtils;
import cn.ubot.utils.ExceptionUtils;

@Service
public class ShippingLabelServiceImpl implements ShippingLabelService {
	@Autowired
	private ShippingLabelMapper_ shippingLabelMapper_;
	@Autowired
	private ShippingLotMapper shippingLotMapper;
	@Autowired
	private ShippingLabel1Mapper shippingLabel1Mapper;
	@Autowired
	private ShippingLabel2Mapper shippingLabel2Mapper;
	@Autowired
	private Tpo1Mapper tpo1Mapper;
	@Autowired
	private Tpo2Mapper tpo2Mapper;

	public AjaxResult newShippingLabel(ShippingLabel1 shippingLabel1, List<ShippingLabel2> shippingLabel2List,
			String tpo, Integer tid) {
		try {
			String shipLot = null;
			java.util.Date shipDate = shippingLabel1.getShipDate();
			int year = DateUtils.getYear(shipDate);
			int m = DateUtils.getMonth(shipDate);
			String month = null;
			if (m <= 9) {
				month = "0" + m;
			} else {
				month = "" + m;
			}
			String maxSerialNumber = this.shippingLabelMapper_.getMaxSerialNumber(year + month + "");
			ShippingLot shippingLot = new ShippingLot();
			if (StringUtils.isEmpty(maxSerialNumber)) {
				shipLot = "C" + year + month + "001";
				shippingLot.setSerialNumber("001");
				shippingLot.setYearAndMonth(year + month + "");
			} else {
				Integer num = Integer.valueOf(Integer.parseInt(maxSerialNumber) + 1);
				NumberFormat nf = new DecimalFormat("000");
				String formatNum = nf.format(num);
				shipLot = "C" + year + month + formatNum;
				shippingLot.setSerialNumber(formatNum);
				shippingLot.setYearAndMonth(year + month + "");
			}
			this.shippingLotMapper.insert(shippingLot);
			Integer maxId = this.shippingLabelMapper_.getMaxId();
			Integer id = Integer.valueOf((maxId == null) ? 1 : (maxId.intValue() + 1));
			shippingLabel1.setId(id);
			shippingLabel1.setShipLot(shipLot);
			shippingLabel1.setCreateTime(new Date(System.currentTimeMillis()));
			this.shippingLabel1Mapper.insert(shippingLabel1);
			for (ShippingLabel2 shippingLabel2 : shippingLabel2List) {
				shippingLabel2.setSid(id);
				shippingLabel2.setTpo(tpo);
				this.shippingLabel2Mapper.insertSelective(shippingLabel2);
				Tpo2 tpo2 = new Tpo2();
				tpo2.setStatus(Integer.valueOf(1));
				Tpo2Example tpo2Example = new Tpo2Example();
				Tpo2Example.Criteria criteria = tpo2Example.createCriteria();
				criteria.andItemEqualTo(shippingLabel2.getItem());
				criteria.andTidEqualTo(tid);
				this.tpo2Mapper.updateByExampleSelective(tpo2, tpo2Example);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public EUDataGridResult listShippingLabel(Integer page, Integer rows, String shipLot) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<ShippingLabel> shippingLabelList = this.shippingLabelMapper_.getShippingLabelList(shipLot);
		result.setRows(shippingLabelList);
		PageInfo<ShippingLabel> pageInfo = new PageInfo<ShippingLabel>(shippingLabelList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public EUDataGridResult listShippingLabel2(Integer page, Integer rows, Integer id) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		ShippingLabel2Example example = new ShippingLabel2Example();
		ShippingLabel2Example.Criteria criteria = example.createCriteria();
		criteria.andSidEqualTo(id);
		List<ShippingLabel2> ShippingLabel2List = this.shippingLabel2Mapper.selectByExampleWithBLOBs(example);
		result.setRows(ShippingLabel2List);
		PageInfo<ShippingLabel2> pageInfo = new PageInfo<ShippingLabel2>(ShippingLabel2List);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addShippingLabel(List<ShippingLabel2> shippingLabel2List, Integer tid, Integer sid, String tpo) {
		try {
			for (ShippingLabel2 shippingLabel2 : shippingLabel2List) {
				shippingLabel2.setSid(sid);
				shippingLabel2.setTpo(tpo);
				this.shippingLabel2Mapper.insert(shippingLabel2);
				Tpo2 tpo2 = new Tpo2();
				tpo2.setStatus(Integer.valueOf(1));
				Tpo2Example tpo2Example = new Tpo2Example();
				Tpo2Example.Criteria criteria = tpo2Example.createCriteria();
				criteria.andItemEqualTo(shippingLabel2.getItem());
				criteria.andTidEqualTo(tid);
				this.tpo2Mapper.updateByExampleSelective(tpo2, tpo2Example);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult deleteShippingLabe2(List<ShippingLabel2> shippingLabel2List) {
		try {
			for (ShippingLabel2 shippingLabel2 : shippingLabel2List) {
				this.shippingLabel2Mapper.deleteByPrimaryKey(shippingLabel2.getId());
				Tpo1Example example = new Tpo1Example();
				Tpo1Example.Criteria criteria1 = example.createCriteria();
				criteria1.andTpoEqualTo(shippingLabel2.getTpo());
				List<Tpo1> Tpo1List = this.tpo1Mapper.selectByExample(example);
				Integer tid = ((Tpo1) Tpo1List.get(0)).getId();
				Tpo2 tpo2 = new Tpo2();
				tpo2.setStatus(Integer.valueOf(0));
				Tpo2Example tpo2Example = new Tpo2Example();
				Tpo2Example.Criteria criteria = tpo2Example.createCriteria();
				criteria.andItemEqualTo(shippingLabel2.getItem());
				criteria.andTidEqualTo(tid);
				this.tpo2Mapper.updateByExampleSelective(tpo2, tpo2Example);
			}
			ShippingLabel2Example shippingLabel2Example = new ShippingLabel2Example();
			ShippingLabel2Example.Criteria createCriteria = shippingLabel2Example.createCriteria();
			createCriteria.andSidEqualTo(((ShippingLabel2) shippingLabel2List.get(0)).getSid());
			List<ShippingLabel2> sl2 = this.shippingLabel2Mapper.selectByExample(shippingLabel2Example);
			if (sl2.size() == 0) {
				this.shippingLabel1Mapper.deleteByPrimaryKey(((ShippingLabel2) shippingLabel2List.get(0)).getSid());
				return AjaxResult.ok("noData");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateShippingLabe1(ShippingLabel1 shippingLabel1) {
		try {
			this.shippingLabel1Mapper.updateByPrimaryKeySelective(shippingLabel1);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}
}
