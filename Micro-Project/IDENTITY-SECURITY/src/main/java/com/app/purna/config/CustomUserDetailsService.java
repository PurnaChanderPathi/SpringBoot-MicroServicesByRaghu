package com.app.purna.config;

import com.app.purna.entity.UserInfo;
import com.app.purna.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user = userInfoRepository.findByName(username);
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user name not found" + username));
    }
}
