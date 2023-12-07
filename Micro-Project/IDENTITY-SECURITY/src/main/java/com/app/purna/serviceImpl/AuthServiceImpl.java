package com.app.purna.serviceImpl;

import com.app.purna.entity.UserInfo;
import com.app.purna.repository.UserInfoRepository;
import com.app.purna.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserInfo> getAll() {
        return userInfoRepository.findAll();
    }

    public String generateToken(String userName) {
        return jwtService.generateToken(userName);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
    public void createUser(UserInfo userInfo) {
        String password = userInfo.getPassword();
        String encoded = passwordEncoder.encode(password);
        userInfo.setPassword(encoded);
        userInfoRepository.save(userInfo);
    }
}
