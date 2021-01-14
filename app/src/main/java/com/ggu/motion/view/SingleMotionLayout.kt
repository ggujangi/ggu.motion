package com.ggu.motion.view

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.ggu.motion.R

class SingleMotionLayout(context: Context, attrs: AttributeSet) : MotionLayout(context, attrs) {

    private var viewToTouch: View? = null
    private var viewToTouchRes = -1

    private val viewRect = Rect()
    private var touchStarted = false


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (viewToTouchRes != -1) viewToTouch = (parent as View).findViewById(viewToTouchRes)
    }

    init {
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.SingleMotionLayout, 0, 0)

        try {
            viewToTouchRes = a.getResourceId(R.styleable.SingleMotionLayout_viewToTouch, -1)
        } finally {
            a.recycle()
        }

        setTransitionListener(object : TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                touchStarted = false
            }

        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                touchStarted = false
                return super.onTouchEvent(event)
            }
        }

        if (!touchStarted) {
            viewToTouch?.getHitRect(viewRect)
            touchStarted = viewRect.contains(event.x.toInt(), event.y.toInt())
        }

        return super.onTouchEvent(event) && touchStarted
    }
}