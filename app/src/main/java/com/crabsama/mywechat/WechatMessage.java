package com.crabsama.mywechat;


/**
 * 微信消息的实体类，定义好其包含的属性，设定好getter方法
 */
public class WechatMessage {

    private String wechatName;
    private String wechatMessage;
    private String messageTime;
    private int imageID;

    public WechatMessage(String wechatName, String wechatMessage, String messageTime, int imageID) {
        this.wechatName = wechatName;
        this.wechatMessage = wechatMessage;
        this.messageTime = messageTime;
        this.imageID = imageID;
    }

    public String getWechatName() {

        return wechatName;
    }

    public String getWechatMessage() {
        return wechatMessage;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public int getImageID() {
        return imageID;
    }
}

