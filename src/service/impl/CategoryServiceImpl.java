package service.impl;

import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public Category get(int id) {
		Category cate =categoryDao.get(id);
		return cate;
	}
	@Override
	public List<Category> search() {
		return categoryDao.search();

	}
	

}
