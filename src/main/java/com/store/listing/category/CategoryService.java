package com.store.listing.category;

import com.store.listing.category.model.CategoryElas;
import com.store.listing.category.model.CategoryResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryElasRepository categoryElasRepository;
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryElasRepository categoryElasRepository, ElasticsearchTemplate elasticsearchTemplate) {
        this.categoryRepository = categoryRepository;
        this.categoryElasRepository = categoryElasRepository;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public List<CategoryResponse> getAllCategories() {
        List<CategoryResponse> response = new ArrayList<>();
        CategoryResponse cate = new CategoryResponse();

        Iterable<CategoryElas> iterable = categoryElasRepository.findAll();

        iterable.forEach(category -> {
            BeanUtils.copyProperties(category, cate);
            response.add(cate);
        });

//        List<CategoryElas> categoryElasList = new ArrayList<>();
//        iterable.forEach(categoryElasList::add);
//        categoryElasList.forEach(category -> {
//            BeanUtils.copyProperties(category, cate);
//            response.add(cate);
//        });

        return response;
    }
}
