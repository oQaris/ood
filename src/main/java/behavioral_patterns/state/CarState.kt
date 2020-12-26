package behavioral_patterns.state

interface ICarState {
    fun start(c: Car)
    fun stop(c: Car)
    fun speed(c: Car, speed: Int)
}

class Car {
    var state: ICarState = MotorStoppedState()
    var motorWorks: Boolean = false
    var speed: Int = 0

    fun startMotor() {
        state.start(this)
    }

    fun stopMotor() {
        state.stop(this)
    }

    fun changeSpeed(speed: Int) {
        state.speed(this, speed)
    }
}

class MotorStoppedState : ICarState {
    // Синглтон, чтоб каждый раз не создавать новый объект
    companion object {
        val instance = MotorStoppedState()
    }

    override fun start(c: Car) {
        c.motorWorks = true
        c.state = MotorWorksState.instance
    }

    override fun stop(c: Car) {
        throw UnsupportedOperationException("Двигатель уже остановлен!")
    }

    override fun speed(c: Car, speed: Int) {
        throw UnsupportedOperationException("Нельзя изменить скорость, когда двигатель остановлен!")
    }
}

class MotorWorksState : ICarState {
    companion object {
        val instance = MotorWorksState()
    }

    override fun start(c: Car) {
        throw UnsupportedOperationException("Двигатель уже запущен!")
    }

    override fun stop(c: Car) {
        // Запрещаем остановку двигателя, если скорость не равно 0 (автомобиль ещё движется)
        if (c.speed == 0) {
            c.motorWorks = true
            c.state = MotorStoppedState.instance
        } else
            throw UnsupportedOperationException("Прежде чем остановить двигатель уменьшите скорость до 0!")
    }

    override fun speed(c: Car, speed: Int) {
        if (speed >= 0)
            c.speed = speed
        else
            throw UnsupportedOperationException("Значение скорости не может быть отрицательным!")
    }
}