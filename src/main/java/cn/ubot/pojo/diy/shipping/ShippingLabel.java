package cn.ubot.pojo.diy.shipping;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class ShippingLabel {
	private Integer id;
	private String shipLot;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date shipDate;
	private Integer cartons;
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	private String updateBy;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;
	private Integer qty;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShipLot() {
		return this.shipLot;
	}

	public void setShipLot(String shipLot) {
		this.shipLot = shipLot;
	}

	public Date getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Integer getCartons() {
		return this.cartons;
	}

	public void setCartons(Integer cartons) {
		this.cartons = cartons;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getQty() {
		return this.qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
