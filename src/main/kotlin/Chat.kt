data class Message(
    val text: String,
    var read: Boolean = false,
    var delete: Boolean = false
)

data class Chat(val messages: MutableList<Message> = mutableListOf())
object ChatService {
    val chats = mutableMapOf<Int, Chat>()
    fun addNewMessage(id: Int, message: Message) {
        chats.getOrPut(id) { Chat() }.messages += message
    }

    fun printChats() {
        println(chats)
    }

    fun deleteChat(id: Int) {
//        val chat = chats[id] ?: throw ChatNotFoundException()
//        chat.messages.removeAll { message -> true }
//        chat.messages += Message("Данный чат удален", false, true)
        val chat = chats.asSequence()
            .filterIndexed{index, chat ->(index == id -1)}
            .map { it.value.messages.removeAll {message -> true } }
            .let{Chat()}
        chats[id] = chat
            }



    fun deleteMessage(id: Int, number: Int) {
      val chat = chats[id] ?: throw ChatNotFoundException()
        chat.messages.filter { !it.delete }.get(number - 1).delete = true
//             chats.asSequence()
//            .filterIndexed {index, chat ->(index == id-1)}
//            .map{it.value.messages.get(number-1).delete = true}
//            .run{ chats[id]}

   }

    fun getLastMessages(): List<String> {
        return chats.values.map { chat1 -> chat1.messages.lastOrNull { !it.delete }?.text ?: "Нет сообщений" }
    }

    fun getLastChatsNotRead() =
        chats.values.map { chat: Chat -> chat.messages.lastOrNull { !it.read }?.text ?: "нет непрочитанных сообщений" }

    fun getMessages(id: Int, count: Int): List<Message> {
        val chat = chats[id] ?: throw ChatNotFoundException()
        return chat.messages.filter { !it.delete }.takeLast(count).onEach { it.read = true }
    }
}



class ChatNotFoundException : RuntimeException()







