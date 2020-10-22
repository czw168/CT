package cn.ubot.service.production.impl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.production.ReelLabelMapper_;
import cn.ubot.mapper.generator.ReelLabelLotMapper;
import cn.ubot.mapper.generator.ReelLabelMapper;
import cn.ubot.pojo.diy.production.ReelLabel_;
import cn.ubot.pojo.generator.ReelLabel;
import cn.ubot.pojo.generator.ReelLabelLot;
import cn.ubot.pojo.generator.ReelLabelLotExample;
import cn.ubot.service.production.ReelLabelService;
import cn.ubot.utils.DateUtils;

@Service
public class ReelLabelServiceImpl implements ReelLabelService {
	@Autowired
	private ReelLabelMapper reelLabelMapper;
	@Autowired
	private ReelLabelLotMapper reelLabelLotMapper;
	@Autowired
	private ReelLabelMapper_ reelLabelMapper_;

	public EUDataGridResult listReelLabel(Integer page, Integer rows, String ltc) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<ReelLabel_> reelLabelList = this.reelLabelMapper_.getReelLabelList(ltc);
		result.setRows(reelLabelList);
		PageInfo<ReelLabel_> pageInfo = new PageInfo<ReelLabel_>(reelLabelList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult newReelLabel(ReelLabel reelLabel) {
		try {
			String lane = reelLabel.getLane();
			java.util.Date productionDate = reelLabel.getProductionDate();
			int month = DateUtils.getMonth(productionDate);
			String date = DateUtils.format(productionDate, "dd");
			int year = DateUtils.getYear(productionDate);
			String productionDate_ = (month < 10) ? ("0" + month) : ("" + month);
			productionDate_ = productionDate_ + date + year;
			ReelLabelLotExample example = new ReelLabelLotExample();
			ReelLabelLotExample.Criteria criteria = example.createCriteria();
			criteria.andProductionDateEqualTo(productionDate_);
			criteria.andLaneEqualTo(lane);
			List<ReelLabelLot> reelLabelLots = this.reelLabelLotMapper.selectByExample(example);
			if (!reelLabelLots.isEmpty()) {
				return AjaxResult.build(Integer.valueOf(400), "Fail. Duplicate Lot NO.");
			}
			for (int i = 0; i < reelLabel.getBatches().intValue(); i++) {
				String lotNo = null;
				if (i < 9) {
					lotNo = reelLabel.getMachine() + productionDate_ + "-0" + (i + 1) + lane;
				} else {
					lotNo = reelLabel.getMachine() + productionDate_ + "-" + (i + 1) + lane;
				}
				ReelLabelLot rll = new ReelLabelLot();
				rll.setLane(lane);
				rll.setLotNo(lotNo);
				rll.setLtc(reelLabel.getLtc());
				rll.setMachine(reelLabel.getMachine());
				rll.setProductionDate(productionDate_);
				this.reelLabelLotMapper.insert(rll);
			}
			reelLabel.setCreateTime(new Date(System.currentTimeMillis()));
			reelLabel.setStatus(Integer.valueOf(0));
			this.reelLabelMapper.insert(reelLabel);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), "Error");
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateReelLabel(ReelLabel reelLabel, Integer batches) {
		try {
			PageHelper.startPage(1, 1);
			ReelLabelLotExample example = new ReelLabelLotExample();
			ReelLabelLotExample.Criteria criteria = example.createCriteria();
			criteria.andLtcEqualTo(reelLabel.getLtc());
			ReelLabelLot reelLabelLot = (ReelLabelLot) this.reelLabelLotMapper.selectByExample(example).get(0);
			for (int i = reelLabel.getBatches().intValue() + 1; i <= batches.intValue(); i++) {
				ReelLabelLot rll = new ReelLabelLot();
				rll.setLane(reelLabelLot.getLane());
				if (i < 10) {
					rll.setLotNo(reelLabelLot.getMachine() + reelLabelLot.getProductionDate() + "-0" + i
							+ reelLabelLot.getLane());
				} else {
					rll.setLotNo(reelLabelLot.getMachine() + reelLabelLot.getProductionDate() + "-" + i
							+ reelLabelLot.getLane());
				}
				rll.setLtc(reelLabelLot.getLtc());
				rll.setMachine(reelLabelLot.getMachine());
				rll.setProductionDate(reelLabelLot.getProductionDate());
				this.reelLabelLotMapper.insert(rll);
			}
			reelLabel.setBatches(batches);
			reelLabel.setUpdateTime(new Date(System.currentTimeMillis()));
			this.reelLabelMapper.updateByPrimaryKeySelective(reelLabel);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), "Error");
		}
		return AjaxResult.ok();
	}
}
