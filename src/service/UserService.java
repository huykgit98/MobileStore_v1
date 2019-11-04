package service;

import model.User;

public interface UserService {
	User getUserByID(int id);
	User getUser(String username,String password);

}