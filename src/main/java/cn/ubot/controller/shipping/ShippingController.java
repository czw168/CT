package cn.ubot.controller.shipping;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridFootResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.ShippingLabel1;
import cn.ubot.pojo.generator.ShippingLabel2;
import cn.ubot.pojo.generator.Tpo1;
import cn.ubot.pojo.generator.Tpo2;
import cn.ubot.service.shipping.ShippingLabelService;
import cn.ubot.service.shipping.TpoService;
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
@RequestMapping({ "/shipping" })
public class ShippingController {
	@Autowired
	private TpoService tpoService;
	@Autowired
	private ShippingLabelService shippingLabelService;

	@RequestMapping({ "/{page}" })
	public String showPage(@PathVariable String page) {
		return "/shipping/" + page;
	}

	@PostMapping({ "/newTpo1" })
	@ResponseBody
	AjaxResult newTpo(@RequestBody JSONObject obj) {
		JSONObject jsonObject = obj.getJSONObject("tpo1");
		return this.tpoService.newTpo1((Tpo1) JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo1.class));
	}

	@PostMapping({ "/updateTpo1" })
	@ResponseBody
	AjaxResult updateTpo1(@RequestBody JSONObject obj) {
		JSONObject jsonObject = obj.getJSONObject("tpo1");
		return this.tpoService.updateTpo1((Tpo1) JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo1.class));
	}

	@PostMapping({ "/updateTpo2" })
	@ResponseBody
	AjaxResult updateTpo2(@RequestBody JSONObject obj) {
		JSONObject jsonObject = obj.getJSONObject("tpo2");
		return this.tpoService.updateTpo2((Tpo2) JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo2.class));
	}

	@GetMapping({ "/listTpo" })
	@ResponseBody
	EUDataGridResult listTpo(Integer page, Integer rows, String tpo) {
		return this.tpoService.listTpo(page, rows, tpo);
	}

	@GetMapping({ "/listTpo2" })
	@ResponseBody
	EUDataGridFootResult listTpo2(Integer page, Integer rows, Integer id) {
		return this.tpoService.listTpo2(page, rows, id);
	}

	@GetMapping({ "/listNotToChooseTpo2" })
	@ResponseBody
	EUDataGridResult listNotToChooseTpo2(Integer page, Integer rows, Integer id) {
		return this.tpoService.listNotToChooseTpo2(page, rows, id);
	}

	@PostMapping({ "/addTpo" })
	@ResponseBody
	AjaxResult addTpo(@RequestBody JSONObject obj) {
		JSONObject jsonObject = obj.getJSONObject("tpo2");
		String createBy = obj.getString("createBy");
		return this.tpoService.addTpo((Tpo2) JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo2.class), createBy);
	}

	@PostMapping({ "/updateTpo" })
	@ResponseBody
	AjaxResult updateTpo(@RequestBody JSONObject obj) {
		JSONArray jsonArray = obj.getJSONArray("listTpo");
		List<Tpo2> tpo2s = jsonArray.toJavaList(Tpo2.class);
		JSONObject jsonObject1 = obj.getJSONObject("tpoEditFrom1");
		JSONObject jsonObject2 = obj.getJSONObject("tpoEditFrom2");
		return this.tpoService.updateTpo(tpo2s, (Tpo1) JsonUtils.jsonToPojo(jsonObject1.toJSONString(), Tpo1.class),
				(Tpo1) JsonUtils.jsonToPojo(jsonObject2.toJSONString(), Tpo1.class));
	}

	@GetMapping({ "/getIdByTpo" })
	@ResponseBody
	AjaxResult getIdByTpo(String tpo) {
		return this.tpoService.getIdByTpo(tpo);
	}

	@PostMapping({ "/newShippingLabel" })
	@ResponseBody
	AjaxResult newShippingLabel(@RequestBody JSONObject obj) {
		JSONArray jsonArray = obj.getJSONArray("listShippingLabel2");
		List<ShippingLabel2> shippingLabel2List = jsonArray.toJavaList(ShippingLabel2.class);
		JSONObject jsonObject = obj.getJSONObject("shippingLabelNewFrom");
		String tpo = obj.getString("tpo");
		Integer tid = obj.getInteger("tid");
		return this.shippingLabelService.newShippingLabel(
				(ShippingLabel1) JsonUtils.jsonToPojo(jsonObject.toJSONString(), ShippingLabel1.class),
				shippingLabel2List, tpo, tid);
	}

	@GetMapping({ "/listShippingLabel" })
	@ResponseBody
	EUDataGridResult listShippingLabel(Integer page, Integer rows, String shipLot) {
		return this.shippingLabelService.listShippingLabel(page, rows, shipLot);
	}

	@GetMapping({ "/listShippingLabel2" })
	@ResponseBody
	EUDataGridResult listShippingLabel2(Integer page, Integer rows, Integer id) {
		return this.shippingLabelService.listShippingLabel2(page, rows, id);
	}

	@PostMapping({ "/addShippingLabel" })
	@ResponseBody
	AjaxResult addShippingLabel(@RequestBody JSONObject obj) {
		JSONArray jsonArray = obj.getJSONArray("listShippingLabel2");
		List<ShippingLabel2> shippingLabel2List = jsonArray.toJavaList(ShippingLabel2.class);
		Integer sid = obj.getInteger("sid");
		Integer tid = obj.getInteger("tid");
		String tpo = obj.getString("tpo");
		return this.shippingLabelService.addShippingLabel(shippingLabel2List, tid, sid, tpo);
	}

	@PostMapping({ "/deleteShippingLabel2" })
	@ResponseBody
	AjaxResult deleteShippingLabel2(@RequestBody JSONObject obj) {
		JSONArray jsonArray = obj.getJSONArray("listShippingLabel2");
		List<ShippingLabel2> shippingLabel2List = jsonArray.toJavaList(ShippingLabel2.class);
		return this.shippingLabelService.deleteShippingLabe2(shippingLabel2List);
	}

	@PostMapping({ "/updateShippingLabel1" })
	@ResponseBody
	AjaxResult updateShippingLabel1(@RequestBody JSONObject obj) {
		return this.shippingLabelService
				.updateShippingLabe1((ShippingLabel1) JsonUtils.jsonToPojo(obj.toJSONString(), ShippingLabel1.class));
	}
}
