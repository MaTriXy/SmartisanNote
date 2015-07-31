package me.drakeet.smartisannote.widget

import android.content.Context
import android.support.v4.widget.ViewDragHelper
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import me.drakeet.smartisannote.R
import me.drakeet.smartisannote.model.Note

/**
 * Created by drakeet on 7/26/15.
 */
public class ListNotesItemLayout : RelativeLayout {

    private var mDetailLinearLayout: LinearLayout? = null
    private var mAgoTextView: TextView? = null
    private var mTimeTextView: TextView? = null
    private var mCardView: View? = null
    private var mSummaryTextView: TextView? = null
    private var mNotesThumbPics: ImageView? = null
    private var mFavImageView: ImageView? = null
    private var mClipImageView: ImageView? = null
    private var mDeleteTextView: TextView? = null

    private var mNote: Note? = null
    private var mDragHelper: ViewDragHelper? = null

    public constructor(context: Context) : super(context) {
        init()
    }

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    public constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    public constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    public fun init() {
        mDragHelper = ViewDragHelper.create(this, 1.0f, object : ViewDragHelper.Callback() {
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return child == mDetailLinearLayout
            }

            override public fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                val newLeft = Math.min(getResources()
                        .getDimensionPixelSize(R.dimen.item_drag_to_show_delete_button_left), Math.max(left, 0)) //TODO
                return newLeft
            }

            override public fun getViewHorizontalDragRange(child: View): Int {
                return getResources().getDimensionPixelSize(R.dimen.item_drag_to_show_delete_button_left)
            }
        })
    }

    override public fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return mDragHelper!!.shouldInterceptTouchEvent(ev)
    }

    override public fun onTouchEvent(event: MotionEvent): Boolean {
        mDragHelper!!.processTouchEvent(event)
        return true
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

        mDetailLinearLayout?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

            }
        })
    }

    fun setNote(note: Note) {
        mNote = note
        //todo
        mSummaryTextView?.setText(mNote?.title)
        mTimeTextView?.setText(mNote?.modifyTime)
    }

    fun getNote(): Note? {
        return mNote
    }
}