package com.bdqn1.test;

public class Grade {
  public Grade() {
  }

  public Grade(int gradeId, String gradeName) {
    this.gradeId = gradeId;
    this.gradeName = gradeName;
  }

  @Override
  public String toString() {
    return "Grade{" +
            "gradeId=" + gradeId +
            ", gradeName='" + gradeName + '\'' +
            '}';
  }

  private int gradeId;
  private String gradeName;


  public int getGradeId() {
    return gradeId;
  }

  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }


  public String getGradeName() {
    return gradeName;
  }

  public void setGradeName(String gradeName) {
    this.gradeName = gradeName;
  }

}
