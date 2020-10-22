package cn.ubot.service.production.impl;

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
import cn.ubot.mapper.diy.production.PackingLabelMapper_;
import cn.ubot.mapper.generator.PackingLabelMapper;
import cn.ubot.mapper.generator.ReelLabelLotMapper;
import cn.ubot.pojo.diy.production.PackingLtc;
import cn.ubot.pojo.generator.PackingLabel;
import cn.ubot.pojo.generator.PackingLabelExample;
import cn.ubot.pojo.generator.ReelLabelLot;
import cn.ubot.pojo.generator.ReelLabelLotExample;
import cn.ubot.service.production.PackingLabelService;
import cn.ubot.utils.ExceptionUtils;

@Service
public class PackingLabelServiceImpl implements PackingLabelService {
	@Autowired
	private PackingLabelMapper packingLabelMapper;
	@Autowired
	private PackingLabelMapper_ packingLabelMapper_;
	@Autowired
	private ReelLabelLotMapper reelLabelLotMapper;

	public AjaxResult getMaxCarton() {
		String maxCarton = this.packingLabelMapper_.getMaxCarton();
		if (StringUtils.isEmpty(maxCarton)) {
			return AjaxResult.ok("P000000001");
		}
		String a = maxCarton.substring(0, 1);
		String b = maxCarton.substring(1);
		Integer num = Integer.valueOf(Integer.parseInt(b) + 1);
		NumberFormat nf = new DecimalFormat("000000000");
		String formatNum = nf.format(num);
		return AjaxResult.ok(a + formatNum);
	}

