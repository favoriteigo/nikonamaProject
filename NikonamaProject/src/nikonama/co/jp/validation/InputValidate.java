package nikonama.co.jp.validation;

import java.lang.reflect.Field;

import nikonama.co.jp.anotation.Column;

/**
 * 入力チェック共通クラス
 * @author いっしー
 *
 */
public class InputValidate {
	/** ターゲットクラス */
	Object targetClass = null;

	/**
	 * コンストラクタ
	 * @param targetClass 入力チェック対象クラス
	 */
	public InputValidate(Object targetClass) {
		this.targetClass = targetClass;
	}

	public void inputCheck() {
		for (Field f: targetClass.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			if(f.isAnnotationPresent(Column.class)) {
				try {
					System.out.println("チェック最小値:" + f.getAnnotation(Column.class).min());
					System.out.println("入力値:" + f.get(targetClass));
					boolean isNumResult = isNum(f.getAnnotation(Column.class).min(),f.getAnnotation(Column.class).min(),
							f.get(targetClass));
					System.out.println("入力チェック結果:" + isNumResult);
					boolean isNotNull = isNotNull(f.get(targetClass));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 最小値、最大値入力チェック
	 * @param min 最小値
	 * @param max 最大値
	 * @param targetField 入力チェック対象フィールド名
	 * @return true: チェックエラー false:エラーなし
	 */
	private boolean isNum(int min, int max, Object targetField) {
		boolean bool = false;
		if (min > Integer.parseInt(targetField.toString())) {
			bool = true;
		}

		if(max < Integer.parseInt(targetField.toString())) {
			bool = true;
		}

		return bool;
	}

	/**
	 * NULLチェック
	 * @param targetField 入力チェック対象フィールド名
	 * @return true チェックエラー false: エラーなし
	 */
	private boolean isNotNull(Object targetField) {

		return true;
	}

}
