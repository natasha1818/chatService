fun main() {
    ChatService.addNewMessage(1, Message("Привет!"))
    ChatService.addNewMessage(2, Message("Добрый день"))
    ChatService.addNewMessage(2, Message("привет"))
    ChatService.addNewMessage(2, Message("Как дела?"))
    ChatService.addNewMessage(1, Message("Здравствуйте"))
    ChatService.addNewMessage(3,Message("Hi"))
    ChatService.printChats()
    println(ChatService.getLastMessages())
    println(ChatService.getMessages(1, 1))
    ChatService.printChats()
    println(ChatService.getLastChatsNotRead())
    ChatService.deleteMessage(2, 3)
    println(ChatService.getLastMessages())
    ChatService.deleteChat(1)
    ChatService.printChats()

}