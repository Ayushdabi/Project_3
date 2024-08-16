package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.ProjectDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.ProductModelInt;
import in.co.rays.project_3.model.ProjectModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/ProjectCtl" })

public class ProjectCtl extends BaseCtl{
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CollegeCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("projectName"))) {
			request.setAttribute("projectName", PropertyReader.getValue("error.require", "projectName"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("projectName"))) {
			request.setAttribute("projectName", "projectName must contain alphabets only");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("teamName"))) {
			request.setAttribute("teamName", PropertyReader.getValue("error.require", "teamName"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("submitDate"))) {
			request.setAttribute("submitDate", PropertyReader.getValue("error.require", "submitDate"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("ProjectNo"))) {
			request.setAttribute("ProjectNo", PropertyReader.getValue("error.require", "ProjectNo"));
			pass = false;
		
		}
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		ProjectDTO dto = new ProjectDTO();
		dto.setProjectName(request.getParameter("projectName"));
		dto.setTeamName(request.getParameter("teamName"));
		dto.setSubmitDate(DataUtility.getDate(request.getParameter("submitDate")));
		dto.setProjectNo(request.getParameter("ProjectNo"));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		ProjectModelInt model = ModelFactory.getInstance().getProjectModel();
		if (id > 0 || op != null) {
			ProjectDTO dto;
			try {
				dto = model.findByPK(id);
		
				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("in project dopost method");

		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));

		ProjectModelInt model = ModelFactory.getInstance().getProjectModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			ProjectDTO dto = (ProjectDTO) populateDTO(request);

			try {
				if (id > 0) {
					dto.setId(id);
					model.update(dto);
					ServletUtility.setDto(dto, request);

					ServletUtility.setSuccessMessage("Record Successfully Updated", request);

				} else {
					System.out.println("college add" + dto + "id...." + id);
					// long pk
					model.add(dto);
					ServletUtility.setSuccessMessage("Record Successfully Saved", request);
				}
				ServletUtility.setDto(dto, request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("ProductName Already Exists", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.PROJECT_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.PROJECT_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.PROJECT_VIEW;
	}

}


