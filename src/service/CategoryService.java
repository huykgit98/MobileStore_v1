package service;

import java.util.List;

import model.Category;

public interface CategoryService {
	Category get(int id);
	public List<Category> search();

}
