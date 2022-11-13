package lotto.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.constant.ErrorLog;
import lotto.constant.LottoConstant;

public class Validator {
	public static void validateExclusion(int number, List<Integer> numbers) {
		if (numbers.contains(number)) {
			throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복되면 안 됩니다.");
		}
	}

	public static void validateNumberRange(int number) {
		if (number < LottoConstant.MINIMUM_LOTTO_NUMBER || number > LottoConstant.MAXIMUM_LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 각각의 숫자는 1부터 45까지의 범위여야 합니다.");
		}
	}

	public static void validateSizeOfNumbers(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 숫자는 총 여섯개여야 합니다.");
		}
	}

	public static void validateNoDuplication(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != 6) {
			throw new IllegalArgumentException("[ERROR] 숫자 간에 중복이 있으면 안 됩니다.");
		}
	}

	public static void validateDivisibility(int amount) {
		if (amount % LottoConstant.PRICE_OF_LOTTO != 0) {
			throw new IllegalArgumentException(ErrorLog.INDIVISIBLE_PURCHASING_AMOUNT_ERROR.log());
		}
	}

	public static void validateIntegerOrNot(String input) {
		if (input.chars().anyMatch(letter -> letter < '0' || letter > '9')) {
			throw new IllegalArgumentException(ErrorLog.NOT_INTEGER_INPUT_ERROR.log());
		}
	}

	public static void validateFormOfWinningNumbers(String winningNumbers) {
		Pattern pattern = Pattern.compile("^\\d{0,2},\\d{0,2},\\d{0,2},\\d{0,2},\\d{0,2},\\d{0,2}$");
		Matcher matcher = pattern.matcher(winningNumbers);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호의 형식이 올바르지 않습니다. 올바른 예) 1,2,3,4,5,6");
		}
	}
}
