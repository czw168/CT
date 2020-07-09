package cn.ubot.pojo.generator;

public class ProductInfo {
    private Long id;

    private String pn;

    private String dwgNo;

    private String length;

    private String a0;

    private String b0;

    private String k0;

    private Integer status;

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

    public String getDwgNo() {
        return dwgNo;
    }

    public void setDwgNo(String dwgNo) {
        this.dwgNo = dwgNo == null ? null : dwgNo.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getA0() {
        return a0;
    }

    public void setA0(String a0) {
        this.a0 = a0 == null ? null : a0.trim();
    }

    public String getB0() {
        return b0;
    }

    public void setB0(String b0) {
        this.b0 = b0 == null ? null : b0.trim();
    }

    public String getK0() {
        return k0;
    }

    public void setK0(String k0) {
        this.k0 = k0 == null ? null : k0.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }
}