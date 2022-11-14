package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

public class LottoGenerator {
	private List<Integer> numbers;

	private void generateLotto() {
		numbers = Randoms.pickUniqueNumbersInRange(LottoConstant.MINIMUM_LOTTO_NUMBER,
			LottoConstant.MAXIMUM_LOTTO_NUMBER, LottoConstant.COUNT_OF_LOTTO_NUMBERS);
		numbers = numbers.stream().sorted().collect(Collectors.toList());
	}

	public List<Integer> getNumbers() {
		generateLotto();
		return numbers;
	}
}
