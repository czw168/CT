package cn.ubot.service.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.product.ProductInfoMapper_;
import cn.ubot.mapper.generator.ProductInfoMapper;
import cn.ubot.pojo.generator.ProductInfo;
import cn.ubot.pojo.generator.ProductInfoExample;
import cn.ubot.service.product.ProductService;
import cn.ubot.utils.ExceptionUtils;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductInfoMapper_ productInfoMapper_;
	@Autowired
	private ProductInfoMapper productInfoMapper;

	public EUDataGridResult listProduct(Integer page, Integer rows) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		ProductInfoExample example = new ProductInfoExample();
		List<ProductInfo> productList = this.productInfoMapper.selectByExampleWithBLOBs(example);
		result.setRows(productList);
		PageInfo<ProductInfo> pageInfo = new PageInfo<ProductInfo>(productList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addProduct(ProductInfo productInfo) {
		try {
			productInfo.setStatus(Integer.valueOf(1));
			this.productInfoMapper.insert(productInfo);
		} catch (Exception e) {
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateProduct(ProductInfo productInfo) {
		try {
			this.productInfoMapper.updateByPrimaryKey(productInfo);
		} catch (Exception e) {
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public List<EUComboBoxResult> getProductPn() {
		List<EUComboBoxResult> l = new ArrayList<EUComboBoxResult>();
		ProductInfoExample example = new ProductInfoExample();
		List<ProductInfo> productInfoList = this.productInfoMapper.selectByExample(example);
		for (ProductInfo productInfo : productInfoList) {
			if (productInfo.getStatus().intValue() == 1) {
				EUComboBoxResult eur2 = new EUComboBoxResult(productInfo.getPn(), productInfo.getPn(), null);
				l.add(eur2);
			}
		}
		return l;
	}

	public List<EUDataGridComboBoxResult> getProductPn_() {
		List<EUDataGridComboBoxResult> l = new ArrayList<EUDataGridComboBoxResult>();
		ProductInfoExample example = new ProductInfoExample();
		List<ProductInfo> productInfoList = this.productInfoMapper.selectByExample(example);
		for (ProductInfo productInfo : productInfoList) {
			if (productInfo.getStatus().intValue() == 1) {
				EUDataGridComboBoxResult eur2 = new EUDataGridComboBoxResult(productInfo.getPn(), productInfo.getPn());
				l.add(eur2);
			}
		}
		return l;
	}

	public AjaxResult getRequirementByPn(String pn) {
		return AjaxResult.ok(this.productInfoMapper_.getRequirementByPn(pn));
	}

	public AjaxResult getDwgNoByPn(String pn) {
		ProductInfoExample example = new ProductInfoExample();
		ProductInfoExample.Criteria criteria = example.createCriteria();
		criteria.andPnEqualTo(pn);
		List<ProductInfo> productInfoList = this.productInfoMapper.selectByExample(example);
		return AjaxResult.ok(((ProductInfo) productInfoList.get(0)).getDwgNo());
	}
}
