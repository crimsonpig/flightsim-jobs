package com.crimsonpig.fs.tasklet;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class TruncateTableTasklet implements Tasklet {

	private String table;
	private DataSource dataSource;
	
	public void setTable(String table) {
		this.table = table;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		JdbcTemplate template = new JdbcTemplate(this.dataSource);
		template.execute("TRUNCATE TABLE "+this.table);
		return RepeatStatus.FINISHED;
	}

}
