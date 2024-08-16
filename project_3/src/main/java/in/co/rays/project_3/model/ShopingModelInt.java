package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ShopingDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ShopingModelInt {
	public long add(ShopingDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ShopingDTO dto)throws ApplicationException;
	public void update(ShopingDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ShopingDTO dto)throws ApplicationException;
	public List search(ShopingDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public ShopingDTO findByPK(long pk)throws ApplicationException;
	public ShopingDTO fingByName(String name)throws ApplicationException;


}






