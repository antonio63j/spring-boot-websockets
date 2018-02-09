package pac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    @Autowired
    private final SimpMessagingTemplate template;

    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void onReceivedMesage(String message){
    	System.out.println(" recibido mensaje desde /send/message, se difunde a /chat");
        this.template.convertAndSend("/chat",  new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+message);
    }
    
    @MessageMapping("/send/hora")
    public void onReceivedDifundirHora(String message){
    	System.out.println(" recibido mensaje desde /send/hora, se difunde a /hora");
        this.template.convertAndSend("/hora",  new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+ "la hora");
    }
}
