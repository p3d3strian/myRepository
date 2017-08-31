package launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class StudentJobLauncher {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/service.xml");
		Job job=(Job) context.getBean("studentJob");
		JobLauncher jobLauncher=(JobLauncher) context.getBean("jobLauncher");
		
		
		JobParameters jobParameters = new JobParametersBuilder().addString("filePath", "d:/test/input.csv")
				.addString("transferToPath", "c:/test").addString("transferFromPath", "d:/test")
				.addString("batchNo", "12312312").toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
