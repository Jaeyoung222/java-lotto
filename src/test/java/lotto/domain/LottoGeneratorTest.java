package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

	@Test
	@DisplayName("6개의 번호를 생성한다.")
	void getNumbers1() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		assertThat(lottoGenerator.getNumbers()).hasSize(6);
	}

	@Test
	@DisplayName("번호가 중복이 아니다.")
	void getNumbers() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		assertThat(lottoGenerator.getNumbers().stream().distinct()).hasSize(6);
	}
}