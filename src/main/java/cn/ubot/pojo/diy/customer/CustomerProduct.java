package cn.ubot.pojo.diy.customer;

public class CustomerProduct {
	private Long id;
	private String pn;
	private String customerName;
	private String customerPn;
	private String requirement;
	private Integer status;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPn() {
		return this.pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPn() {
		return this.customerPn;
	}

	public void setCustomerPn(String customerPn) {
		this.customerPn = customerPn;
	}

	public String getRequirement() {
		return this.requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
