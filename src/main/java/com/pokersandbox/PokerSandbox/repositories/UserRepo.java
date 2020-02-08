package com.pokersandbox.PokerSandbox.repositories;

import com.pokersandbox.PokerSandbox.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends CrudRepository <Member, Long> {

    Member findByUsername(String username);
    Boolean existsByUsername(String username);
}
