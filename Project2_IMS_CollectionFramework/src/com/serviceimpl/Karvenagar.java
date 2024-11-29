package com.serviceimpl;
import java.util.*;

import com.Exception.CourseNotFoundException;
import com.Exception.FacultyNotFoundException;
import com.Exception.InvalidCourseForFacultyException;
import com.Exception.StudentNotFoundException;
import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;
import com.servicei.Cjc;
import com.Exception.BatchNotFoundException;

public class Karvenagar implements Cjc{

List<Course> clist=new ArrayList<>();	
List<Faculty> flist=new ArrayList<>();
List<Batch> blist=new ArrayList<>();
List<Student> slist=new ArrayList<>();

/* implementation of all methods*/
Course c;
Faculty f;
Batch b;
Scanner sc=new Scanner(System.in);
	@Override
	public void addCourse() throws CourseNotFoundException{
		c=new Course();
		System.out.println("Enter The Course id");
		int id=sc.nextInt();
		int temp=id;
		int count=0;
		while(temp>0) {
			temp=temp/10;
			count++;
		}
		if(count==3) {
			c.setCid(id);
		}
		else
		{
			throw new CourseNotFoundException("Invalid Course id");
		}
		System.out.println("Enter The Course name");
		c.setCname(sc.next()+sc.nextLine());
		clist.add(c);
	}

	@Override
	public void viewCourse() {
		Iterator<Course> itr=clist.iterator();
		while(itr.hasNext()) {
			Course c=itr.next();
			System.out.println("course id is:"+c.getCid());
			System.out.println("course name is:"+c.getCname());
		}
		
	}

	@Override
	public void addFaculty() throws FacultyNotFoundException,  InvalidCourseForFacultyException {
		f=new Faculty();
		System.out.println("Enter Faculty id here");
		int id=sc.nextInt();
		int temp1=id;
		int count=0;
		while(temp1>0) {
			temp1=temp1/10;
			count++;
		}
		if(count==3) {
			f.setFid(id);
		}
		else
		{
			throw new  FacultyNotFoundException("Invalid faculty id");
		}
		System.out.println("Enter Faculty name here");
		f.setFname(sc.next()+sc.nextLine());
		
		System.out.println("Enter course id to assign ");
		int crid = sc.nextInt();
		for(Course cr : clist)
		{
			
			if(cr.getCid()==crid)
			{
				 f.setCourse(cr);
				 flist.add(f);
				
			}
			else
			{
			throw new InvalidCourseForFacultyException("invalid course id ");
			}
			
		}
       
		
	}

	@Override
	public void viewFaculty() {
		
		Iterator<Faculty> itr1=flist.iterator();
		while(itr1.hasNext()) {
			Faculty f=itr1.next();
			System.out.println("faculty id is"+f.getFid());
			System.out.println("faculty name is:"+f.getFname());
			System.out.println(f.getCourse().getCid());
			System.out.println(f.getCourse().getCname());
		}
	}

	@Override
	public void addBatch() throws BatchNotFoundException {
		
		b=new Batch();
	System.out.println("Enter the batch id");
	int id=sc.nextInt();
	int temp=id;
	int count=0;
	while(temp>0) {
		temp=temp/10;
		count++;
	}
	if(count==3) {
		b.setBid(id);
	}
	else
	{
		throw new BatchNotFoundException("invalid batch id");
	}
	System.out.println("Enter the batch name");
	b.setBname(sc.next()+sc.nextLine());
	System.out.println("Enter Faculty id To assign A Particular Batch ");
	
	
	int bid=sc.nextInt();
	for(Faculty fr:flist ) {
		if(fr.getFid()==bid) {
			b.setFaculty(f);
			blist.add(b);
		}
	}
		
	
	
	}

	@Override
	public void viewBatch() {
		Iterator<Batch> itr2=blist.iterator();
		while(itr2.hasNext()) {
			Batch b=itr2.next();
			System.out.println("batch id is:"+b.getBid());
			System.out.println("batch name is:"+b.getBname());
			System.out.println(b.getFaculty().getFid());
			System.out.println(b.getFaculty().getFname());
	
		}
		
	}

	@Override
	public void addStudent() throws StudentNotFoundException {
		Student s=new Student();
		System.out.println("Enter student id");
		int id=sc.nextInt();
		int temp=id;
		int count=0;
		while(temp>0) {
			temp=temp/10;
			count++;
		}
		if(count==3) {
			s.setSid(id);
		}
		else
		{
			throw new StudentNotFoundException("invalid student id");
		}
		System.out.println("Enter student name");
		s.setSname(sc.next()+sc.nextLine());
		
		System.out.println("Enter a batch id to assign for the student");
		int sid=sc.nextInt();
		for(Batch bk:blist) {
			if(bk.getBid()==sid) {
				s.setBatch(b);
				slist.add(s);

			}
		}
		
		}

	@Override
	public void viewStudent() {
		Iterator<Student> itr3=slist.iterator();
		while(itr3.hasNext()) {
			Student s=itr3.next();
			System.out.println("student id is:"+s.getSid());
			System.out.println("student name is:"+s.getSname());
			System.out.println(s.getBatch().getBid());
			System.out.println(s.getBatch().getBname());
			System.out.println(s.getBatch().getFaculty().getFid());
			System.out.println(s.getBatch().getFaculty().getFname());
			System.out.println(s.getBatch().getFaculty().getCourse().getCid());
			System.out.println(s.getBatch().getFaculty().getCourse().getCname());
			
		
		
	}

}
}

