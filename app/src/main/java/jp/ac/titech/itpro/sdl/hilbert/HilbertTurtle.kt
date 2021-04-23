package jp.ac.titech.itpro.sdl.hilbert

class HilbertTurtle(drawer: Drawer) : Turtle(drawer) {
    fun draw(order: Int, step: Double, turn: Double) {
        if (order > 0) {
            rotate(-turn)
            draw(order - 1, step, -turn)
            forward(step)
            rotate(turn)
            draw(order - 1, step, turn)
            forward(step)
            draw(order - 1, step, turn)
            rotate(turn)
            forward(step)
            draw(order - 1, step, -turn)
            rotate(-turn)
        }
    }
}