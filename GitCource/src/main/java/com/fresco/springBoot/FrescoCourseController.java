package com.fresco.springBoot; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
@RestController
@EnableAutoConfiguration
public class FrescoCourseController {
	
	 @Autowired
	 FrescoCourseService frescoCourseService;
	 
	 @Value("${fresco-courses}")
     private String msg;
    
	@RequestMapping("/fresco")
    public String test() {	        
     return msg;
	}
	@RequestMapping("/categories")
    public List<Category> getAllCategories() {
        return frescoCourseService.getAllCategories();
    }
    @RequestMapping("/categories/{id}")
    public Category getCategory(@PathVariable int id) {
        return frescoCourseService.getCategory(id);
    }
    @RequestMapping(method=RequestMethod.POST, value="/categories")
    public void addCategory(@RequestBody Category category  ) {
        frescoCourseService.addCategory(category);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/categories/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable int id) {
         frescoCourseService.updateCategory(category, id);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        frescoCourseService.deleteCategory(id);
    }
}