package com.navid.gamemanager.persistence;

import com.navid.gamemanager.domain.Game;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alberto on 7/19/15.
 */
public interface GameRepo extends CrudRepository<Game, Long> {




}
