package com.vakrangee.mobilerecharge.MobileRecharge.models;

public class DashBoardModel {
    private String itemName;
    private int item_imgid;

    public DashBoardModel(String itemName, int item_imgid) {
        this.itemName = itemName;
        this.item_imgid = item_imgid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItem_imgid() {
        return item_imgid;
    }

    public void setItem_imgid(int item_imgid) {
        this.item_imgid = item_imgid;
    }
}
