package mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import model.Student;

public class StudentMapper implements FieldSetMapper<Student>{

	public Student mapFieldSet(FieldSet fieldSet) throws BindException {
		
		Student student = new Student();
		student.setId(fieldSet.readString(1));
		student.setName(fieldSet.readString("b"));
		student.setAge(fieldSet.readInt("c"));
		student.setScore(fieldSet.readFloat("d"));
		
		return student;
	}

}
