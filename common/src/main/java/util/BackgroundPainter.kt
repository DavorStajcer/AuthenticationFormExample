package util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.common.R

class BacgroundLayout : ConstraintLayout{

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet : AttributeSet?) : super(context,attributeSet)
    constructor(context: Context, attributeSet : AttributeSet?,defStyleAttribute : Int) : super(context,attributeSet,defStyleAttribute)

    private val paint = Paint().apply {
        color = ContextCompat.getColor(context,R.color.primary)

    }
    private val path : Path = Path()


    override fun onDraw(canvas: Canvas?) {
        path.apply {
            lineTo(50f,0f)
            lineTo(0f,30f)
            close()
        }
        canvas?.drawPath(path,paint)
        super.onDraw(canvas)
    }

}