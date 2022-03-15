package SpringSecuritySpringData.user.service;

import SpringSecuritySpringData.user.entity.User;
import SpringSecuritySpringData.user.iface.IUserService;
import SpringSecuritySpringData.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  //  @PreAuthorize("hasAnyRole('ADMIN','ROLE_ADMIN')")
    public List<User> getAllUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority:authentication.getAuthorities()){
            System.out.println(authority.getAuthority());
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        return userRepository.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @Override
    public User getUserByID(Long id) {
        Optional<User> user=userRepository.findById(id);
       return user.orElse(null);
    }
}
