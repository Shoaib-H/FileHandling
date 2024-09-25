package com.sep25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StudentDatabase {
	Scanner sc = new Scanner(System.in);

	FileInputStream fi = null;
	FileOutputStream fo = null;
	ObjectInputStream oi = null;
	ObjectOutputStream oo = null;
	String Path1 = "C:\\Users\\brill\\Desktop\\Core Java\\FileHandling\\src\\DataBase";

	void DataBase() {
		try {
			fi = new FileInputStream(Path1);
			fo = new FileOutputStream(Path1);
			oo = new ObjectOutputStream(fo);
			oi = new ObjectInputStream(fi);

			Student s1 = new Student(1, "Shoaib", 100);
			Student s2 = new Student(2, "Sagar", 95);
			System.out.println("Enter Number of Students");
			int size = sc.nextInt();
			Student[] students = new Student[size];
			for (int i = 0; i < size; i++) {
				System.out.println("Enter Details of Students");

				System.out.println("Enter Roll Number ");
				int r = sc.nextInt();

				System.out.println("Enter Name of Student");
				String n = sc.next();

				System.out.println("Enter Marks of Student ");
				int m = sc.nextInt();

				students[i] = new Student(r, n, m);
				oo.writeObject("Student Written to file " + students[i]);
			}
			oo.writeObject(s1);
			System.out.println("Student written to file " + s1);

			oo.writeObject(s2);
			System.out.println("Student written to file " + s2);

			for (int i = 0; i < students.length; i++) {
				System.out.println("Student Written to file " + students[i]);
			}

			int i = 0;
			while ((i = fi.read()) != -1)
				System.out.println((char) i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StudentDatabase s1 = new StudentDatabase();
		s1.DataBase();
	}
}
