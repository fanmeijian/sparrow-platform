package com.ywsoft.standalone.framework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.entity.SwdGroup;
import com.ywsoft.standalone.framework.entity.SwdSubGroup;
import com.ywsoft.standalone.framework.entity.SwdSubGroupPK;
import com.ywsoft.standalone.framework.entity.SwdUser;
import com.ywsoft.standalone.framework.entity.ext.GroupMember;
import com.ywsoft.standalone.framework.repository.GroupUserRepository;
import com.ywsoft.standalone.framework.repository.SubGroupRepository;

/**
 * 群组服务
 * @author fanmj
 *
 */

@RestController
public class GroupService {
	
	@Autowired
	GroupUserRepository groupUserRepository;
	
	@Autowired
	SubGroupRepository subGroupRepository;

	/**
	 * 设置子组
	 * @return 
	 */
	@PutMapping("/addSubGroups")
	public ApiResponse addSubGroups(@RequestBody List<String> groups, @RequestParam(name="id") String id) {
		List<SwdSubGroup> subGroups = new ArrayList<SwdSubGroup>();
		groups.forEach(group->{
			SwdSubGroup subGroup = new SwdSubGroup();
			SwdSubGroupPK swdSubGroupPK = new SwdSubGroupPK();
			swdSubGroupPK.setGroupId(id);
			swdSubGroupPK.setSubGroupId(group);
			subGroup.setId(swdSubGroupPK);
			subGroups.add(subGroup);
		});
		subGroupRepository.saveAll(subGroups);
		return ApiResponseFactory.getNormalReponse();
	}
	
	
	/**
	 * 设置子成员
	 * @param id
	 * @return
	 */
	@GetMapping("/addGroupMembers")
	public List<SwdUser> groupUsers(@RequestBody List<String> members, @RequestParam(name="id") String id) {
		//需要递归展开子组，并且避免相互依赖的时候出现死循环
		return null;
	}
	
}
