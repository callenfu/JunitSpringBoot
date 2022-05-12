package com.example.demo;

import com.example.demo.student.Gender;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class DemoApplicationTests {
	@Autowired
	StudentRepository underTest;

	@Test
	void itShouldCheck(){
		//given
		String email = "qiweifu@gmail.com";
		Student student = new Student(
				"qiwei",
				email,
				Gender.FEMALE
		);
		underTest.save(student);
		//when
		boolean result = underTest.selectExistsEmail(email);

		//then
		assertThat(result).isTrue();
	}

	@Test
	void isShouldCheckWhenStudentDoesNotExist(){

	}

}
