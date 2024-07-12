package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class Auth implements JavaDelegate {

    private final ClientService clientService;

    public Auth(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String name = (String) delegateExecution.getVariable("name");

        if (name == null || name.isEmpty()) {
            throw new BpmnError("emptyName");
        }

        boolean isExist = clientService.isExist(name);
        System.out.printf("Client %s exists: %s\n", name, isExist);
        delegateExecution.setVariable("isExist", isExist);
    }
}
