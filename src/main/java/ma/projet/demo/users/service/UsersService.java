package ma.projet.demo.users.service;



import ma.projet.demo.users.Requests.UsersRequest;
import ma.projet.demo.users.model.Users;

import java.util.List;

public interface UsersService {
    public List<Users> GetAllUsers();

    public Users AddUser(UsersRequest user);
}
