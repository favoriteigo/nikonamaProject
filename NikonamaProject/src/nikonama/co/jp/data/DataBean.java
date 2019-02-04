package nikonama.co.jp.data;

import nikonama.co.jp.anotation.Column;
import nikonama.co.jp.anotation.NotNull;

public class DataBean {

	@Column(min = 0, max=30)
	private int num = 0;

	@NotNull
	private String name = null;

	@NotNull
	private String mail = null;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



}
