package behavioral_patterns.observer

class EventManager {
    enum class Event {
        TEXT_CHANGED,
        TO_EMPTY
    }

    val log = mutableListOf<String>()
    private val listeners = HashMap<Event, MutableSet<Listener>>()

    fun subscribe(event: Event, listener: Listener) {
        listeners.getOrPut(event) { mutableSetOf() }.add(listener)
    }

    fun unSubscribe(event: Event, listener: Listener) {
        listeners[event]?.remove(listener)
    }

    fun notify(event: Event, data: String) {
        listeners[event]?.forEach { log.add(it.update(data)) }
    }
}