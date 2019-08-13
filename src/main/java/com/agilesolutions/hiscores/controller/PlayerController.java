package com.agilesolutions.hiscores.controller;

import com.agilesolutions.hiscores.entity.Player;
import com.agilesolutions.hiscores.exception.ResourceNotFoundException;
import com.agilesolutions.hiscores.service.PlayerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private static final Logger logger = Logger.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/player/{name}")
    public Player getPlayerByName(@PathVariable("name") String name){
        Player response = playerService.getPlayerByName(name);

        if(response == null){
            logger.error("This is Error message", new Exception("Testing"));
            throw new ResourceNotFoundException();
        }

        return response;
    }
}
