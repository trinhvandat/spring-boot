package org.aibles.spring.javer.service;

import org.aibles.spring.javer.dto.request.UserRegisteringReq;
import org.aibles.spring.javer.dto.response.UserRegisteringRes;

public interface UserRegisteringService {
    UserRegisteringRes execute(UserRegisteringReq request);
}
