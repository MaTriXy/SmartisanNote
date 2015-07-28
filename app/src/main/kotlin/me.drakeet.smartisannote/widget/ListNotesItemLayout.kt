package me.drakeet.smartisannote.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import me.drakeet.smartisannote.R
import me.drakeet.smartisannote.model.Note

/**
 * Created by drakeet on 7/26/15.
 */
public class ListNotesItemLayout(private val mContext: Context, attrs: AttributeSet) :
        RelativeLayout(mContext, attrs) {

    private var mDetailLinearLayout: LinearLayout? = null
    private var mAgoTextView: TextView? = null
    private var mTimeTextView: TextView? = null
    private var mCardView: View? = null
    private var mSummaryTextView: TextView? = null
    private var mNotesThumbPics: ImageView? = null
    private var mFavImageView: ImageView? = null
    private var mClipImageView: ImageView? = null
    private var mDeleteTextView: TextView? = null

    var mNote: Note? = null

    fun setNote(note: Note) {
        mNote = note
        //todo
        mSummaryTextView?.setText(mNote?.getTitle())
        mTimeTextView?.setText(mNote?.getModifyTime())
    }

    fun getNote() : Note? {
        return mNote
    }

    public fun open() {
        mDeleteTextView?.setVisibility(View.VISIBLE)
        mClipImageView?.setBackgroundResource(R.drawable.note_item_clip_up)
        mDetailLinearLayout?.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                close()
                return true
            }
        })
    }

    public fun close() {
        mDeleteTextView?.setVisibility(View.GONE)
        mClipImageView?.setBackgroundResource(R.drawable.note_item_clip_normal)
        mDetailLinearLayout?.setOnTouchListener(null)
    }

    override protected fun onFinishInflate() {
        super.onFinishInflate()
        mDetailLinearLayout = findViewById(R.id.linearlayout_detail) as LinearLayout
        mAgoTextView = findViewById(R.id.textview_ago) as TextView
        mTimeTextView = findViewById(R.id.textview_time) as TextView
        mCardView = findViewById(R.id.list_item_background_layout)
        mSummaryTextView = findViewById(R.id.textview_summary) as TextView
        mNotesThumbPics = findViewById(R.id.notesThumbPics) as ImageView
        mFavImageView = findViewById(R.id.imageview_fav) as ImageView
        mClipImageView = findViewById(R.id.imageview_clip) as ImageView
        mDeleteTextView = findViewById(R.id.button_delete) as TextView
    }
}