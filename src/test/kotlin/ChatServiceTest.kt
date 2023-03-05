import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun addNewMessage() {
        val service = ChatService
       val result = service.addNewMessage(1,Message("text"))
        assertNotNull(result)
    }
    @Test(expected =  ChatNotFoundException::class)
    fun getMessages(){
        val service = ChatService
        service.addNewMessage(1,Message("text"))
        val result = service.getMessages(4,1)
    }
    @Test
    fun deleteMessage(){
        val service = ChatService
        service.addNewMessage(1,Message("text"))
        service.addNewMessage(1,Message("text"))
        service.deleteMessage(1,1)
        val result = service.chats.getValue(1).messages.get(0).delete
        assertTrue(result)
    }
}