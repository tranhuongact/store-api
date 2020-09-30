package com.store.listing.category;

import com.store.listing.common.BaseController;
import com.store.listing.common.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Danh mục sản phẩm")
@RestController
@RequestMapping("/categories")
public class CategoryControler extends BaseController {

    private CategoryService categoryService;

    @Autowired
    public CategoryControler(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Response> getAllCategories() {
        try {
            return makeResponse(categoryService.getAllCategories());
        } catch (Exception e) {
            return makeResponseError(e);
        }
    }
}
