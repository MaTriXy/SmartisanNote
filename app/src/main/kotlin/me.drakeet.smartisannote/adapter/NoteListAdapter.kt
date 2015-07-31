package me.drakeet.smartisannote.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.drakeet.smartisannote.R
import me.drakeet.smartisannote.api.OnNoteTouchListener
import me.drakeet.smartisannote.model.Note
import me.drakeet.smartisannote.widget.ListNotesItemLayout

/**
 * Created by drakeet on 7/26/15.
 */
public class NoteListAdapter(val mContext: Context, val mList: List<Note>) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    var mOnNoteTouchListener: OnNoteTouchListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val note = mList.get(position)
        viewHolder.layoutView!!.setNote(note)
    }

    override fun getItemCount(): Int {
        return mList.size()
    }

    public fun setOnMeizhiTouchListener(onNoteTouchListener: OnNoteTouchListener) {
        this.mOnNoteTouchListener = onNoteTouchListener
    }

    public inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var layoutView: ListNotesItemLayout? = null

        init {
            layoutView = itemView as ListNotesItemLayout
        }

        override fun onClick(v: View) {
            throw UnsupportedOperationException()
        }
    }
}
