package pac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.stereotype.Controller;

import pac.sendhora.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
public class WebSocketController {
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1); 
	
	@Autowired
    private SimpMessagingTemplate template;
    
    private Task task1;

   
    WebSocketController(SimpMessagingTemplate template){
       // this.template = template;
        this.task1 = new Task ("Demo Task 1", template);
        this.executor.schedule(this.task1, 1 , TimeUnit.SECONDS);
    }

    @MessageMapping("/send/message")
    public void onReceivedMesage(String message){
        this.template.convertAndSend("/chat",  new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+message);
    }
}
