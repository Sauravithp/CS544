package com.example.assignment242receiver.jms;

import com.example.assignment242receiver.domain.Account;
import com.example.assignment242receiver.utils.ObjectMapperUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class JmsReceiver {
    @JmsListener(destination = "accountQueue")
    public void receiveMessage(final String accountAsString)
    {
        try{
            Account account= ObjectMapperUtils.objectMapper().
                    readValue(accountAsString, Account.class);
            System.out.println("JMS receiver received message:"+account);
        }
        catch(JsonProcessingException ex)
        {
            ex.printStackTrace();
        }
    }
}
