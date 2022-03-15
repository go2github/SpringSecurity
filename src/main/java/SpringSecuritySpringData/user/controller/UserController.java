package SpringSecuritySpringData.user.controller;


import SpringSecuritySpringData.user.entity.User;
import SpringSecuritySpringData.user.repo.UserRepository;
import SpringSecuritySpringData.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2")
public class UserController {

  @Autowired
    UserService service;




    @RequestMapping(value = "/user",method = RequestMethod.GET)

    public List<User> getAllUser() {

        return service.getAllUser();


    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
  public User getUserByID(@PathVariable Long id){
      return service.getUserByID(id);
    }

}
