package com.vakrangee.mobilerecharge.fastag.models;

public class PreviousFasTagRechargeModel {
    public int img;
    public String bankName;
    public String bankNumber;
    public String balance;
    public PreviousFasTagRechargeModel(int img, String bankName, String bankNumber, String balance){
        this.img = img;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.balance = balance;
    }

    public int getImg() {
        return img;
    }

    public String getBalance() {
        return balance;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }
}
