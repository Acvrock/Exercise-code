package com.acvrock.domain;

import javax.persistence.*;

@Entity
public class ScoreRecord {
    @Id
    @GeneratedValue
    private Long scoreRecordID;
    private Long growthScore;
    private Long createTime;
    private String remark;

    @ManyToOne(fetch= FetchType.LAZY)
    private Member member;

    public Long getScoreRecordID() {
        return scoreRecordID;
    }

    public void setScoreRecordID(Long scoreRecordID) {
        this.scoreRecordID = scoreRecordID;
    }



    public Long getGrowthScore() {
        return growthScore;
    }

    public void setGrowthScore(Long growthScore) {
        this.growthScore = growthScore;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
