package com.company.test_template;

import java.util.ArrayList;

abstract class GradeBookMaster {

    protected ArrayList students;
    public void computeGrades() {
        for(Student student: students) {
            double sum = 0.0;

            gradeTypeCalculate();

            double testValue = sum / student.getTestGrades().size();
            double grade = testValue + homeworkValue;
            System.out.println(student.toString() + "   " + grade);
        }
    }

    abstract void gradeTypeCalculate();
}


public class GradeBook1 extends GradeBookMaster {

    @Override
    void gradeTypeCalculate() {
        double homeworkValue = Integer.MAX_VALUE;
        for(Integer homeworkScore : student.getHomeworkScores()) {
            if(homeworkScore < homeworkValue)homeworkValue = homeworkScore;
        }
        for(Integer testGrade : student.getTestGrades()) {
            sum += testGrade;
        }
    }
}

public class GradeBook2 extends GradeBookMaster {

    @Override
    void gradeTypeCalculate() {
        double testValue = Integer.MIN_VALUE;
        for(Integer testGrade : student.getTestGrades()) {
            if(testGrade > testValue)testValue = testGrade;
        }
        for(Integer homeworkScore : student.getHomeworkScores()) {
            sum += homeworkScore;
        }
    }
}