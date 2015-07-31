package me.drakeet.smartisannote.model

import org.litepal.crud.DataSupport

/**
 * Created by drakeet on 7/30/15.
 */
public class Note : DataSupport {

    var title: String? = null
    var detail: String? = null
    var thumbPic: String? = null
    var modifyTime: String? = null
    var location: String? = null
    var weather: String? = null
    var favorite: Boolean? = false
    var dirty: Boolean? = false
    var deleted: Boolean? = false
    var markdown: Boolean? = false
    var presetTip: Boolean? = false
    var position: Int = 0

    public constructor() {
    }

    public constructor(title: String, detail: String, modifyTime: String, favorite: Boolean, presetTip: Boolean) {
        this.title = title
        this.detail = detail
        this.modifyTime = modifyTime
        this.favorite = favorite
        this.presetTip = presetTip
    }

}
