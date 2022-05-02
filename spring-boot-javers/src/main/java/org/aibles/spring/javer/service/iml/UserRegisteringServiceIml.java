package org.aibles.spring.javer.service.iml;

import org.aibles.spring.javer.dto.request.UserRegisteringReq;
import org.aibles.spring.javer.dto.response.UserRegisteringRes;
import org.aibles.spring.javer.model.UserEntity;
import org.aibles.spring.javer.repository.UserRepository;
import org.aibles.spring.javer.service.UserRegisteringService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserRegisteringServiceIml implements UserRegisteringService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRegisteringServiceIml(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserRegisteringRes execute(UserRegisteringReq input) {
        Map<String, Object> mapError = validateInput(input);
        if (!mapError.isEmpty()) {
            throw new RuntimeException(mapError.toString());
        }

        UserEntity userEntity = modelMapper.map(input, UserEntity.class);

        return modelMapper.map(userRepository.save(userEntity), UserRegisteringRes.class);
    }

    private Map<String, Object> validateInput(UserRegisteringReq input) {
        Map<String, Object> mapError = new HashMap<>();

        userRepository.findByUsername(input.getUsername())
                .ifPresent(u -> {
                    mapError.put("username", "Username is exist.");
                });

        userRepository.findByEmail(input.getEmail())
                .ifPresent(u -> {
                    mapError.put("email", "Email is exist.");
                });

        return mapError;
    }
}
