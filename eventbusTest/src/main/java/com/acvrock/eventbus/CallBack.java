package com.acvrock.eventbus;

/**
 * Created by panjinghong on 2018/8/6.
 */
public class CallBack {
	private Integer chid;
	private Long appid;

	public CallBack(Integer chid, Long appid) {
		this.chid = chid;
		this.appid = appid;
	}

	public Integer getChid() {
		return chid;
	}

	public void setChid(Integer chid) {
		this.chid = chid;
	}

	public Long getAppid() {
		return appid;
	}

	public void setAppid(Long appid) {
		this.appid = appid;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CallBack{");
		sb.append("chid=").append(chid);
		sb.append(", appid=").append(appid);
		sb.append('}');
		return sb.toString();
	}
}
