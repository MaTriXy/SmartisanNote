package me.drakeet.smartisannote

import me.drakeet.smartisannote.model.Note
import java.util.*

/**
 * Created by drakeet on 7/28/15.
 */
public object Preset {

    public fun getTips(): ArrayList<Note>? {
        var list = ArrayList<Note>()
        list.add(Note("这", "Preset0", "今天 15:05 7月28日", false, true))
        list.add(Note("是一", "Preset1", "今天 15:05 7月28日", false, true))
        list.add(Note("个开源", "Preset2", "今天 15:05 7月28日", false, true))
        list.add(Note("版的锤子", "Preset3", "今天 15:05 7月28日", false, true))
        list.add(Note("便签感谢你", "Preset4", "今天 15:05 7月28日", false, true))
        return list
    }

}