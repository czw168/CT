/*     */ package cn.ubot.controller.production;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUDataGridFootResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.JsonUtils;
/*     */ import cn.ubot.pojo.generator.Jo;
/*     */ import cn.ubot.pojo.generator.Ltc;
/*     */ import cn.ubot.pojo.generator.PackingLabel;
/*     */ import cn.ubot.pojo.generator.ReelLabel;
/*     */ import cn.ubot.service.production.JOService;
/*     */ import cn.ubot.service.production.LTCService;
/*     */ import cn.ubot.service.production.PackingLabelService;
/*     */ import cn.ubot.service.production.ReelLabelService;
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
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/production"})
/*     */ public class ProductionController
/*     */ {
/*     */   @Autowired
/*     */   private JOService joService;
/*     */   @Autowired
/*     */   private LTCService ltcService;
/*     */   @Autowired
/*     */   private ReelLabelService reelLabelService;
/*     */   @Autowired
/*     */   private PackingLabelService packingLabelService;
/*     */   
/*     */   @RequestMapping({"/{page}"})
/*  53 */   public String showPage(@PathVariable String page) { return "/production/" + page; }
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
/*     */   @GetMapping({"/listJO"})
/*     */   @ResponseBody
/*  66 */   EUDataGridResult listJO(Integer page, Integer rows, String joNo) { return this.joService.listJO(page, rows, joNo); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/getMaxJoNo"})
/*     */   @ResponseBody
/*  76 */   AjaxResult getMaxJoNo() { return this.joService.getMaxJoNo(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/newJO"})
/*     */   @ResponseBody
/*     */   AjaxResult newJO(@RequestBody JSONObject obj) {
/*  87 */     JSONArray jsonArray = obj.getJSONArray("listJo");
/*  88 */     List<Jo> listJo = jsonArray.toJavaList(Jo.class);
/*  89 */     this.joService.newJO(listJo);
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listDetailsJO"})
/*     */   @ResponseBody
/* 103 */   EUDataGridFootResult listDetailsJO(Integer page, Integer rows, String joNo) { return this.joService.listDetailsJO(page, rows, joNo); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addJO"})
/*     */   @ResponseBody
/*     */   AjaxResult addJO(@RequestBody JSONObject obj) {
/* 114 */     Jo jo = (Jo)JsonUtils.jsonToPojo(obj.toJSONString(), Jo.class);
/* 115 */     return this.joService.addJO(jo);
/*     */   }
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
/*     */   @PostMapping({"/updateJO"})
/*     */   @ResponseBody
/*     */   AjaxResult updateJO(@RequestBody JSONObject obj) {
/* 141 */     Jo jo = (Jo)JsonUtils.jsonToPojo(obj.toJSONString(), Jo.class);
/* 142 */     return this.joService.updateJO(jo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listLTC"})
/*     */   @ResponseBody
/* 150 */   EUDataGridResult listLTC(Integer page, Integer rows, String ltc) { return this.ltcService.listLTC(page, rows, ltc); }
/*     */ 
/*     */   
/*     */   @PostMapping({"/newLTC"})
/*     */   @ResponseBody
/*     */   AjaxResult newLTC(@RequestBody JSONObject obj) {
/* 156 */     Ltc ltc = (Ltc)JsonUtils.jsonToPojo(obj.toJSONString(), Ltc.class);
/* 157 */     return this.ltcService.newLTC(ltc);
/*     */   }
/*     */   
/*     */   @PostMapping({"/updateLTC"})
/*     */   @ResponseBody
/*     */   AjaxResult updateLTC(@RequestBody JSONObject obj) {
/* 163 */     Ltc ltc = (Ltc)JsonUtils.jsonToPojo(obj.toJSONString(), Ltc.class);
/* 164 */     return this.ltcService.updateLTC(ltc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listReelLabel"})
/*     */   @ResponseBody
/* 172 */   EUDataGridResult listReelLabel(Integer page, Integer rows, String ltc) { return this.reelLabelService.listReelLabel(page, rows, ltc); }
/*     */ 
/*     */   
/*     */   @PostMapping({"/newReelLabel"})
/*     */   @ResponseBody
/*     */   AjaxResult newReelLabel(@RequestBody JSONObject obj) {
/* 178 */     ReelLabel reelLabel = (ReelLabel)JsonUtils.jsonToPojo(obj.toJSONString(), ReelLabel.class);
/* 179 */     return this.reelLabelService.newReelLabel(reelLabel);
/*     */   }
/*     */   
/*     */   @PostMapping({"/updateReelLabel"})
/*     */   @ResponseBody
/*     */   AjaxResult updateReelLabel(@RequestBody JSONObject obj) {
/* 185 */     Long id = obj.getLong("id");
/* 186 */     String ltc = obj.getString("ltc");
/* 187 */     Integer batches = obj.getInteger("batches");
/* 188 */     Integer batches2 = obj.getInteger("batches2");
/* 189 */     String updateBy = obj.getString("updateBy");
/* 190 */     ReelLabel rl = new ReelLabel();
/* 191 */     rl.setId(id);
/* 192 */     rl.setLtc(ltc);
/* 193 */     rl.setBatches(batches);
/* 194 */     rl.setUpdateBy(updateBy);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     return this.reelLabelService.updateReelLabel(rl, batches2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/getMaxCarton"})
/*     */   @ResponseBody
/* 215 */   AjaxResult getMaxCarton() { return this.packingLabelService.getMaxCarton(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/newPackingLabel"})
/*     */   @ResponseBody
/*     */   AjaxResult newPackingLabel(@RequestBody JSONObject obj) {
/* 226 */     PackingLabel packingLabel = (PackingLabel)JsonUtils.jsonToPojo(obj.toJSONString(), PackingLabel.class);
/* 227 */     return this.packingLabelService.newPackingLabel(packingLabel);
/*     */   }
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
/*     */   @GetMapping({"/listPackingLabel"})
/*     */   @ResponseBody
/* 241 */   EUDataGridResult listPackingLabel(Integer page, Integer rows, String carton, String lotNo) { return this.packingLabelService.getPackingLabelList(page, rows, carton, lotNo); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/updatePackingLabel"})
/*     */   @ResponseBody
/*     */   AjaxResult updatePackingLabel(@RequestBody JSONObject obj) {
/* 252 */     PackingLabel packingLabel = (PackingLabel)JsonUtils.jsonToPojo(obj.toJSONString(), PackingLabel.class);
/* 253 */     return this.packingLabelService.updatePackingLabel(packingLabel);
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\controller\production\ProductionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */