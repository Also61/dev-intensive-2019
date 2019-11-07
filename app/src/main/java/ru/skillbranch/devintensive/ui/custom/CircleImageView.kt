package ru.skillbranch.devintensive.ui.custom

import android.content.Context
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
        private  const val DEFAULT_BORDER_COLOR = "white"
        private  const val DEFAULT_BORDER_WIDTH = "2dp"
    }

    private var cv_borderColor = DEFAULT_BORDER_COLOR
    private var cv_borderWidth = DEFAULT_BORDER_WIDTH

    init {
        TODO()
    }

    fun getBorderWidth():Int{
        TODO()
    }

    fun setBorderWidth(@Dimension dp:Int){
        TODO()
    }

    fun getBorderColor():Int{
        TODO()
    }

    fun setBorderColor(hex:String){
        TODO()
    }

    fun setBorderColor(@ColorRes colorId: Int){
        TODO()
    }

}