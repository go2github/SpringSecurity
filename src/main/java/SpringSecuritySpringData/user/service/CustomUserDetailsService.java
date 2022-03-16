package SpringSecuritySpringData.user.service;

import SpringSecuritySpringData.user.entity.User;
import SpringSecuritySpringData.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
          org.springframework.security.core.userdetails.User usr=null;
        if(user.isPresent()){


            List<GrantedAuthority> grantedAuthorities = user.get().getRoles().stream().map(r -> {
                return new SimpleGrantedAuthority("ROLE_"+r.getRole());
            }).collect(Collectors.toList());

            System.out.println(user.get().getUsername());
            System.out.println(user.get().getPassword());

             usr = new org.springframework.security.core.userdetails.User(
                    user.get().getUsername(), user.get().getPassword(), grantedAuthorities);


        }else{
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return usr;
    }
}
