package com.servicei;

import com.Exception.CourseNotFoundException;

import com.Exception.FacultyNotFoundException;

import com.Exception.InvalidCourseForFacultyException;

import com.Exception.StudentNotFoundException;

import com.Exception.BatchNotFoundException;

public interface Cjc {
public void addCourse() throws CourseNotFoundException;
public void viewCourse();
public void addFaculty()throws  FacultyNotFoundException, InvalidCourseForFacultyException;
public void viewFaculty();
public void addBatch() throws BatchNotFoundException;
public void viewBatch();
public void addStudent() throws StudentNotFoundException;
public void viewStudent();
}

