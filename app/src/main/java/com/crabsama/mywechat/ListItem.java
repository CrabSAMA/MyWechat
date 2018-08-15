package com.crabsama.mywechat;


/**
 * 通讯录中的Item的实体类，设定好对应的属性，设定好获取getter方法
 */
public class ListItem {

    private String listName;
    private int imageId;

    public ListItem(String listName, int imageId) {
        this.listName = listName;
        this.imageId = imageId;
    }

    public String getListName() {
        return listName;
    }

    public int getImageId() {
        return imageId;
    }
}
