package jp.ac.titech.itpro.sdl.hilbert

import kotlin.math.cos
import kotlin.math.sin

open class Turtle(private val drawer: Drawer) {
    fun interface Drawer {
        fun drawLine(x0: Double, y0: Double, x1: Double, y1: Double)
    }

    private var x = 0.0
    private var y = 0.0
    private var dir = 0.0
    fun setPos(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    fun setDir(dir: Double) {
        this.dir = dir
    }

    fun forward(step: Double) {
        val x1 = x + sin(dir) * step
        val y1 = y - cos(dir) * step
        drawer.drawLine(x, y, x1, y1)
        x = x1
        y = y1
    }

    fun rotate(th: Double) {
        dir = (dir + th + Math.PI * 2) % (Math.PI * 2)
    }

    companion object {
        const val R = Math.PI / 2
        const val L = -R
        const val N = 0.0
        const val E = Math.PI / 2
        const val S = Math.PI
        const val W = E + S
    }
}