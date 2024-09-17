package com.pm.marksheet;

public class TestMarksheet {

	public static void main(String[] args) throws Exception{
        testAdd();
        //testUpdate();
        //testDelete();
	    //testFindByPk();
	}

	public static void testAdd() throws Exception {
		MarksheetModal modal = new MarksheetModal();
		MarksheetBean bean = new MarksheetBean();

		bean.setId(5); 
		bean.setRollNo(15);
		bean.setName("peter");
		bean.setPhysics(72);
		bean.setChemistry(81);
		bean.setMaths(69);

		modal.add(bean);
	}
	
	public static void testUpdate() throws Exception {
		MarksheetModal modal = new MarksheetModal();
		MarksheetBean bean = new MarksheetBean();

		bean.setId(5);
		bean.setRollNo(15);
		bean.setName("peter1");
		bean.setPhysics(72);
		bean.setChemistry(81);
		bean.setMaths(69);

		modal.update(bean);
	}

	public static void testDelete() throws Exception {
		MarksheetModal modal = new MarksheetModal();
		
		modal.delete(5);
	}
	
	public static void testFindByPk() throws Exception {
		MarksheetModal modal = new MarksheetModal();
		
		MarksheetBean testBean = modal.findByPk(4);
		
		if (testBean != null) {
			System.out.print(testBean.getId());
			System.out.print("\t" + testBean.getRollNo());
			System.out.print("\t" + testBean.getName());
			System.out.print("\t" + testBean.getPhysics());
			System.out.print("\t" + testBean.getChemistry());
			System.out.println("\t" + testBean.getMaths());
		} else {
			System.out.println("id not found");
		}
	}
}
