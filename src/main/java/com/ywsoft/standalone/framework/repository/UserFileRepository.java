package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ywsoft.standalone.framework.entity.SwdUserFile;
import com.ywsoft.standalone.framework.entity.SwdUserFilePK;

public interface UserFileRepository extends CrudRepository<SwdUserFile, SwdUserFilePK> {

	@Query("SELECT s.id FROM SwdUserFile s WHERE s.id.fileId=?1")
	List<SwdUserFilePK> findByFileId(String fileId);

}
