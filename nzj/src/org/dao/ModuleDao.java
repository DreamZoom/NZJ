package org.dao;

import java.util.List;

public interface ModuleDao {
	//-----------------------------------增---------------------------------------
	//-----------------------------------删---------------------------------------
	//-----------------------------------改---------------------------------------
	//-----------------------------------查---------------------------------------
	/**
	 * 4.1获取模块列表
	 * @return
	 */
	public List getModuleList();
	/**
	 * 4.2获取员工的模块权限列表
	 * sid：从session中获取的员工id号
	 * @param sid
	 * @return
	 */
	public List<Long> getModuleListByStaffId(long sid);
}
