package com.upload;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

public class FileUploaderTest extends FileUploaderAppApplicationTest{

	
	@Test
	public void testFileupLoad() throws Exception{
		MockMultipartFile file = new MockMultipartFile("file", "originalFilename ", "contentType" , "content".getBytes());
		mockMvc.perform(
				fileUpload(base_url + "/fileupload").file(file)).andExpect(status().isCreated());
	}
	
	

	@Test
	public void testFileMetadata() throws Exception{
	
		mockMvc.perform(
				get(base_url + "/fileupload/1"))
					.andExpect(jsonPath("$.[*].originalFilename",everyItem(equalTo("samplefile.txt"))));
	}
	
	@Test
	public void testFileUpLoadFail() throws Exception{
		MockMultipartFile file = new MockMultipartFile("file", "originalFilename ", "contentType" , "".getBytes());
		//file=null;
		mockMvc.perform(
				fileUpload(base_url + "/fileupload").file(file)).andExpect(status().isBadRequest());
	}
	
	@Test
	public void uploadFileStatusTest() throws Exception{
	
		mockMvc.perform(
				get(base_url + "/fileupload"))
					.andExpect(status().isOk());
	}
	
	
	@Test
	public void getStreamTest() throws Exception{
	
		mockMvc.perform(
				get(base_url + "/filestream/1"))
					.andExpect(status().isOk());
	}
}
