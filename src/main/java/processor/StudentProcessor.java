package processor;


import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemProcessor;

import model.Student;
import model.StudentResult;

public class StudentProcessor implements ItemProcessor<Student, StudentResult>,ChunkListener{
	
	private String batchNo;
	

	public StudentResult process(Student student) throws Exception {
		StudentResult studentResult = new StudentResult();
		
		studentResult.setNewId("new"+student.getId());
		studentResult.setNewName("学生姓名："+student.getName());
		studentResult.setNewAge(100+student.getAge());
		studentResult.setNewScore(100+student.getScore());
		
		return studentResult;
	}

	public void beforeChunk(ChunkContext context) {
		batchNo=(String) context.getStepContext().getJobParameters().get("batchNo");
		System.out.println("step1处理开始，批次号："+batchNo);
	}

	public void afterChunk(ChunkContext context) {
		System.out.println("step1处理结束，批次号："+batchNo);
	}

	public void afterChunkError(ChunkContext context) {
		
	}
}
