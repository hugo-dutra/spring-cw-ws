package com.corretoraweb.ws;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class WsApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void itShouldAddTwonumbers() {
		//given
		int numberOne = 20;
		int numberTwo = 30;
		//when
		int result = underTest.add(numberOne, numberTwo);
		//then
		int expected = 50;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
