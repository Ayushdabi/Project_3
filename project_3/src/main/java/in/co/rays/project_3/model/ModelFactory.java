package in.co.rays.project_3.model;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * ModelFactory decides which model implementation run
 * 
 * @authorKanak Soni
 *
 */
public final class ModelFactory {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.system");
	private static final String DATABASE = rb.getString("DATABASE");
	private static ModelFactory mFactory = null;
	private static HashMap modelCache = new HashMap();

	private ModelFactory() {

	}

	public static ModelFactory getInstance() {
		if (mFactory == null) {
			mFactory = new ModelFactory();
		}
		return mFactory;
	}

	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetModel = (MarksheetModelInt) modelCache.get("marksheetModel");
		if (marksheetModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				marksheetModel = new MarksheetModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetModel = new MarksheetModelJDBCImpl();
			}
			modelCache.put("marksheetModel", marksheetModel);
		}
		return marksheetModel;
	}

	public CollegeModelInt getCollegeModel() {
		CollegeModelInt collegeModel = (CollegeModelInt) modelCache.get("collegeModel");
		if (collegeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				collegeModel = new CollegeModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				collegeModel = new CollegeModelJDBCImpl();
			}
			modelCache.put("collegeModel", collegeModel);
		}
		return collegeModel;
	}
	public TransModelInt getTransModel() {
		TransModelInt TransModel = (TransModelInt) modelCache.get("TransModel");
		if (TransModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				TransModel = new TransModelHibImpl();

			}
			if ("JDBC".equals(DATABASE)) {
				TransModel = new TransModelHibImpl();
			}
			modelCache.put("collegeModel", TransModel);
		}
		return TransModel;
	}

	public RoleModelInt getRoleModel() {
		RoleModelInt roleModel = (RoleModelInt) modelCache.get("roleModel");
		if (roleModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				roleModel = new RoleModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				roleModel = new RoleModelJDBCImpl();
			}
			modelCache.put("roleModel", roleModel);
		}
		return roleModel;
	}

	public UserModelInt getUserModel() {

		UserModelInt userModel = (UserModelInt) modelCache.get("userModel");
		if (userModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				userModel = new UserModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				userModel = new UserModelJDBCImpl();
			}
			modelCache.put("userModel", userModel);
		}

		return userModel;
	}

	public SupplierModelInt getSupplierModel() {

		SupplierModelInt SupplierModel = (SupplierModelInt) modelCache.get("SupplierModel");
		if (SupplierModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				SupplierModel = new SupplierModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				SupplierModel = new SupplierModelHibImp();
			}
			modelCache.put("SupplierModel", SupplierModel);
		}

		return SupplierModel;
	}

	public InventoryModelInt getInventoryModel() {

		InventoryModelInt InventoryModel = (InventoryModelInt) modelCache.get("InventoryModel");
		if (InventoryModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				InventoryModel = new InventoryModelHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				InventoryModel = new InventoryModelHibImpl();
			}
			modelCache.put("InventoryModel", InventoryModel);
		}

		return InventoryModel;
	}

	public StudentModelInt getStudentModel() {
		StudentModelInt studentModel = (StudentModelInt) modelCache.get("studentModel");
		if (studentModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				studentModel = new StudentModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				studentModel = new StudentModelJDBCImpl();
			}
			modelCache.put("studentModel", studentModel);
		}

		return studentModel;
	}

	public CourseModelInt getCourseModel() {
		CourseModelInt courseModel = (CourseModelInt) modelCache.get("courseModel");
		if (courseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				courseModel = new CourseModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				courseModel = new CourseModelJDBCImpl();
			}
			modelCache.put("courseModel", courseModel);
		}

		return courseModel;
	}

	public TimetableModelInt getTimetableModel() {

		TimetableModelInt timetableModel = (TimetableModelInt) modelCache.get("timetableModel");

		if (timetableModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				timetableModel = new TimetableModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				timetableModel = new TimetableModelJDBCImpl();
			}
			modelCache.put("timetableModel", timetableModel);
		}

		return timetableModel;
	}

	public SubjectModelInt getSubjectModel() {
		SubjectModelInt subjectModel = (SubjectModelInt) modelCache.get("subjectModel");
		if (subjectModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				subjectModel = new SubjectModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				subjectModel = new SubjectModelJDBCImpl();
			}
			modelCache.put("subjectModel", subjectModel);
		}

		return subjectModel;
	}

	public FacultyModelInt getFacultyModel() {
		FacultyModelInt facultyModel = (FacultyModelInt) modelCache.get("facultyModel");
		if (facultyModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				facultyModel = new FacultyModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				facultyModel = new FacultyModelJDBCImpl();
			}
			modelCache.put("facultyModel", facultyModel);
		}

		return facultyModel;
	}

	public ProductModelInt getProductModel() {
		ProductModelInt productModel = (ProductModelInt) modelCache.get("productModel");
		if (productModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			modelCache.put("productModel", productModel);
		}
		return productModel;
	}

	public OrderModelInt getOrderModel() {
		OrderModelInt OrderModel = (OrderModelInt) modelCache.get("OrderModel");
		if (OrderModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				OrderModel = new OrderModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				OrderModel = new OrderModelHibImp();
			}
			modelCache.put("OrderModel", OrderModel);
		}
		return OrderModel;
	}

	public ShopingModelInt getShopingModel() {

		ShopingModelInt shopingModel = (ShopingModelInt) modelCache.get("shopingModel");

		if (shopingModel == null) {

			if ("Hibernate".equals(DATABASE)) {
				shopingModel = new ShopingModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				shopingModel = new ShopingModelHibImp();
			}
			modelCache.put("shopingModel", shopingModel);

		}
		return shopingModel;

	}

	public ProjectModelInt getProjectModel() {

		ProjectModelInt ProjectModel = (ProjectModelInt) modelCache.get("ProjectModel");

		if (ProjectModel == null) {

			if ("Hibernate".equals(DATABASE)) {
				ProjectModel = new ProjectModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				ProjectModel = new ProjectModelHibImp();
			}
			modelCache.put("ProjectModel", ProjectModel);

		}
		return ProjectModel;

	}

	public AtmModelInt getAtmModel() {

		AtmModelInt AtmModel = (AtmModelInt) modelCache.get("AtmModel");

		if (AtmModel == null) {

			if ("Hibernate".equals(DATABASE)) {
				AtmModel = new AtmModelHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				AtmModel = new AtmModelHibImpl();
			}
			modelCache.put("AtmModel", AtmModel);

		}
		return AtmModel;

	}
}
