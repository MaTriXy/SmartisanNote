package me.drakeet.smartisannote.api

import android.view.View
import me.drakeet.smartisannote.model.Note

/**
 * Created by drakeet on 7/26/15.
 */
public interface OnNoteTouchListener {
    public fun onTouch(view: View, note: Note)
}