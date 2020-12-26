package behavioral_patterns.mediator

val log = mutableListOf<String>()

class Flight(private val atcMediator: IAirportMediator) {
    fun land() {
        log.add(
            if (atcMediator.isLandingOk(this)) "Посадка выполнена"
            else "Жду разрешения на посадку"
        )
    }
}

class Runway(private val atcMediator: IAirportMediator) {
    fun free() {
        log.add("Получено разрешение на посадку")
        atcMediator.notify(this)
    }
}

interface IAirportMediator {
    fun registerRunway(runway: Runway)
    fun registerFlight(flight: Flight)
    fun notify(runway: Runway)
    fun isLandingOk(flight: Flight): Boolean
}

class AirportMediator : IAirportMediator {
    private var flights = linkedMapOf<Flight, Boolean>()
    private var runways = mutableListOf<Runway>()


    override fun registerRunway(runway: Runway) {
        this.runways.add(runway)
    }

    override fun registerFlight(flight: Flight) {
        this.flights[flight] = false
    }

    override fun notify(runway: Runway) {
        // первый в списке непреземлившийся самолёт может приземлиться
        for ((k, _) in flights)
            if (flights[k] == false) {
                flights[k] = true
                break
            }
    }

    override fun isLandingOk(flight: Flight) = flights[flight] ?: false
}