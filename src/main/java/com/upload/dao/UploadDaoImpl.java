package com.upload.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upload.model.FileModel;
import com.upload.model.FileStream;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
@Repository
public class UploadDaoImpl implements UploadDao {
	
    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public Long create(FileModel fileModel) {
		 entityManager.persist(fileModel);
		 return fileModel.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileModel> getRecords() {
		Query query = entityManager.createNativeQuery("SELECT * from  file_model",FileModel.class);
		List<FileModel> records = query.getResultList();
		return records;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FileModel> getRecord(Long id) {
		Query query = entityManager.createQuery("SELECT fm from FileModel fm where fm.id=:column1").setParameter("column1", id.longValue());
	      return query.getResultList( );
	}

	@Override
	public Long saveContent(FileStream fileStream) {
		 entityManager.persist(fileStream);
		 return fileStream.getId();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getContents(Long streamId) {
		Query query = entityManager.createQuery("SELECT fs from FileStream fs where fs.id=:id").setParameter("id", streamId);
		List<FileStream> fs =  new ArrayList<FileStream>();
		fs=query.getResultList();
		return fs.get(0).getStream();
	}
	
	
	


}
