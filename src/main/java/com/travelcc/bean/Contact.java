package com.travelcc.bean;

/**
 * 联系人信息
 */
public class Contact {
    /**
     *  Required 联系人主要信息，如果是姓名则不区分姓名格式，如果是公司则可以在内容中穿插空格，但不要在整行的首尾添加空格
     */
    private String name;
    /**
     * 	Required 详细地址
     */
    private String address;
    /**
     * Required		邮编
     */
    private String postcode;
    /**
     * 	Required	联系人邮箱
     */
    private String email;
    /**
     * 	Required 联系人手机号，接口方提供固定手机号，不使用用户手机号
     */
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
