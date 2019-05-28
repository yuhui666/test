package com.example.day13_http.json;

public class Bean {


    /**
     * itemid : 625464
     * title : 夹江县鑫品建材有限公司
     * addtime : 1539575912
     * edittime : 1539575912
     * introduce : 夹江县鑫品建材有限公司是一家集花型图案开发、专业生产、营销为一体的现代化厂家。本厂采用意大利先进技术生产高级水晶抛晶砖、
     * thumb : http://d.yunzhancn.cn/file/upload/201810/15/1158284178703.png.thumb.png
     * address : 北京
     * homepage :
     * areaid : 1
     * comment : 0
     */

    private String itemid;
    private String title;
    private String addtime;
    private String edittime;
    private String introduce;
    private String thumb;
    private String address;
    private String homepage;
    private String areaid;
    private int comment;

    public Bean(String itemid, String title, String addtime, String edittime, String introduce, String thumb, String address, String homepage, String areaid, int comment) {
        this.itemid = itemid;
        this.title = title;
        this.addtime = addtime;
        this.edittime = edittime;
        this.introduce = introduce;
        this.thumb = thumb;
        this.address = address;
        this.homepage = homepage;
        this.areaid = areaid;
        this.comment = comment;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getEdittime() {
        return edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "itemid='" + itemid + '\'' +
                ", title='" + title + '\'' +
                ", addtime='" + addtime + '\'' +
                ", edittime='" + edittime + '\'' +
                ", introduce='" + introduce + '\'' +
                ", thumb='" + thumb + '\'' +
                ", address='" + address + '\'' +
                ", homepage='" + homepage + '\'' +
                ", areaid='" + areaid + '\'' +
                ", comment=" + comment +
                '}';
    }
}
