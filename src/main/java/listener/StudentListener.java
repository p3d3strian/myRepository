package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class StudentListener implements JobExecutionListener{

	private static final Logger LOG=LoggerFactory.getLogger(StudentListener.class);
	
	public void beforeJob(JobExecution jobExecution) {
		
		LOG.info("批处理开始,批次号[{}]",jobExecution.getJobParameters().getString("batchNo"));
		
		jobExecution.getExecutionContext().put("batchNo",jobExecution.getJobParameters().getString("batchNo") );
	}

	public void afterJob(JobExecution jobExecution) {
		
		LOG.info("批处理结束，批次号[{}]",jobExecution.getJobParameters().getString("batchNo"));
	}

}
