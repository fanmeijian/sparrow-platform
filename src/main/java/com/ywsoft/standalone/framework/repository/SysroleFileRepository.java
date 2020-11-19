package com.ywsoft.standalone.framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ywsoft.standalone.framework.entity.SwdSysroleFile;
import com.ywsoft.standalone.framework.entity.SwdSysroleFilePK;
import com.ywsoft.standalone.framework.entity.ext.SysroleFile;

public interface SysroleFileRepository extends JpaRepository<SwdSysroleFile, SwdSysroleFilePK> {

	@Query("SELECT NEW com.ywsoft.standalone.framework.entity.ext.SysroleFile(s.id,r.name) FROM SwdSysroleFile s,SwdSysrole r WHERE s.id.fileId=?1 AND s.id.sysroleId=r.id")
	List<SysroleFile> findByFileId(String fileId);

	
}
