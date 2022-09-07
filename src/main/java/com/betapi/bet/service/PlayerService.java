package com.betapi.bet.service;

import com.betapi.bet.model.Player;
import com.betapi.bet.model.dto.PlayerIn;
import com.betapi.bet.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    public void savePlayer(PlayerIn playerIn) {
        Player player = modelMapper.map(playerIn, Player.class);
        playerRepository.save(player);
    }
}
