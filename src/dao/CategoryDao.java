package dao;

import java.util.List;

import model.Category;

public interface CategoryDao {
	Category get(int id);
	public List<Category> search();

}
