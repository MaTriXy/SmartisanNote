package me.drakeet.smartisannote.model;

import org.litepal.crud.DataSupport;

/**
 * Created by drakeet on 7/25/15.
 */
public class Note extends DataSupport {

    String title;
    String detail;
    String thumbPic;
    String modifyTime;
    String location;
    String weather;
    boolean favorite;
    boolean dirty;
    boolean deleted;
    boolean markdown;
    boolean presetTip;
    int position;

    public Note() {
    }

    public Note(String title, String detail, String modifyTime, boolean favorite,
                boolean presetTip) {
        this.title = title;
        this.detail = detail;
        this.modifyTime = modifyTime;
        this.favorite = favorite;
        this.presetTip = presetTip;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbPic() {
        return thumbPic;
    }

    public void setThumbPic(String thumbPic) {
        this.thumbPic = thumbPic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isMarkdown() {
        return markdown;
    }

    public void setMarkdown(boolean markdown) {
        this.markdown = markdown;
    }

    public boolean isPresetTip() {
        return presetTip;
    }

    public void setPresetTip(boolean presetTip) {
        this.presetTip = presetTip;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
