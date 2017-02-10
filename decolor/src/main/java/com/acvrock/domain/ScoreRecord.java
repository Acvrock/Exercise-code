package com.acvrock.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ScoreRecord {
    @Id
    @GeneratedValue
    private Long scoreRecordID;
    private BigDecimal growthScore;
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



    public BigDecimal getGrowthScore() {
        return growthScore;
    }

    public void setGrowthScore(BigDecimal growthScore) {
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

}