	public AjaxResult newPackingLabel(PackingLabel packingLabel) {
		if (packingLabel.getQ1().equals(packingLabel.getQ2()) || packingLabel.getQ1().equals(packingLabel.getQ3())) {
			return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ1() + "].");
		}
		if (packingLabel.getQ2().equals(packingLabel.getQ3())) {
			return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ2() + "].");
		}
		ReelLabelLotExample example = new ReelLabelLotExample();
		ReelLabelLotExample.Criteria criteria = example.createCriteria();
		criteria.andLotNoEqualTo(packingLabel.getQ1());
		List<ReelLabelLot> list1 = this.reelLabelLotMapper.selectByExample(example);
		if (list1.size() == 0) {
			return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ1() + "] is not exist.");
		}
		ReelLabelLotExample example2 = new ReelLabelLotExample();
		ReelLabelLotExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andLotNoEqualTo(packingLabel.getQ2());
		List<ReelLabelLot> list2 = this.reelLabelLotMapper.selectByExample(example2);
		if (list2.size() == 0) {
			return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ2() + "] is not exist.");
		}
		ReelLabelLotExample example3 = new ReelLabelLotExample();
		ReelLabelLotExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andLotNoEqualTo(packingLabel.getQ3());
		List<ReelLabelLot> list3 = this.reelLabelLotMapper.selectByExample(example3);
		if (list3.size() == 0) {
			return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ3() + "] is not exist.");
		}
		PackingLabelExample packingLabelExample = new PackingLabelExample();
		List<PackingLabel> packingLabelList = this.packingLabelMapper.selectByExample(packingLabelExample);
		for (PackingLabel pl : packingLabelList) {
			if (pl.getQ1().equals(packingLabel.getQ1()) || pl.getQ2().equals(packingLabel.getQ1())
					|| pl.getQ3().equals(packingLabel.getQ1())) {
				return AjaxResult.build(Integer.valueOf(400),
						"Lot No : [" + packingLabel.getQ1() + "] <br> has been scanned.");
			}
			if (pl.getQ1().equals(packingLabel.getQ2()) || pl.getQ2().equals(packingLabel.getQ2())
					|| pl.getQ3().equals(packingLabel.getQ2())) {
				return AjaxResult.build(Integer.valueOf(400),
						"Lot No : [" + packingLabel.getQ2() + "] <br> has been scanned.");
			}
			if (pl.getQ1().equals(packingLabel.getQ3()) || pl.getQ2().equals(packingLabel.getQ3())
					|| pl.getQ3().equals(packingLabel.getQ3())) {
				return AjaxResult.build(Integer.valueOf(400),
						"Lot No : [" + packingLabel.getQ3() + "] <br> has been scanned.");
			}
		}
		packingLabel.setCreateTime(new Date(System.currentTimeMillis()));
		try {
			this.packingLabelMapper.insertSelective(packingLabel);
			return AjaxResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
	}

	public EUDataGridResult getPackingLabelList(Integer page, Integer rows, String carton, String lotNo) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<PackingLtc> packingLtcList = this.packingLabelMapper_.getPackingLtc(carton, lotNo);
		result.setRows(packingLtcList);
		PageInfo<PackingLtc> pageInfo = new PageInfo<PackingLtc>(packingLtcList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult updatePackingLabel(PackingLabel packingLabel) {
		if (packingLabel.getQ1().equals(packingLabel.getQ2()) || packingLabel.getQ1().equals(packingLabel.getQ3())) {
			return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ1() + "].");
		}
		if (packingLabel.getQ2().equals(packingLabel.getQ3())) {
			return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ2() + "].");
		}
		ReelLabelLotExample example = new ReelLabelLotExample();
		ReelLabelLotExample.Criteria criteria = example.createCriteria();
		criteria.andLotNoEqualTo(packingLabel.getQ1());
		List<ReelLabelLot> list1 = this.reelLabelLotMapper.selectByExample(example);
		if (list1.size() == 0) {
			return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ1() + "] is not exist.");
		}
		ReelLabelLotExample example2 = new ReelLabelLotExample();
		ReelLabelLotExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andLotNoEqualTo(packingLabel.getQ2());
		List<ReelLabelLot> list2 = this.reelLabelLotMapper.selectByExample(example2);
		if (list2.size() == 0) {
			return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ2() + "] is not exist.");
		}
		ReelLabelLotExample example3 = new ReelLabelLotExample();
		ReelLabelLotExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andLotNoEqualTo(packingLabel.getQ3());
		List<ReelLabelLot> list3 = this.reelLabelLotMapper.selectByExample(example3);
		if (list3.size() == 0) {
			return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ3() + "] is not exist.");
		}
		PackingLabel packingLabel2 = this.packingLabelMapper.selectByPrimaryKey(packingLabel.getId());
		PackingLabelExample packingLabelExample = new PackingLabelExample();
		List<PackingLabel> packingLabelList = this.packingLabelMapper.selectByExample(packingLabelExample);
		if (!packingLabel.getQ1().equals(packingLabel2.getQ1())) {
			for (PackingLabel pl : packingLabelList) {
				if (pl.getQ1().equals(packingLabel.getQ1()) || pl.getQ2().equals(packingLabel.getQ1())
						|| pl.getQ3().equals(packingLabel.getQ1())) {
					return AjaxResult.build(Integer.valueOf(400),
							"Lot No : [" + packingLabel.getQ1() + "] <br> has been scanned.");
				}
			}
		}
		if (!packingLabel.getQ2().equals(packingLabel2.getQ2())) {
			for (PackingLabel pl : packingLabelList) {
				if (pl.getQ1().equals(packingLabel.getQ2()) || pl.getQ2().equals(packingLabel.getQ2())
						|| pl.getQ3().equals(packingLabel.getQ2())) {
					return AjaxResult.build(Integer.valueOf(400),
							"Lot No : [" + packingLabel.getQ2() + "] <br> has been scanned.");
				}
			}
		}
		if (!packingLabel.getQ3().equals(packingLabel2.getQ3())) {
			for (PackingLabel pl : packingLabelList) {
				if (pl.getQ1().equals(packingLabel.getQ3()) || pl.getQ2().equals(packingLabel.getQ3())
						|| pl.getQ3().equals(packingLabel.getQ3())) {
					return AjaxResult.build(Integer.valueOf(400),
							"Lot No : [" + packingLabel.getQ3() + "] <br> has been scanned.");
				}
			}
		}
		packingLabel.setUpdateTime(new Date(System.currentTimeMillis()));
		try {
			this.packingLabelMapper.updateByPrimaryKeySelective(packingLabel);
			return AjaxResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
	}
}
