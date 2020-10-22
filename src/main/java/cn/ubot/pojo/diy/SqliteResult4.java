package cn.ubot.pojo.diy;

/**
 *  report-list4.jsp 的数据返回对象
 * @author victor_chen
 *
 */
public class SqliteResult4 {
	private String lotNo;
	// OK数
	private Integer actualOkCount;
	// NG - A组
	private Integer a = 0; 
	// NG - B组
	private Integer c1 = 0;
	private Integer c2 = 0;
	private Integer s1 = 0;
	private Integer s2 = 0;
	private Integer s3 = 0;
	private Integer s4 = 0;
	private Integer s5 = 0;
	// NG - C组
	private Integer sf1 = 0;
	private Integer sf2 = 0;
	private Integer sf3 = 0;
	private Integer sf4 = 0;
	private Integer ed1 = 0;
	private Integer ed2 = 0;
	private Integer ch1 = 0;
	private Integer ch2 = 0;
	private Integer sh1 = 0;
	private Integer sh2 = 0;
	// NG数
	private Integer actualNgCount;
	
	private String result;

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

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getC1() {
		return c1;
	}

	public void setC1(Integer c1) {
		this.c1 = c1;
	}

	public Integer getC2() {
		return c2;
	}

	public void setC2(Integer c2) {
		this.c2 = c2;
	}

	public Integer getS1() {
		return s1;
	}

	public void setS1(Integer s1) {
		this.s1 = s1;
	}

	public Integer getS2() {
		return s2;
	}

	public void setS2(Integer s2) {
		this.s2 = s2;
	}

	public Integer getS3() {
		return s3;
	}

	public void setS3(Integer s3) {
		this.s3 = s3;
	}

	public Integer getS4() {
		return s4;
	}

	public void setS4(Integer s4) {
		this.s4 = s4;
	}

	public Integer getS5() {
		return s5;
	}

	public void setS5(Integer s5) {
		this.s5 = s5;
	}

	public Integer getSf1() {
		return sf1;
	}

	public void setSf1(Integer sf1) {
		this.sf1 = sf1;
	}

	public Integer getSf2() {
		return sf2;
	}

	public void setSf2(Integer sf2) {
		this.sf2 = sf2;
	}

	public Integer getSf3() {
		return sf3;
	}

	public void setSf3(Integer sf3) {
		this.sf3 = sf3;
	}

	public Integer getSf4() {
		return sf4;
	}

	public void setSf4(Integer sf4) {
		this.sf4 = sf4;
	}

	public Integer getEd1() {
		return ed1;
	}

	public void setEd1(Integer ed1) {
		this.ed1 = ed1;
	}

	public Integer getEd2() {
		return ed2;
	}

	public void setEd2(Integer ed2) {
		this.ed2 = ed2;
	}

	public Integer getCh1() {
		return ch1;
	}

	public void setCh1(Integer ch1) {
		this.ch1 = ch1;
	}

	public Integer getCh2() {
		return ch2;
	}

	public void setCh2(Integer ch2) {
		this.ch2 = ch2;
	}

	public Integer getSh1() {
		return sh1;
	}

	public void setSh1(Integer sh1) {
		this.sh1 = sh1;
	}

	public Integer getSh2() {
		return sh2;
	}

	public void setSh2(Integer sh2) {
		this.sh2 = sh2;
	}

	public Integer getActualNgCount() {
		return actualNgCount;
	}

	public void setActualNgCount(Integer actualNgCount) {
		this.actualNgCount = actualNgCount;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "SqliteResult4 [lotNo=" + lotNo + ", actualOkCount=" + actualOkCount + ", a=" + a + ", c1=" + c1
				+ ", c2=" + c2 + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", s4=" + s4 + ", s5=" + s5 + ", sf1="
				+ sf1 + ", sf2=" + sf2 + ", sf3=" + sf3 + ", sf4=" + sf4 + ", ed1=" + ed1 + ", ed2=" + ed2 + ", ch1="
				+ ch1 + ", ch2=" + ch2 + ", sh1=" + sh1 + ", sh2=" + sh2 + ", actualNgCount=" + actualNgCount
				+ ", result=" + result + "]";
	}

	
	
	
}
