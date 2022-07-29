package com.vakrangee.mobilerecharge.MobileRecharge.models;

import java.util.List;

public class Data {

    List<Option_List> list;

    public List<Option_List> getList() {
        return list;
    }

    public void setList(List<Option_List> list) {
        this.list = list;
    }

    public static class Option_List{

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }

        public Boolean getSelected() {
            return isSelected;
        }

        public void setSelected(Boolean selected) {
            isSelected = selected;
        }

        public List<Option> getOptionList() {
            return optionList;
        }

        public void setOptionList(List<Option> optionList) {
            this.optionList = optionList;
        }

        int icon;
        String option;
        Boolean isSelected;
        List<Option>  optionList;

    }

    public static class Option{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPay() {
            return pay;
        }

        public void setPay(String pay) {
            this.pay = pay;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        String name,pay,id;
    }

}
