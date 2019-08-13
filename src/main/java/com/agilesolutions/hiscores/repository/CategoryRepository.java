package com.agilesolutions.hiscores.repository;

import com.agilesolutions.hiscores.entity.Category;
import com.agilesolutions.hiscores.entity.Score;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    public List<Category> findByName(String name);
}
