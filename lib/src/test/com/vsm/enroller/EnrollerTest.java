package com.vsm.enroller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnrollerTest {
				@Test void checkNoErrors() {
								var s = new Student("Vincent Samir H. Maalouf", Person.Male, 22, 6, 2004);
								
								var mgr = new StudentManager();
								mgr.addStudent(s);
								mgr.printStudents();
				}
}
