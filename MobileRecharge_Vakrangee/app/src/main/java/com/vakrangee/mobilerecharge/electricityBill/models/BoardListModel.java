package com.vakrangee.mobilerecharge.electricityBill.models;

public class BoardListModel {
    public String boardName;
    public int img;
    public BoardListModel(){

    }
    public BoardListModel(String boardName, int img) {
        this.boardName = boardName;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
