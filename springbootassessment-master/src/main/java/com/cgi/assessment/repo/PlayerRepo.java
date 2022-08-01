package com.cgi.assessment.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.assessment.model.Player;

@Repository
@Transactional
public interface PlayerRepo extends JpaRepository<Player, Integer> {

}
