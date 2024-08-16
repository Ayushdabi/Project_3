 package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.impl.SessionImpl;

import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.util.HibDataSource;
import in.co.rays.project_3.util.JDBCDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Jasper functionality Controller. Performs operation for Print pdf of
 * MarksheetMeriteList
 *
 * @authorKanak soni
 */
@WebServlet(name = "JasperCtl", urlPatterns = { "/ctl/JasperCtl" })
public class JasperCtl extends BaseCtl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// Step 1 hold report to jasperReport
			JasperReport jasperReport = JasperCompileManager
					.compileReport("C:\\Users\\udayd\\JaspersoftWorkspace\\MyReports\\Anshul.jrxml");

			HttpSession session = request.getSession(true);
			UserDTO dto = (UserDTO) session.getAttribute("user");
			dto.getFirstName();   
			dto.getLastName();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ID", 1l);
			java.sql.Connection conn = null;

			ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.system");

			String Database = rb.getString("DATABASE");

			if ("Hibernate".equalsIgnoreCase(Database)) {
				conn = ((SessionImpl) HibDataSource.getSession()).connection();
			}

			if ("JDBC".equalsIgnoreCase(Database)) {
				conn = JDBCDataSource.getConnection();
			}

			// Step 2 For print JasperReport
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);

			// Step 3 For convert report to pdf
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			// Step 4 For show pdf
			response.setContentType("application/pdf");
			response.getOutputStream().write(pdf);
			response.getOutputStream().flush();

		} catch (Exception e) {

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return null;
	}

}