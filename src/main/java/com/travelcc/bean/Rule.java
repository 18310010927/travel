package com.travelcc.bean;

/**
 * 退改签信息
 */
public class Rule {
    /**
     *退票规定，最大 300 个字符
     */
    private String refund;
    /**
     * 改签规定，最大 300 个字符
     */
    private String endorse;
    /**
     * 行李额规定，最大 300 个字符
     */
    private String baggage;
    /**
     * 其他说明，最大 300 个字符
     */
    private String other;

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getEndorse() {
        return endorse;
    }

    public void setEndorse(String endorse) {
        this.endorse = endorse;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "refund='" + refund + '\'' +
                ", endorse='" + endorse + '\'' +
                ", baggage='" + baggage + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
