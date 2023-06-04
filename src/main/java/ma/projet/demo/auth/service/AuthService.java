package ma.projet.demo.auth.service;



import ma.projet.demo.users.Requests.UsersRequest;
import ma.projet.demo.users.model.Users;

import java.util.Optional;

public interface AuthService {
    public Optional<Users> AddUser(UsersRequest user);
}
