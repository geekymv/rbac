package com.rbac.web;

import com.rbac.model.Application;
import com.rbac.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/createApplication")
    public Application createApplication(@RequestBody Application application) {
        return applicationService.createApplication(application);
    }


}
