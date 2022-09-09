package com.system.reviewSystem.repository;

import com.system.reviewSystem.entity.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {


    @Query("SELECT AVG(e.vote) FROM Vote e WHERE e.isAccepted = '1'")
    float averageOfVotes();

    @Query("SELECT  COUNT(v)FROM Vote AS v WHERE v.isAccepted = '1'")
    int countTotalIsAccepted();


}
