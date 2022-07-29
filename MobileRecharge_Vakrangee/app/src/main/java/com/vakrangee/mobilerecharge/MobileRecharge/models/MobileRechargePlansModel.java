package com.vakrangee.mobilerecharge.MobileRecharge.models;

public class MobileRechargePlansModel {
    private String plan_price;
    private String plan_title;
    private String plan_validity;

    public MobileRechargePlansModel(String plan_price, String plan_title, String plan_validity) {
        this.plan_price = plan_price;
        this.plan_title = plan_title;
        this.plan_validity = plan_validity;
    }

    public String getPlan_price() {
        return plan_price;
    }

    public void setPlan_price(String plan_price) {
        this.plan_price = plan_price;
    }

    public String getPlan_title() {
        return plan_title;
    }

    public void setPlan_title(String plan_title) {
        this.plan_title = plan_title;
    }

    public String getPlan_validity() {
        return plan_validity;
    }

    public void setPlan_validity(String plan_validity) {
        this.plan_validity = plan_validity;
    }
}
