package com.microservice.training.controller;

import com.microservice.training.service.NotificationService;
import com.microservice.training.model.Enrollment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.UriTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/")
public class EnrollController {
    private static Logger LOG = LoggerFactory.getLogger(EnrollController.class);

    @Autowired
    private NotificationService notificationService;

    @GetMapping(path = "/", produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public HttpEntity<ResourceSupport> root() {
        ResourceSupport root = new ResourceSupport();
        root.add(new Link(
                new UriTemplate(linkTo(EnrollController.class, "").slash("/enroll").toString()), "enroll"));
        return new ResponseEntity<>(root, HttpStatus.OK);
    }

    @PostMapping("/enroll")
    public String enroll(@RequestBody Enrollment enrollment) {
        LOG.info(enrollment.toString());
//        notificationService.enqueueNotificationJob(
//                enrollment.getName(), "Enroll Success", enrollment.toString());
        return "enroll success";
    }

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/enroll/*").authenticated();
        }
    }
}
