package edu.miu.cs425.onlineshoppingapp.security;

import edu.miu.cs425.onlineshoppingapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class AwesomeUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public AwesomeUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("User not found with user name " + username);
        var userDetails = new AwesomeUserDetails(user);
        return userDetails;
    }
}
