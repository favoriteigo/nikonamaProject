package nikonama.co.jp;

import nikonama.co.jp.data.DataBean;
import nikonama.co.jp.validation.InputValidate;

public class DevelopMain {

	public static void main(String[] args) {
		DataBean bean = new DataBean();
		bean.setNum(10);
		bean.setName("いっしー");
		bean.setMail("info@mail");

		// 入力チェック実行
		InputValidate validate = new InputValidate(bean);
		validate.inputCheck();
	}

}
