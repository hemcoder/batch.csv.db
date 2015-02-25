package com.genpact.batch;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ArchiveProductImportFileTasklet implements Tasklet {

	private String inputFile;
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
			throws Exception {
		// Make our destination directory and copy our input file to it
        File archiveDir = new File( "archive" );
        FileUtils.forceMkdir( archiveDir );
        FileUtils.copyFileToDirectory( new File( inputFile ), archiveDir );

        // We're done...
        return RepeatStatus.FINISHED;
	}

}
