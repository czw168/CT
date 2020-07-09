package cn.ubot.pojo.generator;

public class CustomerPn {
    private Long id;

    private String pn;

    private String customerName;

    private String customerPn;

    private String requirement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPn() {
        return customerPn;
    }

    public void setCustomerPn(String customerPn) {
        this.customerPn = customerPn == null ? null : customerPn.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }
}