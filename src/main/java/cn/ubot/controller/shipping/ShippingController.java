/*     */ package cn.ubot.controller.shipping;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUDataGridFootResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.JsonUtils;
/*     */ import cn.ubot.pojo.generator.ShippingLabel1;
/*     */ import cn.ubot.pojo.generator.ShippingLabel2;
/*     */ import cn.ubot.pojo.generator.Tpo1;
/*     */ import cn.ubot.pojo.generator.Tpo2;
/*     */ import cn.ubot.service.shipping.ShippingLabelService;
/*     */ import cn.ubot.service.shipping.TpoService;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/shipping"})
/*     */ public class ShippingController
/*     */ {
/*     */   @Autowired
/*     */   private TpoService tpoService;
/*     */   @Autowired
/*     */   private ShippingLabelService shippingLabelService;
/*     */   
/*     */   @RequestMapping({"/{page}"})
/*  46 */   public String showPage(@PathVariable String page) { return "/shipping/" + page; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/newTpo1"})
/*     */   @ResponseBody
/*     */   AjaxResult newTpo(@RequestBody JSONObject obj) {
/*  72 */     JSONObject jsonObject = obj.getJSONObject("tpo1");
/*  73 */     return this.tpoService.newTpo1((Tpo1)JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo1.class));
/*     */   }
/*     */   
/*     */   @PostMapping({"/updateTpo1"})
/*     */   @ResponseBody
/*     */   AjaxResult updateTpo1(@RequestBody JSONObject obj) {
/*  79 */     JSONObject jsonObject = obj.getJSONObject("tpo1");
/*  80 */     return this.tpoService.updateTpo1((Tpo1)JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo1.class));
/*     */   }
/*     */   
/*     */   @PostMapping({"/updateTpo2"})
/*     */   @ResponseBody
/*     */   AjaxResult updateTpo2(@RequestBody JSONObject obj) {
/*  86 */     JSONObject jsonObject = obj.getJSONObject("tpo2");
/*  87 */     return this.tpoService.updateTpo2((Tpo2)JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo2.class));
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/listTpo"})
/*     */   @ResponseBody
/*  93 */   EUDataGridResult listTpo(Integer page, Integer rows, String tpo) { return this.tpoService.listTpo(page, rows, tpo); }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listTpo2"})
/*     */   @ResponseBody
/*  99 */   EUDataGridFootResult listTpo2(Integer page, Integer rows, Integer id) { return this.tpoService.listTpo2(page, rows, id); }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listNotToChooseTpo2"})
/*     */   @ResponseBody
/* 105 */   EUDataGridResult listNotToChooseTpo2(Integer page, Integer rows, Integer id) { return this.tpoService.listNotToChooseTpo2(page, rows, id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addTpo"})
/*     */   @ResponseBody
/*     */   AjaxResult addTpo(@RequestBody JSONObject obj) {
/* 122 */     JSONObject jsonObject = obj.getJSONObject("tpo2");
/* 123 */     String createBy = obj.getString("createBy");
/* 124 */     return this.tpoService.addTpo((Tpo2)JsonUtils.jsonToPojo(jsonObject.toJSONString(), Tpo2.class), createBy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/updateTpo"})
/*     */   @ResponseBody
/*     */   AjaxResult updateTpo(@RequestBody JSONObject obj) {
/* 134 */     JSONArray jsonArray = obj.getJSONArray("listTpo");
/* 135 */     List<Tpo2> tpo2s = jsonArray.toJavaList(Tpo2.class);
/* 136 */     JSONObject jsonObject1 = obj.getJSONObject("tpoEditFrom1");
/* 137 */     JSONObject jsonObject2 = obj.getJSONObject("tpoEditFrom2");
/* 138 */     return this.tpoService.updateTpo(tpo2s, (Tpo1)JsonUtils.jsonToPojo(jsonObject1.toJSONString(), Tpo1.class), (Tpo1)JsonUtils.jsonToPojo(jsonObject2.toJSONString(), Tpo1.class));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/getIdByTpo"})
/*     */   @ResponseBody
/* 145 */   AjaxResult getIdByTpo(String tpo) { return this.tpoService.getIdByTpo(tpo); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/newShippingLabel"})
/*     */   @ResponseBody
/*     */   AjaxResult newShippingLabel(@RequestBody JSONObject obj) {
/* 153 */     JSONArray jsonArray = obj.getJSONArray("listShippingLabel2");
/* 154 */     List<ShippingLabel2> shippingLabel2List = jsonArray.toJavaList(ShippingLabel2.class);
/* 155 */     JSONObject jsonObject = obj.getJSONObject("shippingLabelNewFrom");
/* 156 */     String tpo = obj.getString("tpo");
/* 157 */     Integer tid = obj.getInteger("tid");
/* 158 */     return this.shippingLabelService.newShippingLabel((ShippingLabel1)JsonUtils.jsonToPojo(jsonObject.toJSONString(), ShippingLabel1.class), shippingLabel2List, tpo, tid);
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/listShippingLabel"})
/*     */   @ResponseBody
/* 164 */   EUDataGridResult listShippingLabel(Integer page, Integer rows, String shipLot) { return this.shippingLabelService.listShippingLabel(page, rows, shipLot); }
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listShippingLabel2"})
/*     */   @ResponseBody
/* 170 */   EUDataGridResult listShippingLabel2(Integer page, Integer rows, Integer id) { return this.shippingLabelService.listShippingLabel2(page, rows, id); }
/*     */ 
/*     */   
/*     */   @PostMapping({"/addShippingLabel"})
/*     */   @ResponseBody
/*     */   AjaxResult addShippingLabel(@RequestBody JSONObject obj) {
/* 176 */     JSONArray jsonArray = obj.getJSONArray("listShippingLabel2");
/* 177 */     List<ShippingLabel2> shippingLabel2List = jsonArray.toJavaList(ShippingLabel2.class);
/* 178 */     Integer sid = obj.getInteger("sid");
/* 179 */     Integer tid = obj.getInteger("tid");
/* 180 */     String tpo = obj.getString("tpo");
/* 181 */     return this.shippingLabelService.addShippingLabel(shippingLabel2List, tid, sid, tpo);
/*     */   }
/*     */   
/*     */   @PostMapping({"/deleteShippingLabel2"})
/*     */   @ResponseBody
/*     */   AjaxResult deleteShippingLabel2(@RequestBody JSONObject obj) {
/* 187 */     JSONArray jsonArray = obj.getJSONArray("listShippingLabel2");
/* 188 */     List<ShippingLabel2> shippingLabel2List = jsonArray.toJavaList(ShippingLabel2.class);
/* 189 */     return this.shippingLabelService.deleteShippingLabe2(shippingLabel2List);
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/updateShippingLabel1"})
/*     */   @ResponseBody
/* 195 */   AjaxResult updateShippingLabel1(@RequestBody JSONObject obj) { return this.shippingLabelService.updateShippingLabe1((ShippingLabel1)JsonUtils.jsonToPojo(obj.toJSONString(), ShippingLabel1.class)); }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\controller\shipping\ShippingController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */