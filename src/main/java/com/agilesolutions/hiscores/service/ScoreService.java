package com.agilesolutions.hiscores.service;

import com.agilesolutions.hiscores.entity.Score;
import com.agilesolutions.hiscores.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScores(){
        List<Score> scores = new ArrayList<>();
        scoreRepository.findAll().forEach(scores::add);
        return scores;
    }
}
