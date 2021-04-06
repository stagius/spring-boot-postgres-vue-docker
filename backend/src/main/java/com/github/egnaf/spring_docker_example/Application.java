package com.github.egnaf.spring_docker_example;

import com.github.egnaf.spring_docker_example.domain.User;
import com.github.egnaf.spring_docker_example.repository.UserRepository;
import com.github.egnaf.spring_docker_example.transfer.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List allUsers = this.repository.findAll();
        log.info("Number of customers: " + allUsers.size());

        User newUser = new User();
        newUser.setNickname("John");
        newUser.setEmail("test@test.com");
        log.info("Saving new customer...");
        this.repository.save(newUser);

        allUsers = this.repository.findAll();
        log.info("Number of customers: " + allUsers.size());
    }
}
