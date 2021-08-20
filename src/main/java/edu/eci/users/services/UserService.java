package edu.eci.users.services;

import edu.eci.users.data.User;
import java.util.List;

public interface UserService {
    
    public User create( User user );

    public User findById( String id );
    
    public List<User> all();

    public void deleteById( String id );

    public User update( User user, String userId );
}
