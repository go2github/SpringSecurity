package SpringSecuritySpringData.user.iface;

import SpringSecuritySpringData.user.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUser();
    public User getUserByID(Long id);
}
