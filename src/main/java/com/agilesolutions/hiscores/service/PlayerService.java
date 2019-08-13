package com.agilesolutions.hiscores.service;

import com.agilesolutions.hiscores.entity.Player;
import com.agilesolutions.hiscores.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    public Player getPlayerByName(String name){
        return playerRepository.findByName(name).stream().findAny().get();
    }

}
