package com.lanou.MQService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by dllo on 17/12/27.
 */
@Service
public class ConsumerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public String receiveMsg() {

        TextMessage textMessage = (TextMessage) jmsTemplate.receive();

        if (textMessage != null) {
            try {
                String result = textMessage.getText();

                System.out.println("收到信息" + result);

                return result;

            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return "没有新消息";
    }

}
