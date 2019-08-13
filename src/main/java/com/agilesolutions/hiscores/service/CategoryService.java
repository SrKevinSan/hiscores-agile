package com.agilesolutions.hiscores.service;

import com.agilesolutions.hiscores.entity.Category;
import com.agilesolutions.hiscores.entity.Score;
import com.agilesolutions.hiscores.entity.Player;
import com.agilesolutions.hiscores.repository.CategoryRepository;
import com.agilesolutions.hiscores.repository.PlayerRepository;
import com.agilesolutions.hiscores.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getOverall(){

        List<Score> scores = new ArrayList<>();
        scoreRepository.findAll().forEach(scores::add);

        Map<Player, Integer> map = scores.stream().collect(Collectors.groupingBy(Score::getPlayer,
                Collectors.summingInt(Score::getScoreInt)));

        List<Integer> sum = new ArrayList(map.values());
        List<Player> players = new ArrayList(map.keySet());

        int[] idx = { 0 };
        players = players.stream().map(
                player -> {
                    player.setXp(sum.get(idx[0]++));
                    return player;
                })
                .sorted(Comparator.comparing(Player::getXp).reversed())
                .collect(Collectors.toList());
        return players;
    }

    public List<Player> getScoresByCategory(String name){
        List<Player> players = scoreRepository.findByCategoryName(name).stream().map(
                score -> {
                    score.getPlayer().setXp(score.getScore());
                    return score.getPlayer();
                })
                .collect(Collectors.toList());

        return players.stream()
                .sorted(Comparator.comparing(Player::getXp).reversed())
                .collect(Collectors.toList());
    }

}
