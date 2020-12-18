package com.bdqn1.test;


public class Subject {

  private int subjectId;
  private String subjectName;
  private int classHour;
  private int gradeId;

  @Override
  public String toString() {
    return "Subject{" +
            "subjectId=" + subjectId +
            ", subjectName='" + subjectName + '\'' +
            ", classHour=" + classHour +
            ", gradeId=" + gradeId +
            '}';
  }

  public Subject() {
  }

  public Subject(int subjectId, String subjectName, int classHour, int gradeId) {
    this.subjectId = subjectId;
    this.subjectName = subjectName;
    this.classHour = classHour;
    this.gradeId = gradeId;
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }


  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }


  public int getClassHour() {
    return classHour;
  }

  public void setClassHour(int classHour) {
    this.classHour = classHour;
  }


  public int getGradeId() {
    return gradeId;
  }

  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }

}
