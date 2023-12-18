package com.service;

import com.model.Challenge;
import com.model.Play;
import com.model.User;
import com.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService {

    private final PlayRepository playRepository;

    @Autowired
    public PlayService(PlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    public Play createPlayEntry(User user, Challenge challenge) {
        Play newPlay = new Play(user,challenge);
   
        return playRepository.save(newPlay);
    }
}
