package com.vakrangee.mobilerecharge.fastag.models;

public class BankListModel {
    public int img;
    public String bankName;

    public BankListModel(int img, String bankName){
        this.img = img;
        this.bankName = bankName;

    }

    public int getImg() {
        return img;
    }

    public String getBankName() {
        return bankName;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
