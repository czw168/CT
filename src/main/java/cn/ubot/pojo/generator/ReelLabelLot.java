package cn.ubot.pojo.generator;

public class ReelLabelLot {
    private Long id;

    private String ltc;

    private String lotNo;

    private String machine;

    private String productionDate;

    private String lane;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLtc() {
        return ltc;
    }

    public void setLtc(String ltc) {
        this.ltc = ltc == null ? null : ltc.trim();
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo == null ? null : lotNo.trim();
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate == null ? null : productionDate.trim();
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane == null ? null : lane.trim();
    }
}