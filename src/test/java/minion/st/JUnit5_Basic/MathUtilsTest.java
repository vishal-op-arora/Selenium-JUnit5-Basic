package minion.st.JUnit5_Basic;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.AfterAll;

@DisplayName("MathUtils Testing")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest{

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	void beforAllInit () {
		System.out.println("BeforeAll \n");
	}
	
	@BeforeEach
	void init (TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag " + testInfo.getTags());
		System.out.println("BeforeEach");
	}
	
	@AfterEach
	void cleanUp () {
		System.out.println("AfterEach \n");
		
	}
	
	@Test
	@DisplayName("Add")
	@Tag("Math")
	void testAdd() {
		//fail("Not yet implemented");
		
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		
		//System.out.println("Actual : " + actual);
		assertEquals(expected, actual);
		assertEquals(expected, actual, "Failed to compute addition of two numbers. ");
		
		System.out.println("testAdd()");
		
	}
	
	@Test
	@DisplayName("Divide")
	@Tag("Math")
	void testDivide () {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0), "divide by zero should throw exception. ");
		//it should throw exception try mathutils.divide(10, 0), mathutils.divide(10, 1)
		//assertThrows(NullPointerException.class, () -> mathUtils.divide(10, 0), "divide by zero should throw exception. ");
		System.out.println("testDivide()");
	}
	
	@Test
	//@DisplayName("Test : Circle Area")
	void testCircleArea() {
		
		assertEquals(314.1592653589793, mathUtils.computeCirculeArea(10), "Failed to compute the circule radius.");
		System.out.println("testCircleArea()");
	}
	
	@Test
	@Disabled
	@DisplayName("Disable")
	void testDiable() {
		System.out.println("testDiable()");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Enabled On OS - Linx")
	void enableOnOs_Linx() {
		System.out.println("enableOnOs_Linx()");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@DisplayName("Enabled On OS - Windows")
	void enableOnOs_Windows() {
		System.out.println("enableOnOs_Windows()");
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_8)
	@DisplayName("Enabled On OS - JAVA_8")
	void enableOnOs_Jre8() {
		System.out.println("enableOnOs_Jre8()");
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_11)
	@DisplayName("Enabled On OS - JAVA_11")
	void enableOnOs_Jre11() {
		System.out.println("enableOnOs_Jre11()");
	}
	
	@Test
	@DisplayName("AssumeTrue")
	void testAssumeTrue() {
		
		boolean isAssumeTrue = false;
		
		System.out.println("testAssumeTrue() -> First");
		assumeTrue(isAssumeTrue);
		System.out.println("testAssumeTrue() -> Second");
	}
	
	@Nested
	@DisplayName("Nested Method")
	@Tag("Math")
	class AddTest{
		
		@Test
		@DisplayName("Add Posttive Number")
		void testPositive() {
			assertEquals(2, mathUtils.add(1 ,1), "testPositive() -> Should return the Correct sum.");
		}
		
		@Test
		@DisplayName("Add Negative Number")
		void testNegative() {
			assertEquals(-1, mathUtils.add(-1 ,1), "testNegative() -> Should return the Correct sum.");
		}
	}
	
	@Test
	@DisplayName("Multi Assert")
	@Tag("Math")
	void testMultiply() {
		//System.out.println("Running " + testInfo.getDisplayName() + "having Tag : " + testInfo.getTags());
		//testReporter.publishEntry("Running " + testInfo.getDisplayName() + "having Tag : " + testInfo.getTags());
		assertAll(
				()->assertEquals(4 , mathUtils.multiply(2, 2)),
				()->assertEquals(0 , mathUtils.multiply(2, 0), "multiplication should be Zero"),
				()->assertEquals(6 , mathUtils.multiply(2, 4)),
				()->assertEquals(-2 , mathUtils.multiply(2, -1))
				);
	}
	
	@RepeatedTest(4)
	@DisplayName("Repeated")
	void testRepatedTest(RepetitionInfo repetitionInfo ) {
		System.out.println("testRepatedTest() -> Repetition number is " + repetitionInfo.getCurrentRepetition());
		
	}
	
	
}
