package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.Category;
import com.mikado.multitenant.domain.tenant.QCategory;
import com.mikado.multitenant.repository.tenant.CategoryRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository){
	    this.categoryRepository = categoryRepository;
    }

	public Category save(Category firm) {
		firm = categoryRepository.save(firm);
		return firm;
	}

	public Page<Category> findAll(BooleanBuilder booleanBuilder, PageRequest pageRequest) {
		Page<Category> page = null;
		if (booleanBuilder != null) {
			page = categoryRepository.findAll(booleanBuilder, pageRequest);
		} else {
			page = categoryRepository.findAll(pageRequest);
		}
		return page;
	}

	public Page<Category> findAll(PageRequest pageRequest) {
		return findAll(null, pageRequest);
	}

	public Category findById(Long id) {
		return categoryRepository.findOne(id);
	}

	public void delete(Category firm) {
		categoryRepository.delete(firm);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	public Category findByCode(String code) {
		return categoryRepository.findOne(QCategory.category.code.eq(code));
	}

}
