package com.navid.gamemanager.persistence;

import com.navid.gamemanager.domain.Game;
import com.navid.gamemanager.domain.Server;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alberto on 7/24/15.
 */
public interface ServerRepo extends CrudRepository<Server, Long> {
}
