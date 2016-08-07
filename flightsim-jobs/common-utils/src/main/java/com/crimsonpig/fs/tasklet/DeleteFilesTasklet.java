package com.crimsonpig.fs.tasklet;

import java.io.File;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class DeleteFilesTasklet implements Tasklet  {

	private List<Resource> filesToDelete;
	
	public void setFilesToDelete(List<Resource> fileToDelete) {
		this.filesToDelete = fileToDelete;
	}

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		for(Resource fileToDelete : filesToDelete){
			File toDelete = fileToDelete.getFile();
			toDelete.delete();
		}
		return RepeatStatus.FINISHED;
	}

}
