package me.drakeet.smartisannote.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import me.drakeet.smartisannote.R
import me.drakeet.smartisannote.api.OnNoteTouchListener
import me.drakeet.smartisannote.model.Note
import me.drakeet.smartisannote.widget.ListNotesItemLayout

/**
 * Created by drakeet on 7/26/15.
 */
public class NoteListAdapter(val mContext: Context, val mList: List<Note>) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    var mOnNoteTouchListener: OnNoteTouchListener? = null
    private val TYPE_SEARCH = 0
    private val TYPE_NOTE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View? = null
        when (viewType) {
            TYPE_SEARCH -> {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_search_view, parent, false)
            }
            TYPE_NOTE -> {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false)
            }
        }
        // 这里的 ViewHolder 的 Type 可能还没初始化，所以得手动传入... 使用 viewHolder.getItemViewType() 可能回出问题
        return ViewHolder(view!!, viewType)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        when (viewHolder.getItemViewType()) {
            TYPE_SEARCH -> {
                // TODO
            }
            TYPE_NOTE -> {
                val notePosition = position - 1
                val note = mList.get(notePosition)
                viewHolder.layoutView!!.setNote(note)
            }
        }
    }

    override public fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_SEARCH else TYPE_NOTE
    }

    override fun getItemCount(): Int {
        return mList.size() + 1
    }

    public fun setOnMeizhiTouchListener(onNoteTouchListener: OnNoteTouchListener) {
        this.mOnNoteTouchListener = onNoteTouchListener
    }

    public inner class ViewHolder(itemView : View, viewType : Int) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var layoutView: ListNotesItemLayout? = null
        var searchView: EditText? = null

        init {
            when (viewType) {
                TYPE_NOTE -> {
                    layoutView = itemView as? ListNotesItemLayout
                }
                TYPE_SEARCH -> {
                    searchView = itemView.findViewById(R.id.edittext_search) as? EditText
                }
            }
        }

        override fun onClick(v: View) {
            throw UnsupportedOperationException()
        }
    }
}
