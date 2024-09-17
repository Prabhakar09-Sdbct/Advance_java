package com.pm.task;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaskTest {

	public static void main(String[] args) throws Exception {
		testAdd();
		testUpdate();
		testSearch();
		testDelete();
	}

	private static void testAdd() throws Exception {
		TaskBean bean = new TaskBean();
		bean.setId(1);
		bean.setTaskName("usecase");
		bean.setDescription("make it happen !");
		bean.setAssignTo("Prabhakar Mandloi");
		bean.setDueDate(new Date());
		bean.setPriority("immediate");
		bean.setStatus("in progress");
		
		TaskModel model = new TaskModel();
		model.add(bean);
	}

	private static void testUpdate() throws Exception {
		TaskBean bean = new TaskBean();
		bean.setId(1);
		bean.setTaskName("usecase");
		bean.setDescription("make it happen !");
		bean.setAssignTo("Prabhakar Mandloi");
		bean.setDueDate(new Date());
		bean.setPriority("immediate");
		bean.setStatus("Done");
		
		TaskModel model = new TaskModel();
		model.update(bean);
	}

	private static void testDelete() throws Exception {
		TaskModel model = new TaskModel();
		model.delete(1);
		
	}

	private static void testSearch() throws Exception {
		TaskBean bean = new TaskBean();
		bean.setId(1);
		bean.setTaskName("usecase");
		bean.setDescription("make it happen !");
		bean.setAssignTo("Prabhakar Mandloi");
		bean.setDueDate(new Date());
		bean.setPriority("immediate");
		bean.setStatus("Done");
		
		TaskModel model = new TaskModel();
		List list = model.search(bean, 1, 5);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			TaskBean object = (TaskBean) it.next();
			System.out.println("Assign To : " + object.getAssignTo());
		}
	}

}
