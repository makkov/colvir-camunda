package com.example.workflow;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/client")
@RestController
public class LoanController {

//    private final ProcessEngine processEngine;
//    private final RuntimeService runtimeService;

//    public LoanController(ProcessEngine processEngine, RuntimeService runtimeService) {
//        this.runtimeService = runtimeService;
//        this.processEngine = processEngine;
//    }

    @GetMapping
    public void handleClient(@RequestParam String clientName) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("name", clientName);

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstanceWithVariables instance = runtimeService.createProcessInstanceByKey("colvir-camunda-process")
                .setVariables(variables)
                .executeWithVariablesInReturn();
    }
}
