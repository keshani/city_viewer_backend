package com.citybuilder.cityviewer.configure.security.service;

import com.citybuilder.cityviewer.modules.admin.models.User;
import com.citybuilder.cityviewer.modules.admin.repository.UserRepository;
import com.citybuilder.cityviewer.configure.security.models.AppUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetail service to load the user by user credential
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * @param userId
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findById(userId).get();
        return new AppUserDetail(user);
    }
}
