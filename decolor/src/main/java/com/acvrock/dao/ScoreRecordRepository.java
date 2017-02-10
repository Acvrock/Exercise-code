package com.acvrock.dao;

import com.acvrock.domain.Member;
import com.acvrock.domain.ScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScoreRecordRepository extends JpaRepository<ScoreRecord, Long>{

	ScoreRecord findByMember(Member member);

}
