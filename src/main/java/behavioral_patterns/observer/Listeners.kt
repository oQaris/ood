package behavioral_patterns.observer

import kotlin.properties.Delegates

interface Listener {
    fun update(data: String): String
}

class TextChangeListener : Listener {
    override fun update(data: String) = "Текст изменился на: $data"
}

class TextChangeOnEmptyListener : Listener {
    override fun update(data: String) = "Текст \"$data\" изменился на пустой"
}

class ObservableObject {
    val eventManager = EventManager()

    var text: String by Delegates.observable("") { _, old, new ->
        run {
            if (new == "")
                eventManager.notify(EventManager.Event.TO_EMPTY, old)
            else
                eventManager.notify(EventManager.Event.TEXT_CHANGED, new)
        }
    }
}