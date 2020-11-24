package com.ywsoft.standalone.framework.service;

import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ywsoft.standalone.framework.DataPermission;
import com.ywsoft.standalone.framework.entity.ext.MenuTree;
import com.ywsoft.standalone.framework.repository.MenuRepository;
import com.ywsoft.standalone.framework.repository.SysroleRepository;
import com.ywsoft.standalone.framework.repository.UserRepository;

import net.bytebuddy.asm.Advice.Exit;

@RestController
public class MenuService {

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	SysroleRepository sysroleRepository;
	
	@DataPermission(path = "/menuTree", permission = "LIST")
	@GetMapping("/menuTrees")
	public ApiResponse menuTree() {
		List<MenuTree> menuTrees = new ArrayList<MenuTree>();
		
		menuRepository.findByParentId(BigInteger.valueOf(0)).forEach(o -> {
			o.getName();
			MenuTree menuTree = new MenuTree(o);
			menuTrees.add(menuTree);
			buildMenuTree(menuTree);

		});

		return ApiResponseFactory.getNormalReponse(menuTrees);
	}

	private void buildMenuTree(MenuTree menuTree) {
		menuRepository.findByParentId(BigInteger.valueOf(Long.parseLong(menuTree.getId()))).forEach(o -> {
			MenuTree menuTree1 = new MenuTree(o);
			menuTree.getChildren().add(menuTree1);
			buildMenuTree(menuTree1);

		});
	}

	/***
	 * 找父菜单，并将自己作为他的子菜单
	 * 
	 * @param menuTree
	 */
	private void buildUserMenuTree(MenuTree menuTree, MenuTree userMenuTree) {

		if (menuTree.getChildren().size() > 0 && userMenuTree.getChildren().size() > 0) {
			// 如果自己本身没有子菜单，则不需要再递归了
			MenuTree foundTree = null;
			for (MenuTree o : userMenuTree.getChildren()) {
				if (o.getId().equals(menuTree.getChildren().get(0).getId())) {
					foundTree = o;
					buildUserMenuTree(menuTree.getChildren().get(0), o);
					return;
				}
			}

			if (foundTree == null) {
				userMenuTree.getChildren().add(menuTree.getChildren().get(0));
			}

		}

		// 通过将自己的树与整个大树从上往上比，发现没找到的老爸就把自己老爸加进去；
		if (userMenuTree.getChildren().size() == 0 && menuTree.getChildren().size() > 0)
			userMenuTree.getChildren().add(menuTree.getChildren().get(0));

	}

	/***
	 * 构建自己往上的一颗树，然后再与整颗大树匹配，从而组成完整的大树
	 */
	private void buildMyTree(MenuTree menuTree,List<MenuTree> tmpList) {
		
		if (menuTree.getParentId() == BigInteger.valueOf(0)) {
			tmpList.add(menuTree);
		} else {
			MenuTree parenTree = new MenuTree(menuRepository.findById(menuTree.getParentId().toString()).get());
			parenTree.getChildren().add(menuTree);
			if (parenTree.getParentId() != BigInteger.valueOf(0)) {
				buildMyTree(parenTree, tmpList);
			}else {
				tmpList.add(parenTree);
			}
		}

	}

	/***
	 * 获取当前用户的菜单树
	 * 
	 * @return
	 */
	@DataPermission(path = "", permission = "")
	@GetMapping("/userMenuTrees")
	public ApiResponse userMenuTrees(final Principal principal) {
		// get user menus by username
		List<MenuTree> userMenuTrees = new ArrayList<MenuTree>();

		userRepository.findById(principal.getName()).get().getSwdMenus().forEach(o -> {
//			MenuTree menuTree = new MenuTree(o);
			//先将自己往上找到完整根树
			List<MenuTree> tmpList = new ArrayList<MenuTree>();
			buildMyTree(new MenuTree(o), tmpList);
			MenuTree rooTree = tmpList.get(0);
			
			//将自己加到整个大树
			if (userMenuTrees.size() == 0) {
				//如果是第一颗根树，则直接增加进去
				userMenuTrees.add(rooTree);
			}else {
				//否则就递归检查大树，然后加进去
				MenuTree foundTree = null;
				for (MenuTree t : userMenuTrees) {
					if (t.getId().equals(rooTree.getId())) {
						//在大树里找到，则开始向下，即子树开始
						foundTree = t;
						buildUserMenuTree(rooTree, t);
						break;
					}
				}
				if (foundTree == null) {
					// 如果都没有找到，那说明是一个根节点
					userMenuTrees.add(rooTree);
				}
			}
		});
		return ApiResponseFactory.getNormalReponse(userMenuTrees);
	}
	
	
	
	
	/***
	 * 获取角色菜单
	 */
	@GetMapping("/sysroleMenuTrees")
	public ApiResponse sysroleMenuTrees(@RequestParam(name = "sysroleId") String sysroleId){
		// get user menus by username
				List<MenuTree> sysroleMenuTrees = new ArrayList<MenuTree>();

				sysroleRepository.findById(sysroleId).get().getSwdMenus().forEach(o -> {
//					MenuTree menuTree = new MenuTree(o);
					//先将自己往上找到完整根树
					List<MenuTree> tmpList = new ArrayList<MenuTree>();
					buildMyTree(new MenuTree(o), tmpList);
					MenuTree rooTree = tmpList.get(0);
					
					//将自己加到整个大树
					if (sysroleMenuTrees.size() == 0) {
						//如果是第一颗根树，则直接增加进去
						sysroleMenuTrees.add(rooTree);
					}else {
						//否则就递归检查大树，然后加进去
						MenuTree foundTree = null;
						for (MenuTree t : sysroleMenuTrees) {
							if (t.getId().equals(rooTree.getId())) {
								//在大树里找到，则开始向下，即子树开始
								foundTree = t;
								buildUserMenuTree(rooTree, t);
								break;
							}
						}
						if (foundTree == null) {
							// 如果都没有找到，那说明是一个根节点
							sysroleMenuTrees.add(rooTree);
						}
					}
				});
				return ApiResponseFactory.getNormalReponse(sysroleMenuTrees);
	}
}
