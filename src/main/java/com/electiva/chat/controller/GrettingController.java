///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.electiva.chat.controller;
//
//import com.electiva.chat.model.Message;
//import com.electiva.chat.model.MessageOutput;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
///**
// *
// * @author gino_junchaya
// */
//@CrossOrigin(origins = "*")
//@Controller
//public class GrettingController {
//
//    @CrossOrigin
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public MessageOutput greeting(Message message) throws Exception {
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return new MessageOutput(message.getFrom(), message.getText(), time);
//    }
//}
