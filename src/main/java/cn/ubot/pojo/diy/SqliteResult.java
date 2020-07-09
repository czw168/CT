package cn.ubot.pojo.diy;

public class SqliteResult {
	private String lotNo;
	private Integer actualOkCount;
	private Double okAvg;
	private Double okMax;
	private Double okMin;
	private Integer actualNgCount;
	private Double ngAvg;
	private Double ngMax;
	private Double ngMin;
	
	public String getLotNo() {
		return lotNo;
	}
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	public Integer getActualOkCount() {
		return actualOkCount;
	}
	public void setActualOkCount(Integer actualOkCount) {
		this.actualOkCount = actualOkCount;
	}
	public Double getOkAvg() {
		return okAvg;
	}
	public void setOkAvg(Double okAvg) {
		this.okAvg = okAvg;
	}
	public Double getOkMax() {
		return okMax;
	}
	public void setOkMax(Double okMax) {
		this.okMax = okMax;
	}
	public Double getOkMin() {
		return okMin;
	}
	public void setOkMin(Double okMin) {
		this.okMin = okMin;
	}
	public Integer getActualNgCount() {
		return actualNgCount;
	}
	public void setActualNgCount(Integer actualNgCount) {
		this.actualNgCount = actualNgCount;
	}
	public Double getNgAvg() {
		return ngAvg;
	}
	public void setNgAvg(Double ngAvg) {
		this.ngAvg = ngAvg;
	}
	public Double getNgMax() {
		return ngMax;
	}
	public void setNgMax(Double ngMax) {
		this.ngMax = ngMax;
	}
	public Double getNgMin() {
		return ngMin;
	}
	public void setNgMin(Double ngMin) {
		this.ngMin = ngMin;
	}
	public SqliteResult(String lotNo, Integer actualOkCount, Double okAvg, Double okMax, Double okMin,
			Integer actualNgCount, Double ngAvg, Double ngMax, Double ngMin) {
		super();
		this.lotNo = lotNo;
		this.actualOkCount = actualOkCount;
		this.okAvg = okAvg;
		this.okMax = okMax;
		this.okMin = okMin;
		this.actualNgCount = actualNgCount;
		this.ngAvg = ngAvg;
		this.ngMax = ngMax;
		this.ngMin = ngMin;
	}
	public SqliteResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
