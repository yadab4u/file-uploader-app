package com.upload.dao;

import java.util.List;

import com.upload.model.FileModel;
import com.upload.model.FileStream;

public interface UploadDao {
    Long create(FileModel fileModel);

	List<FileModel> getRecords();

	List<FileModel> getRecord(Long id);
	
	Long saveContent(FileStream fs);

	String getContents(Long streamId);
}
