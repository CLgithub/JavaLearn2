package day39_spring.demo6.service;

import org.springframework.stereotype.Service;

@Service(value="roleService")
public class RoleServiceImpl implements RoleService {

	public int add() {
		System.out.println("添加角色");
		int i=1/0;
		return 2;
	}

	public void delete() {
		System.out.println("删除角色");
	}

	public void update() {
		System.out.println("修改角色");
	}

	public void query() {
		System.out.println("查询角色");
		int d=1/0;
	}

}
