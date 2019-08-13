package com.agilesolutions.hiscores.controller;

import com.agilesolutions.hiscores.entity.Score;
import com.agilesolutions.hiscores.service.ScoreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {

    private static final Logger logger = Logger.getLogger(ScoreController.class);

    @Autowired
    private ScoreService scoreService;

}
