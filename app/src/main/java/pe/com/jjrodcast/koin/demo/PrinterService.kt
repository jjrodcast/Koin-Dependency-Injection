package pe.com.jjrodcast.koin.demo

class PrinterService {

    private val documentService = DocumentService()
    private val senderService = SenderService()

    private fun send() = senderService.send()

    private fun document() = documentService.generateDocument()

    fun print() {
        document()
        send()
        println("Printing new document")
    }
}