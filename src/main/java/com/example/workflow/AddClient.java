package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AddClient implements JavaDelegate {

    private final ClientService clientService;

    public AddClient(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String name = (String) delegateExecution.getVariable("name");
        System.out.printf("Client %s was added\n", name);
        clientService.add(name);
    }
}
