package structural_patterns.adapter

class FahrenheitCelsiusAdapter(farTemp: FahrenheitTemperature) {
    val celsTemp =
            CelsiusTemperature((farTemp.getFahrenheit() - 32) * 5 / 9)
}