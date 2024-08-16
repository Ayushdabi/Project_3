package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.InventoryDTO;
import in.co.rays.project_3.dto.TransDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface TransModelInt {
	public long add(TransDTO dto) throws ApplicationException, DuplicateRecordException;

	public void delete(TransDTO dto) throws ApplicationException;

	public void update(TransDTO dto) throws ApplicationException, DuplicateRecordException;

	public List list() throws ApplicationException;

	public List list(int pageNo, int pageSize) throws ApplicationException;

	public List search(TransDTO dto) throws ApplicationException;

	public List search(TransDTO dto, int pageNo, int pageSize) throws ApplicationException;

	public TransDTO findByPK(long pk) throws ApplicationException;

	public TransDTO fingByName(String name) throws ApplicationException;

}
