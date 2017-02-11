package com.acvrock.dao;

import com.acvrock.domain.Member;
import com.acvrock.domain.ScoreRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScoreRecordRepository extends JpaRepository<ScoreRecord, Long> {

	Page<ScoreRecord> findByMember(Member member, Pageable pageable);

}
