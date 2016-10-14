package net.mds.dev2.cboard.models;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;

public class BoardVO implements Serializable{
	private int level;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	private long no;
	private long pno;
	private String title;
	private String name;
	private String password;
	private String content;
	private int readcount;
	private String regdate;
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getPno() {
		return pno;
	}
	public void setPno(long pno) {
		this.pno = pno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = DigestUtils.sha512Hex(password);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		return "BoardVO [level=" + level + ", no=" + no + ", pno=" + pno + ", title=" + title + ", name=" + name
				+ ", password=" + password + ", content=" + content + ", readcount=" + readcount + ", regdate="
				+ regdate + "]";
	}
	
}
