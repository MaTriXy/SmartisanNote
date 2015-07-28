package me.drakeet.smartisannote

import me.drakeet.smartisannote.model.Note
import java.util.*

/**
 * Created by drakeet on 7/28/15.
 */
public object Preset {

    public fun getTips(): ArrayList<Note>? {
        var list = ArrayList<Note>()
        list.add(Note("title0", "detail0", "modifyTime", false, true))
        list.add(Note("title1", "detail1", "modifyTime", false, true))
        list.add(Note("title2", "detail2", "modifyTime", false, true))
        list.add(Note("title3", "detail3", "modifyTime", false, true))
        list.add(Note("title4", "detail4", "modifyTime", false, true))
        return list
    }

}