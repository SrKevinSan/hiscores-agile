package com.agilesolutions.hiscores.repository;

import com.agilesolutions.hiscores.entity.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    public List<Player> findByName(String name);
}
