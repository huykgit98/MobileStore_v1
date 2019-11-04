package dao;

import java.util.List;

import model.User;

public interface UserDao {

	User getUserByID(int id);
	User getUserByUsername(String username);
}

