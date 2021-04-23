package jp.ac.titech.itpro.sdl.hilbert

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class HilbertView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {
    private val paint = Paint()
    private var canvas: Canvas? = null
    private var order = 1
    private val turtle = HilbertTurtle { x0, y0, x1, y1 -> canvas!!.drawLine(x0.toFloat(), y0.toFloat(), x1.toFloat(), y1.toFloat(), paint) }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas
        val w = canvas.width
        val h = canvas.height
        paint.color = Color.DKGRAY
        canvas.drawRect(0f, 0f, w.toFloat(), h.toFloat(), paint)
        paint.color = Color.WHITE
        paint.strokeWidth = 3f
        val size = w.coerceAtMost(h)
        val step = size.toDouble() / (1 shl order)
        turtle.setPos((w - size + step) / 2, (h + size - step) / 2)
        turtle.setDir(Turtle.Companion.E)
        turtle.draw(order, step, Turtle.Companion.R)
    }

    fun setOrder(n: Int) {
        order = n
        invalidate()
    }
}