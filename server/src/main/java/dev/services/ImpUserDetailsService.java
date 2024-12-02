package dev.services;
import dev.entities.User;
import dev.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImpUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public ImpUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Used
    public UserDetails loadUserByID(String userId) throws UsernameNotFoundException {
        User user = userRepository.findUserById(userId).orElseThrow(()->
                new UsernameNotFoundException("User not found: " + userId));

        //Convert Role field in User entity to GrandAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toUpperCase()));

        return new org.springframework.security.core.userdetails.User(
                user.getId(),
                user.getPassword(),
                authorities);
    }


    //Not used
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("User not found: " + username));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE" + user.getRole().toUpperCase()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities);
    }
}
