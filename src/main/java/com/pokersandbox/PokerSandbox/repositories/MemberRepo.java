package com.pokersandbox.PokerSandbox.repositories;

import com.pokersandbox.PokerSandbox.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends CrudRepository <Member, Long> {

    Member findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
