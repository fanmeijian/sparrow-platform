package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdUserFile;
import com.ywsoft.standalone.framework.entity.SwdUserFilePK;

public interface UserFileRepository extends JpaRepository<SwdUserFile, SwdUserFilePK> {

	@Query("SELECT s.id FROM SwdUserFile s WHERE s.id.fileId=?1")
	List<SwdUserFilePK> findByFileId(String fileId);

}
