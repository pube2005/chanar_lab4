package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    @DisplayName("95 оноо A дүн байх ёстой")
    void ninetyFiveIsA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String result = calc.letterGrade(95);

        // Assert
        assertEquals("A", result);
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой")
    void ninetyIsExactlyA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String result = calc.letterGrade(90);

        // Assert
        assertEquals("A", result);
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой")
    void belowNinetyIsB() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String result = calc.letterGrade(89.99);

        // Assert
        assertEquals("B", result);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой")
    void sixtyIsExactlyD() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String result = calc.letterGrade(60);

        // Assert
        assertEquals("D", result);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой")
    void belowSixtyIsF() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String result = calc.letterGrade(59.99);

        // Assert
        assertEquals("F", result);
    }

    @Test
    @DisplayName("Сөрөг оноонд exception шидэх ёстой")
    void negativeScoreThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.letterGrade(-1)
        );
    }

    @Test
    @DisplayName("100-аас их оноонд exception шидэх ёстой")
    void scoreAboveHundredThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.letterGrade(101)
        );
    }

    @Test
    @DisplayName("Бүх дээд онооны нийлбэр 100 байх ёстой")
    void maximumTotalScoreIsHundred() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        double result = calc.totalScore(10, 40, 10, 10, 30);

        // Assert
        assertEquals(100.0, result, 0.0001);
    }

    @Test
    @DisplayName("Ирцийн сөрөг оноонд exception шидэх ёстой")
    void negativeAttendanceThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.totalScore(-5, 40, 10, 10, 30)
        );
    }

    @Test
    @DisplayName("Лабораторийн оноо 40-өөс хэтэрвэл exception шидэх ёстой")
    void excessiveLabScoreThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.totalScore(10, 41, 10, 10, 30)
        );
    }
}
