package com.service.expenseManager.expenseService.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.expenseManager.expenseService.entity.ExpenseDetailDTO;

import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class ExpenseDeserializer implements Deserializer<ExpenseDetailDTO> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public ExpenseDetailDTO deserialize(String topic, byte[] data) {

        ObjectMapper objectMapper=new ObjectMapper();

        try {
            System.out.println("Deserializing message: " + new String(data));
            return objectMapper.readValue(data, ExpenseDetailDTO.class);
        } catch (Exception e) {
            System.out.println("Failed to deserialize message: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
