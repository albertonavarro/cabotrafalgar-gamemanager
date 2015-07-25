package com.navid.gamemanager.persistence;

import com.navid.gamemanager.domain.Invitation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alberto on 7/25/15.
 */
public interface InvitationRepo extends CrudRepository<Invitation, Long> {
}
