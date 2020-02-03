package com.pokersandbox.PokerSandbox.repositories;

import com.pokersandbox.PokerSandbox.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends CrudRepository <User, Long> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
