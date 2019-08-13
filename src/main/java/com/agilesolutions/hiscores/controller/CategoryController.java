package com.agilesolutions.hiscores.controller;

import com.agilesolutions.hiscores.entity.Category;
import com.agilesolutions.hiscores.entity.Player;
import com.agilesolutions.hiscores.entity.Score;
import com.agilesolutions.hiscores.exception.ResourceNotFoundException;
import com.agilesolutions.hiscores.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    private static final Logger logger = Logger.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/{name}")
    public List<Player> getScoresByCategory(@PathVariable("name") String name){

        if(logger.isDebugEnabled()){
            logger.debug("getScoresByCategory is executed!");
        }

        List<Player> response = categoryService.getScoresByCategory(name);
        if(response.size() == 0){
            logger.error("This is Error message", new Exception("Testing"));
            throw new ResourceNotFoundException();
        }
        return response;
    }

    @RequestMapping("/category/Overall")
    public List<Player> getOverall(){
        return categoryService.getOverall();
    }

}
