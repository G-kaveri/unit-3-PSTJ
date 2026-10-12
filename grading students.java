
import java.util.*;

class Result {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {
            if (grade < 38) {
                result.add(grade);
            } else {
                int next = ((grade / 5) + 1) * 5;

                if (next - grade < 3) {
                    grade = next;
                }

                result.add(grade);
            }
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        List<Integer> result = Result.gradingStudents(grades);

        for (int grade : result) {
            System.out.println(grade);
        }

        sc.close();
    }
}
