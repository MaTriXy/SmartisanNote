package me.drakeet.smartisannote.widget

import android.content.Context
import android.graphics.Point
import android.support.v4.widget.ViewDragHelper
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
    private val mAutoBackOriginPos = Point()
    private val mAutoFullShowPos = Point()

    private var mDragDistence: Int = 0
    private var mIsOpen = false

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
        mDragDistence = getResources().getDimensionPixelSize(R.dimen.item_drag_to_show_delete_button_left)
        mDragHelper = ViewDragHelper.create(this, 2.0f, object : ViewDragHelper.Callback() {
            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
                return child == mDetailLinearLayout
            }

            override public fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
                val newLeft = Math.min(mDragDistence, Math.max(left, 0)) //TODO
                return newLeft
            }

            override public fun getViewHorizontalDragRange(child: View): Int {
                return mDragDistence
            }

            override public fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
                if (releasedChild === mDetailLinearLayout) {
                    if (xvel > mDragDistence / 3) {
                        mDragHelper!!.settleCapturedViewAt(mAutoFullShowPos.x, mAutoFullShowPos.y)
                    } else {
                        mDragHelper!!.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y)
                        close()
                    }
                    invalidate()
                }
            }

            override fun onViewPositionChanged(changedView: View?, left: Int, top: Int, dx: Int, dy: Int) {
                if (left > 0) open() else close()
            }
        })
    }

    override public fun computeScroll() {
        if (mDragHelper!!.continueSettling(true)) {
            invalidate()
        }
    }

    override public fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return mDragHelper!!.shouldInterceptTouchEvent(ev)
    }

    override public fun onTouchEvent(event: MotionEvent): Boolean {
        mDragHelper!!.processTouchEvent(event)
        return true
    }

    public fun open() {
        if (mIsOpen) return
        mDeleteTextView?.setVisibility(View.VISIBLE)
        mClipImageView!!.setBackgroundResource(R.drawable.note_item_clip_up)
        mDetailLinearLayout?.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                return true
            }
        })
        mIsOpen = true
    }

    public fun close() {
        if (!mIsOpen) return
        mDeleteTextView?.setVisibility(View.GONE)
        mClipImageView!!.setBackgroundResource(R.drawable.note_item_clip_normal)
        mDetailLinearLayout?.setOnTouchListener(null)
        mIsOpen = false
    }

    override protected fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)

        mAutoBackOriginPos.x = mDetailLinearLayout!!.getLeft()
        mAutoBackOriginPos.y = mDetailLinearLayout!!.getTop()
        mAutoFullShowPos.x = mDragDistence
        mAutoFullShowPos.y = mDetailLinearLayout!!.getTop()
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