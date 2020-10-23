package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdFile;

public interface FileRepository extends CrudRepository<SwdFile, String> {

	@Query("SELECT s FROM SwdFile s,SwdUserFile uf WHERE s.id = uf.id.fileId AND uf.id.permission = 'LIST' AND uf.id.username IN (?1,'ANONYMOUSE','AUTHENTICATED')")
	List<SwdFile> listByPermission(String username);
	
	@Query("SELECT s FROM SwdFile s,SwdUserFile uf WHERE s.id = uf.id.fileId AND uf.id.permission = 'DOWNLOAD' AND uf.id.username IN (?1,'ANONYMOUSE','AUTHENTICATED') AND s.id=?2")
	SwdFile getByUsernameAndFileId(String username,String fileId);
}
