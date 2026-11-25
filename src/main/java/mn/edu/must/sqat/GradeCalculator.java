package mn.edu.must.sqat;

public class GradeCalculator {

    public String letterGrade(double score) {
        validateScore(score, 100, "Нийт оноо");

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public double totalScore(double att, double lab,
                             double quiz1, double quiz2,
                             double exam) {

        validateScore(att, 10, "Ирц");
        validateScore(lab, 40, "Лаборатори");
        validateScore(quiz1, 10, "Сорил 1");
        validateScore(quiz2, 10, "Сорил 2");
        validateScore(exam, 30, "Шалгалт");

        return att + lab + quiz1 + quiz2 + exam;
    }

    private void validateScore(double score, double max,
                               String name) {

        if (!Double.isFinite(score) || score < 0 || score > max) {
            throw new IllegalArgumentException(
                name + " 0-" + max + " хооронд байх ёстой."
            );
        }
    }
}
