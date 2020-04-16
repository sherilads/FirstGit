package com.fresco.springBoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FrescoCourseService {

	private List<Category> categories=new ArrayList<>(Arrays.asList(
			new Category(1001, "Cloud Computing", "network of remote servers hosted on the Internet to store"),
			new Category(1002,"Data Science","practice of deriving valuable insights from data"),
			new Category(1003,"DevOps","practices that emphasize on collaboration and communication"),
			new Category(1004,"Digital Foundation","foundation of the Digital Courses")));
	
	public List<Category> getAllCategories(){
		return categories;
	}
	public Category getCategory(int id){
		return categories.stream().filter(c->c.getId()==(id)).findFirst().get();
	}
	public void addCategory(Category category){
		 categories.add(category);
	}

	public void updateCategory(Category category, int id){	
		for(int i=0;i<categories.size();i++){
			Category c= categories.get(i);
			if(c.getId()==id){
				categories.set(i, category);
				return;
			}
		}
	}
	public void deleteCategory(int id){
		 categories.remove(categories.stream().filter(c->c.getId()==(id)).findFirst().get());
	}

}
