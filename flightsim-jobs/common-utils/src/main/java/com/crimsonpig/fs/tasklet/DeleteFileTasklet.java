package com.crimsonpig.fs.tasklet;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class DeleteFileTasklet implements Tasklet  {

	private Resource fileToDelete;
	
	public void setFileToDelete(Resource fileToDelete) {
		this.fileToDelete = fileToDelete;
	}

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		File toDelete = fileToDelete.getFile();
		toDelete.delete();
		return RepeatStatus.FINISHED;
	}

}
