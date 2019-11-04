package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();

	@Override
	public User getUserByID(int id) {
		return userDao.getUserByID(id);

	}

	@Override
	public User getUser(String username, String password) {
		User user =userDao.getUserByUsername(username);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		
		
		return null;
	}



}
