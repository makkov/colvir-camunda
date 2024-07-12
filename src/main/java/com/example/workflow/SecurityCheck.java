package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SecurityCheck implements JavaDelegate {

    private final Random random = new Random();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        boolean isSecurityCheckApproved = random.nextBoolean();
        System.out.printf("Security check result: %s", isSecurityCheckApproved);
        delegateExecution.setVariable("isSecurityCheckApproved", isSecurityCheckApproved);
        if (!isSecurityCheckApproved) {
            throw new BpmnError("securityError");
        }
    }
}
