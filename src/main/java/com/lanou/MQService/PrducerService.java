package com.lanou.MQService;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by dllo on 17/12/27.
 */
@Service
public class PrducerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    //    从前端获取消息内容
    public void sendMessage(String msg) {

        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        };
        jmsTemplate.send(messageCreator);
    }
}
