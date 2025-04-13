package com.service.expenseManager.expenseService.expenseConsumer;

import com.service.expenseManager.expenseService.entity.ExpenseDetailDTO;
import com.service.expenseManager.expenseService.entity.ExpenseDetails;
import com.service.expenseManager.expenseService.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ExpenseConsumer {


    @Autowired
    private ExpenseService expenseService;
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")

    public void listen(ExpenseDetailDTO expenseData) {
//        System.out.println("Message received: " + expenseData);

        try{
            System.out.println("Received message: " + expenseData);
            expenseService.saveOrUpdateExpenseDetails(expenseData);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
