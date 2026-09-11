package com.z.vault.Configuration;


import com.z.vault.Entities.Users;
import com.z.vault.Repo.UsersRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  UsersRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber)
            throws UsernameNotFoundException {

        Users user = userRepository.findByPhoneNo(phoneNumber);

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getPhoneNo())
                .password(user.getPasswordHash())
                .authorities("USER")
                .build();
    }
}


