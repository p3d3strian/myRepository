package tasklet;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TransferFileTasklet implements Tasklet{

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		String transferToPath=(String) chunkContext.getStepContext().getJobParameters().get("transferToPath");
		String transferFromPath = (String) chunkContext.getStepContext().getJobParameters().get("transferFromPath");
		
		File srcFile=new File(transferFromPath);
		File destDir=new File(transferToPath);
		
		FileUtils.copyDirectory(srcFile, destDir);
		
		FileUtils.deleteDirectory(srcFile);
		
		return RepeatStatus.FINISHED;
	}

}
