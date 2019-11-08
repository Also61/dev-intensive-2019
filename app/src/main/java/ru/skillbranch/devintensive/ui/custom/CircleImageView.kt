package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import ru.skillbranch.devintensive.R

class CircleImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr:Int = 0) : ImageView(context, attrs, defStyleAttr) {

    companion object{
        private  const val DEFAULT_BORDER_COLOR = R.color.color_white
        private  const val DEFAULT_BORDER_WIDTH = 2
    }

    private var cv_borderColor = DEFAULT_BORDER_COLOR
    private var cv_borderWidth = DEFAULT_BORDER_WIDTH

    init {
        if(attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            cv_borderColor = a.getInt(R.styleable.CircleImageView_cv_bordrerColor, DEFAULT_BORDER_COLOR)
            cv_borderWidth = a.getInt(R.styleable.CircleImageView_cv_borderWidth, DEFAULT_BORDER_WIDTH)
            a.recycle()
        }
    }

    fun getBorderWidth() = cv_borderWidth

    fun setBorderWidth(@Dimension dp:Int){
        TODO()
    }

    fun getBorderColor():Int = cv_borderColor

    fun setBorderColor(hex:String){
        TODO()
    }

    fun setBorderColor(@ColorRes colorId: Int){
        TODO()
    }

    var paint:Paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}