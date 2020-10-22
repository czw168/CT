package cn.ubot.controller.production;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridFootResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.Jo;
import cn.ubot.pojo.generator.Ltc;
import cn.ubot.pojo.generator.PackingLabel;
import cn.ubot.pojo.generator.ReelLabel;
import cn.ubot.service.production.JOService;
import cn.ubot.service.production.LTCService;
import cn.ubot.service.production.PackingLabelService;
import cn.ubot.service.production.ReelLabelService;
import cn.ubot.utils.JsonUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/production" })
public class ProductionController {
	@Autowired
	private JOService joService;
	@Autowired
	private LTCService ltcService;
	@Autowired
	private ReelLabelService reelLabelService;
	@Autowired
	private PackingLabelService packingLabelService;

	@RequestMapping({ "/{page}" })
	public String showPage(@PathVariable String page) {
		return "/production/" + page;
	}

	@GetMapping({ "/listJO" })
	@ResponseBody
	EUDataGridResult listJO(Integer page, Integer rows, String joNo) {
		return this.joService.listJO(page, rows, joNo);
	}

	@GetMapping({ "/getMaxJoNo" })
	@ResponseBody
	AjaxResult getMaxJoNo() {
		return this.joService.getMaxJoNo();
	}

	@PostMapping({ "/newJO" })
	@ResponseBody
	AjaxResult newJO(@RequestBody JSONObject obj) {
		JSONArray jsonArray = obj.getJSONArray("listJo");
		List<Jo> listJo = jsonArray.toJavaList(Jo.class);
		this.joService.newJO(listJo);
		return null;
	}

	@GetMapping({ "/listDetailsJO" })
	@ResponseBody
	EUDataGridFootResult listDetailsJO(Integer page, Integer rows, String joNo) {
		return this.joService.listDetailsJO(page, rows, joNo);
	}

	@PostMapping({ "/addJO" })
	@ResponseBody
	AjaxResult addJO(@RequestBody JSONObject obj) {
		Jo jo = (Jo) JsonUtils.jsonToPojo(obj.toJSONString(), Jo.class);
		return this.joService.addJO(jo);
	}

	@PostMapping({ "/updateJO" })
	@ResponseBody
	AjaxResult updateJO(@RequestBody JSONObject obj) {
		Jo jo = (Jo) JsonUtils.jsonToPojo(obj.toJSONString(), Jo.class);
		return this.joService.updateJO(jo);
	}

	@GetMapping({ "/listLTC" })
	@ResponseBody
	EUDataGridResult listLTC(Integer page, Integer rows, String ltc) {
		return this.ltcService.listLTC(page, rows, ltc);
	}

	@PostMapping({ "/newLTC" })
	@ResponseBody
	AjaxResult newLTC(@RequestBody JSONObject obj) {
		Ltc ltc = (Ltc) JsonUtils.jsonToPojo(obj.toJSONString(), Ltc.class);
		return this.ltcService.newLTC(ltc);
	}

	@PostMapping({ "/updateLTC" })
	@ResponseBody
	AjaxResult updateLTC(@RequestBody JSONObject obj) {
		Ltc ltc = (Ltc) JsonUtils.jsonToPojo(obj.toJSONString(), Ltc.class);
		return this.ltcService.updateLTC(ltc);
	}

	@GetMapping({ "/listReelLabel" })
	@ResponseBody
	EUDataGridResult listReelLabel(Integer page, Integer rows, String ltc) {
		return this.reelLabelService.listReelLabel(page, rows, ltc);
	}

	@PostMapping({ "/newReelLabel" })
	@ResponseBody
	AjaxResult newReelLabel(@RequestBody JSONObject obj) {
		ReelLabel reelLabel = (ReelLabel) JsonUtils.jsonToPojo(obj.toJSONString(), ReelLabel.class);
		return this.reelLabelService.newReelLabel(reelLabel);
	}

	@PostMapping({ "/updateReelLabel" })
	@ResponseBody
	AjaxResult updateReelLabel(@RequestBody JSONObject obj) {
		Long id = obj.getLong("id");
		String ltc = obj.getString("ltc");
		Integer batches = obj.getInteger("batches");
		Integer batches2 = obj.getInteger("batches2");
		String updateBy = obj.getString("updateBy");
		ReelLabel rl = new ReelLabel();
		rl.setId(id);
		rl.setLtc(ltc);
		rl.setBatches(batches);
		rl.setUpdateBy(updateBy);
		return this.reelLabelService.updateReelLabel(rl, batches2);
	}

	@GetMapping({ "/getMaxCarton" })
	@ResponseBody
	AjaxResult getMaxCarton() {
		return this.packingLabelService.getMaxCarton();
	}

	@PostMapping({ "/newPackingLabel" })
	@ResponseBody
	AjaxResult newPackingLabel(@RequestBody JSONObject obj) {
		PackingLabel packingLabel = (PackingLabel) JsonUtils.jsonToPojo(obj.toJSONString(), PackingLabel.class);
		return this.packingLabelService.newPackingLabel(packingLabel);
	}

	@GetMapping({ "/listPackingLabel" })
	@ResponseBody
	EUDataGridResult listPackingLabel(Integer page, Integer rows, String carton, String lotNo) {
		return this.packingLabelService.getPackingLabelList(page, rows, carton, lotNo);
	}

	@PostMapping({ "/updatePackingLabel" })
	@ResponseBody
	AjaxResult updatePackingLabel(@RequestBody JSONObject obj) {
		PackingLabel packingLabel = (PackingLabel) JsonUtils.jsonToPojo(obj.toJSONString(), PackingLabel.class);
		return this.packingLabelService.updatePackingLabel(packingLabel);
	}
}
