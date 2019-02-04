package nikonama.co.jp.validation;

import java.lang.reflect.Field;

import nikonama.co.jp.anotation.Column;

/**
 * 入力チェック共通クラス
 * @author favor
 *
 */
public class InputValidate {
	/** ターゲットクラス */
	Object targetClass = null;

	public InputValidate(Object targetClass) {
		this.targetClass = targetClass;
	}

	public void inputCheck() {
		for (Field f: targetClass.getClass().getFields()) {
			if(f.isAnnotationPresent(Column.class)) {
				try {
					System.out.println("チェック最小値:" + f.getAnnotation(Column.class).min());
					System.out.println("入力値:" + f.get(targetClass));
					boolean isNumResult = isNum(f.getAnnotation(Column.class).min(),f.getAnnotation(Column.class).min(),
							f.get(targetClass));
					System.out.println("入力チェック結果:" + isNumResult);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}
	}

	/**
	 * 最小値、最大値入力チェック
	 * @param min
	 * @param max
	 * @param targetField
	 * @return true: チェックエラー false:エラーなし
	 */
	private boolean isNum(int min, int max, Object targetField) {
		boolean bool = false;
		if (min < Integer.parseInt(targetField.toString())) {
			bool = true;
		}

		if(max > Integer.parseInt(targetField.toString())) {
			bool = true;
		}

		return bool;
	}

}
