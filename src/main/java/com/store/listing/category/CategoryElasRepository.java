package com.store.listing.category;

import com.store.listing.category.model.CategoryElas;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryElasRepository extends ElasticsearchRepository<CategoryElas, String> {
}
