package com.example.workflow;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/client")
@RestController
public class LoanController {

    @GetMapping
    public void handleClient(@RequestParam(name = "clientName") String clientName) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("name", clientName);

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        runtimeService.createProcessInstanceByKey("colvir-camunda-process")
                .setVariables(variables)
                .executeWithVariablesInReturn();
    }
}
