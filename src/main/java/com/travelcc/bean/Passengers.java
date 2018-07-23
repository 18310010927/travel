package com.travelcc.bean;
/**
 * 乘机人信息
 */
public class Passengers {
    /**
     * Required	英文名按"LastName/FirstName/MiddleName"，中文名按"姓/名"（中间名部分可省略）
     */
    private String name;
    /**
     * Required	乘客类型，0 成人/1 儿童
     */
    private Integer ageType;
    /**
     * Required 生日，格式：YYYYMMDD
     */
    private  String birthday;
    /**
     *  Required 乘客性别，M 男 / F 女
     */
    private String gender;
    /**
     * 	证件号码，最大 15 个字符
     */
    private String cardNum;
    /**
     *  Required 证件类型：PP - 护照 / GA – 港澳通行证（仅内地与香港通航航段适用）
     */
    private String cardType;
    /**
     * Required	证件发行国家，国家二字码
     */
    private String cardIssuePlace;
    /**
     * Required	证件有效时间，格式：YYYYMMDD
     */
    private String cardExpired;
    /**
     * 	Required	乘客国籍，国家二字码
     */
    private String nationality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAgeType() {
        return ageType;
    }

    public void setAgeType(Integer ageType) {
        this.ageType = ageType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardIssuePlace() {
        return cardIssuePlace;
    }

    public void setCardIssuePlace(String cardIssuePlace) {
        this.cardIssuePlace = cardIssuePlace;
    }

    public String getCardExpired() {
        return cardExpired;
    }

    public void setCardExpired(String cardExpired) {
        this.cardExpired = cardExpired;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "name='" + name + '\'' +
                ", ageType=" + ageType +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardIssuePlace='" + cardIssuePlace + '\'' +
                ", cardExpired='" + cardExpired + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
