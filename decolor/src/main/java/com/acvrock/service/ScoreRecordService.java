package com.acvrock.service;

import com.acvrock.dao.MemberRepository;
import com.acvrock.dao.ScoreRecordRepository;
import com.acvrock.domain.Member;
import com.acvrock.domain.Msg;
import com.acvrock.domain.ScoreRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class ScoreRecordService {
    @Autowired
    ScoreRecordRepository scoreRecordRepository;
    @Autowired
    MemberRepository memberRepository;

    public Msg transferScore(String memberPhone, String memberName, Long score, String remark, Member member) {
        Msg msg = new Msg("积分转赠", "0", null);
        if (StringUtils.isEmpty(memberPhone) || StringUtils.isEmpty(memberName)) {
            msg.setContent("1");
            msg.setEtraInfo("输入参数不能为空");
            return msg;
        }
        if (memberName.equals(member.getMemberName())) {
            msg.setContent("1");
            msg.setEtraInfo("不能自己送于自己积分");
            return msg;
        }
        if (score<=0) {
            msg.setContent("1");
            msg.setEtraInfo("积分不能小于等于 0");
            return msg;
        }
        Member otherSide = memberRepository.findByMemberName(memberName);
        if (otherSide == null || !memberName.equals(otherSide.getMemberName()) || !memberPhone.equals(otherSide.getMemberPhone())) {
            msg.setContent("1");
            msg.setEtraInfo("对方信息错误，请确认后再试");
            return msg;
        }
        String lock = getLockStr(member.getMemberName(), memberName);
        synchronized (lock.intern()) {
            member = memberRepository.findByMemberName(member.getMemberName());
            if (member.getMemberScore() < score) {
                msg.setContent("1");
                msg.setEtraInfo("您的积分不足" + score);
                return msg;
            }
            member.setMemberScore(member.getMemberScore() - score);
            memberRepository.save(member);
            otherSide.setMemberScore(otherSide.getMemberScore() + score);
            memberRepository.save(otherSide);
        }
        saveScoreRecord(-score, remark, member);
        saveScoreRecord(score, remark, otherSide);

        msg.setContent("2");
        return msg;
    }

    public void saveScoreRecord(Long score, String remark, Member otherSide) {
        ScoreRecord otherSideScoreRecord = new ScoreRecord();
        otherSideScoreRecord.setCreateTime(new Date().getTime());
        otherSideScoreRecord.setGrowthScore(score);
        otherSideScoreRecord.setRemark(remark);
        otherSideScoreRecord.setMember(otherSide);
        scoreRecordRepository.save(otherSideScoreRecord);
    }

    private static String getLockStr(String memberName, String memberName1) {
        if (memberName.compareTo(memberName1) > 0)
            return "L_" + memberName + '_' + memberName1;
        return "L_" + memberName1 + '_' + memberName;
    }


    public Page<ScoreRecord> findByMember(Integer page, Integer size, Member member) {
        Sort sort = new Sort(Sort.Direction.DESC, "scoreRecordID");
        Pageable pageable = new PageRequest(page, size, sort);
        return scoreRecordRepository.findByMember(member, pageable);
    }
}
