package com.agilesolutions.hiscores.repository;

import com.agilesolutions.hiscores.entity.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
    public List<Score> findByCategoryName(String categoryName);

}
