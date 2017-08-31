package writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import model.StudentResult;

public class StudentWriter implements ItemWriter<StudentResult>{

	public void write(List<? extends StudentResult> items) throws Exception {
		
		System.out.println("step1，数据已写入数据库~~~~");
	}

}
