package com.ywsoft.standalone.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	 * 设置组成员
	 */
	@PutMapping("/groupMember/{id}")
	public void groupMember(@RequestBody String members, @PathVariable(name="id") String id) {
		
	}
	
	/**
	 * 返回组下面的所有用户及子组，但不展开
	 * @param id
	 * @return
	 */
	@GetMapping("/groupMember/{id}")
	public GroupMember groupMember(@PathVariable(name="id") String id) {
		
		return new GroupMember(subGroupRepository.findByGroupId(id),groupUserRepository.findByGroupId(id));
	}
	
	
	/**
	 * 展开所有的组并去重，最后获取到最终的用户列表
	 * @param id
	 * @return
	 */
	@GetMapping("/groupUsers/{id}")
	public List<SwdUser> groupUsers(@PathVariable(name="id") String id) {
		//需要递归展开子组，并且避免相互依赖的时候出现死循环
		return null;
	}
	
}
