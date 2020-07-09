/*     */ package cn.ubot.service.shipping.impl;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.DateUtil;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.ExceptionUtil;
/*     */ import cn.ubot.mapper.diy.shipping.ShippingLabelMapper_;
/*     */ import cn.ubot.mapper.generator.ShippingLabel1Mapper;
/*     */ import cn.ubot.mapper.generator.ShippingLabel2Mapper;
/*     */ import cn.ubot.mapper.generator.ShippingLotMapper;
/*     */ import cn.ubot.mapper.generator.Tpo1Mapper;
/*     */ import cn.ubot.mapper.generator.Tpo2Mapper;
/*     */ import cn.ubot.pojo.diy.shipping.ShippingLabel;
/*     */ import cn.ubot.pojo.generator.ShippingLabel1;
/*     */ import cn.ubot.pojo.generator.ShippingLabel2;
/*     */ import cn.ubot.pojo.generator.ShippingLabel2Example;
/*     */ import cn.ubot.pojo.generator.ShippingLot;
/*     */ import cn.ubot.pojo.generator.Tpo1;
/*     */ import cn.ubot.pojo.generator.Tpo1Example;
/*     */ import cn.ubot.pojo.generator.Tpo2;
/*     */ import cn.ubot.pojo.generator.Tpo2Example;
/*     */ import cn.ubot.service.shipping.ShippingLabelService;
/*     */ import com.alibaba.druid.util.StringUtils;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import java.sql.Date;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ShippingLabelServiceImpl
/*     */   implements ShippingLabelService
/*     */ {
/*     */   @Autowired
/*     */   private ShippingLabelMapper_ shippingLabelMapper_;
/*     */   @Autowired
/*     */   private ShippingLotMapper shippingLotMapper;
/*     */   @Autowired
/*     */   private ShippingLabel1Mapper shippingLabel1Mapper;
/*     */   @Autowired
/*     */   private ShippingLabel2Mapper shippingLabel2Mapper;
/*     */   @Autowired
/*     */   private Tpo1Mapper tpo1Mapper;
/*     */   @Autowired
/*     */   private Tpo2Mapper tpo2Mapper;
/*     */   
/*     */   public AjaxResult newShippingLabel(ShippingLabel1 shippingLabel1, List<ShippingLabel2> shippingLabel2List, String tpo, Integer tid) {
/*     */     try {
/*  55 */       String shipLot = null;
/*  56 */       java.util.Date shipDate = shippingLabel1.getShipDate();
/*  57 */       int year = DateUtil.getYear(shipDate);
/*  58 */       int m = DateUtil.getMonth(shipDate);
/*  59 */       String month = null;
/*  60 */       if (m <= 9) {
/*  61 */         month = "0" + m;
/*     */       } else {
/*  63 */         month = "" + m;
/*     */       } 
/*  65 */       String maxSerialNumber = this.shippingLabelMapper_.getMaxSerialNumber(year + month + "");
/*  66 */       ShippingLot shippingLot = new ShippingLot();
/*  67 */       if (StringUtils.isEmpty(maxSerialNumber)) {
/*     */         
/*  69 */         shipLot = "C" + year + month + "001";
/*  70 */         shippingLot.setSerialNumber("001");
/*  71 */         shippingLot.setYearAndMonth(year + month + "");
/*     */       } else {
/*     */         
/*  74 */         Integer num = Integer.valueOf(Integer.parseInt(maxSerialNumber) + 1);
/*  75 */         NumberFormat nf = new DecimalFormat("000");
/*  76 */         String formatNum = nf.format(num);
/*  77 */         shipLot = "C" + year + month + formatNum;
/*  78 */         shippingLot.setSerialNumber(formatNum);
/*  79 */         shippingLot.setYearAndMonth(year + month + "");
/*     */       } 
/*  81 */       this.shippingLotMapper.insert(shippingLot);
/*     */       
/*  83 */       Integer maxId = this.shippingLabelMapper_.getMaxId();
/*  84 */       Integer id = Integer.valueOf((maxId == null) ? 1 : (maxId.intValue() + 1));
/*  85 */       shippingLabel1.setId(id);
/*  86 */       shippingLabel1.setShipLot(shipLot);
/*  87 */       shippingLabel1.setCreateTime(new Date(System.currentTimeMillis()));
/*     */       
/*  89 */       this.shippingLabel1Mapper.insert(shippingLabel1);
/*  90 */       for (ShippingLabel2 shippingLabel2 : shippingLabel2List) {
/*  91 */         shippingLabel2.setSid(id);
/*  92 */         shippingLabel2.setTpo(tpo);
/*  93 */         this.shippingLabel2Mapper.insertSelective(shippingLabel2);
/*     */         
/*  95 */         Tpo2 tpo2 = new Tpo2();
/*  96 */         tpo2.setStatus(Integer.valueOf(1));
/*  97 */         Tpo2Example tpo2Example = new Tpo2Example();
/*  98 */         Tpo2Example.Criteria criteria = tpo2Example.createCriteria();
/*  99 */         criteria.andItemEqualTo(shippingLabel2.getItem());
/* 100 */         criteria.andTidEqualTo(tid);
/* 101 */         this.tpo2Mapper.updateByExampleSelective(tpo2, tpo2Example);
/*     */       }
/*     */     
/* 104 */     } catch (NumberFormatException e) {
/* 105 */       e.printStackTrace();
/* 106 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 108 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public EUDataGridResult listShippingLabel(Integer page, Integer rows, String shipLot) {
/* 113 */     EUDataGridResult result = new EUDataGridResult();
/* 114 */     PageHelper.startPage(page.intValue(), rows.intValue());
/* 115 */     List<ShippingLabel> shippingLabelList = this.shippingLabelMapper_.getShippingLabelList(shipLot);
/* 116 */     result.setRows(shippingLabelList);
/*     */     
/* 118 */     PageInfo<ShippingLabel> pageInfo = new PageInfo<ShippingLabel>(shippingLabelList);
/* 119 */     result.setTotal(pageInfo.getTotal());
/* 120 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public EUDataGridResult listShippingLabel2(Integer page, Integer rows, Integer id) {
/* 125 */     EUDataGridResult result = new EUDataGridResult();
/* 126 */     PageHelper.startPage(page.intValue(), rows.intValue());
/* 127 */     ShippingLabel2Example example = new ShippingLabel2Example();
/* 128 */     ShippingLabel2Example.Criteria criteria = example.createCriteria();
/* 129 */     criteria.andSidEqualTo(id);
/* 130 */     List<ShippingLabel2> ShippingLabel2List = this.shippingLabel2Mapper.selectByExampleWithBLOBs(example);
/* 131 */     result.setRows(ShippingLabel2List);
/*     */     
/* 133 */     PageInfo<ShippingLabel2> pageInfo = new PageInfo<ShippingLabel2>(ShippingLabel2List);
/* 134 */     result.setTotal(pageInfo.getTotal());
/* 135 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult addShippingLabel(List<ShippingLabel2> shippingLabel2List, Integer tid, Integer sid, String tpo) {
/*     */     try {
/* 141 */       for (ShippingLabel2 shippingLabel2 : shippingLabel2List) {
/* 142 */         shippingLabel2.setSid(sid);
/* 143 */         shippingLabel2.setTpo(tpo);
/* 144 */         this.shippingLabel2Mapper.insert(shippingLabel2);
/*     */ 
/*     */         
/* 147 */         Tpo2 tpo2 = new Tpo2();
/* 148 */         tpo2.setStatus(Integer.valueOf(1));
/* 149 */         Tpo2Example tpo2Example = new Tpo2Example();
/* 150 */         Tpo2Example.Criteria criteria = tpo2Example.createCriteria();
/* 151 */         criteria.andItemEqualTo(shippingLabel2.getItem());
/* 152 */         criteria.andTidEqualTo(tid);
/* 153 */         this.tpo2Mapper.updateByExampleSelective(tpo2, tpo2Example);
/*     */       } 
/* 155 */     } catch (Exception e) {
/* 156 */       e.printStackTrace();
/* 157 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 159 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult deleteShippingLabe2(List<ShippingLabel2> shippingLabel2List) {
/*     */     try {
/* 165 */       for (ShippingLabel2 shippingLabel2 : shippingLabel2List) {
/* 166 */         this.shippingLabel2Mapper.deleteByPrimaryKey(shippingLabel2.getId());
/*     */         
/* 168 */         Tpo1Example example = new Tpo1Example();
/* 169 */         Tpo1Example.Criteria criteria1 = example.createCriteria();
/* 170 */         criteria1.andTpoEqualTo(shippingLabel2.getTpo());
/* 171 */         List<Tpo1> Tpo1List = this.tpo1Mapper.selectByExample(example);
/* 172 */         Integer tid = ((Tpo1)Tpo1List.get(0)).getId();
/*     */         
/* 174 */         Tpo2 tpo2 = new Tpo2();
/* 175 */         tpo2.setStatus(Integer.valueOf(0));
/* 176 */         Tpo2Example tpo2Example = new Tpo2Example();
/* 177 */         Tpo2Example.Criteria criteria = tpo2Example.createCriteria();
/* 178 */         criteria.andItemEqualTo(shippingLabel2.getItem());
/* 179 */         criteria.andTidEqualTo(tid);
/* 180 */         this.tpo2Mapper.updateByExampleSelective(tpo2, tpo2Example);
/*     */       } 
/*     */       
/* 183 */       ShippingLabel2Example shippingLabel2Example = new ShippingLabel2Example();
/* 184 */       ShippingLabel2Example.Criteria createCriteria = shippingLabel2Example.createCriteria();
/* 185 */       createCriteria.andSidEqualTo(((ShippingLabel2)shippingLabel2List.get(0)).getSid());
/* 186 */       List<ShippingLabel2> sl2 = this.shippingLabel2Mapper.selectByExample(shippingLabel2Example);
/* 187 */       if (sl2.size() == 0) {
/* 188 */         this.shippingLabel1Mapper.deleteByPrimaryKey(((ShippingLabel2)shippingLabel2List.get(0)).getSid());
/* 189 */         return AjaxResult.ok("noData");
/*     */       } 
/* 191 */     } catch (Exception e) {
/* 192 */       e.printStackTrace();
/* 193 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 195 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult updateShippingLabe1(ShippingLabel1 shippingLabel1) {
/*     */     try {
/* 201 */       this.shippingLabel1Mapper.updateByPrimaryKeySelective(shippingLabel1);
/* 202 */     } catch (Exception e) {
/* 203 */       e.printStackTrace();
/* 204 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 206 */     return AjaxResult.ok();
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\shipping\impl\ShippingLabelServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */