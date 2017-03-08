package com.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.upload.dao.UploadDao;
import com.upload.model.FileId;
import com.upload.model.FileModel;
import com.upload.model.FileStream;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UploadController { 

	@Autowired
	private UploadDao uploadDao;

	private final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@GetMapping(value = { "/fileupload", "/fileupload/{id}" })
	public List<FileModel> getRecords(@PathVariable Optional<Long> id) {
		if (id.isPresent()) {
			return (List<FileModel>) uploadDao.getRecord(id.get());
		} else {
			return uploadDao.getRecords();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/fileupload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {
		FileId fileId = new FileId();
		if (uploadfile.isEmpty()) {
			logger.error("file is empty");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		try {

			fileId = saveUploadedFiles(uploadfile);

		} catch (IOException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(fileId, HttpStatus.CREATED);

	}

	// save file
	private FileId saveUploadedFiles(MultipartFile files) throws IOException {
		FileModel fileModel = new FileModel();
		FileId fileId = new FileId();
		FileStream fs = new FileStream();
		fileModel.setContentType(files.getContentType());// string
		fileModel.setName(files.getName());// string
		fileModel.setSize(files.getSize());// long
		fileModel.setOriginalFilename(files.getOriginalFilename());

		byte[] bytes = files.getBytes();
		String stream = new String(bytes);// .toString();
		fs.setFileName(files.getOriginalFilename());
		fs.setStream(stream);
		fileId.setStreamId(uploadDao.saveContent(fs));
		fileId.setMetaDataId(uploadDao.create(fileModel));
		return fileId;
	}

	@GetMapping(value = "/filestream/{streamId}")
	public String getStream(@PathVariable Long streamId) {
		
			return uploadDao.getContents(streamId);

	}
	
}
