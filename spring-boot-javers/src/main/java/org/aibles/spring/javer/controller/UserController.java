package org.aibles.spring.javer.controller;

import org.aibles.spring.javer.dto.request.UserRegisteringReq;
import org.aibles.spring.javer.dto.response.UserRegisteringRes;
import org.aibles.spring.javer.service.UserRegisteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRegisteringService userRegisteringService;

    @Autowired
    public UserController(UserRegisteringService userRegisteringService) {
        this.userRegisteringService = userRegisteringService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisteringRes registerUser(@Validated @RequestBody UserRegisteringReq input) {
        return userRegisteringService.execute(input);
    }
}
