package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywsoft.standalone.framework.entity.SwdSysroleFile;
import com.ywsoft.standalone.framework.entity.SwdSysroleFilePK;

public interface SysroleFileRepository extends JpaRepository<SwdSysroleFile, SwdSysroleFilePK> {

	List<SwdSysroleFile> findByIdFileId(String fileId);

	
}
