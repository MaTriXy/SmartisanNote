package me.drakeet.smartisannote

import me.drakeet.smartisannote.model.Note
import java.util.ArrayList

/**
 * Created by drakeet on 7/28/15.
 */
public object Preset {

    public fun getTips(): ArrayList<Note>? {
        var list = ArrayList<Note>()
        list.add(Note("这", "Preset0", "昨天 15:05 7月28日", favorite = false, presetTip = true))
        list.add(Note("是一", "Preset1", "昨天 15:05 7月28日", favorite = false, presetTip = true))
        list.add(Note("个开源", "Preset2", "昨天 15:05 7月28日", favorite = false, presetTip = true))
        list.add(Note("版的锤子", "Preset3", "昨天 15:05 7月28日", favorite = false, presetTip = true))
        list.add(Note("便签蛤蛤蛤", "Preset4", "昨天 15:05 7月28日", favorite = false, presetTip = true))
        return list
    }

}