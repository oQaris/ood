package behavioral_patterns.command

interface OrderCommand {
    fun execute(): String
}

data class AddOrderCommand(private val id: Long) : OrderCommand {
    override fun execute() = "Добавление заказа $id"
}

data class PayOrderCommand(private val id: Long) : OrderCommand {
    override fun execute() = "Оплата заказа $id"
}

class OrderCommandProcessor {
    val queue = ArrayDeque<OrderCommand>()
    var result = String()

    fun addToQueue(orderCommand: OrderCommand): OrderCommandProcessor = apply {
        queue.add(orderCommand)
    }

    fun processCommands(): OrderCommandProcessor = apply {
        queue.forEach {
            result += it.execute() + " "
        }
        queue.clear()
    }
}