package com.jwlry.dljs.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.jwlry.dljs.constants.ResponseMessage;
import com.jwlry.dljs.repository.BaseRepository;
import com.jwlry.dljs.response.ApiResponse;
//import net.minidev.json.JSONObject;

public abstract class BaseService<T> {
	private final Logger log = Logger.getLogger(this.getClass());

	private BaseRepository<T> repository;

	public BaseService(BaseRepository<T> baseRepository) {
		this.repository = baseRepository;
	}

	public ApiResponse<List<T>> getAll() {
		return ApiResponse.success(ResponseMessage.FETCH_SUCCESS.getMessage(), repository.findAll());
	}

	public ApiResponse<T> create(T entity) {
		log.info(entity);
		return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), repository.save(entity));

	}

	public  ApiResponse<T> modify(T entity)
	{
		return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), repository.save(entity));
	}

//	public ApiResponse<JSONObject> getAllUnapproved(int page, int size) {
//		return ApiResponse.success(ResponseMessage.FETCH_SUCCESS.getMessage(), null);
//	}
//
//	public ApiResponse<JSONObject> getAllApproved(int page, int size) {
//		return ApiResponse.success(ResponseMessage.FETCH_SUCCESS.getMessage(), null);
//	}
//
//	public ApiResponse<JSONObject> getAllUnapprovedFilter(SearchFilterDTO<T> filterDTO) {
//		log.info("filterDTO Unapproved....>>>>>" + filterDTO);
//		return ApiResponse.success(ResponseMessage.FETCH_SUCCESS.getMessage(), null);
//	}
//
//	public ApiResponse<JSONObject> getAllApprovedFilter(SearchFilterDTO<T> filterDTO) {
//		System.out.println("filterDTO Approved.........." + filterDTO);
//		log.info("filterDTO Approved....>>>>>" + filterDTO);
//		return ApiResponse.success(ResponseMessage.FETCH_SUCCESS.getMessage(), null);
//	}
//
//	public ApiResponse<T> get(String id) {
//		Optional<T> entity = repository.findById(id);
//		if (!entity.isPresent()) {
//			return ApiResponse.failure(ResponseMessage.NO_RECORDS_FOUND.getMessage());
//		}
//		return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), entity.get());
//	}
//

//
//	public ApiResponse<T> update(T entity) {
//		return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), repository.save(entity));
//	}
//
//	public ApiResponse<T> approve(String id) {
//		return null;
//	}
//
//	public ApiResponse<String> reject(String id) {
//		return null;
//	}
//
//	public ApiResponse<Object> deleteById(String id) {
//		// Optional<T> entity = repository.findById(id);
//		// repository.deleteById(id);
//		return ApiResponse.success(ResponseMessage.DELETE_SUCCESS.getMessage(), null);
//	}
//
//	public ApiResponse<T> delete(T entity) {
//		repository.delete(entity);
//		return ApiResponse.success(ResponseMessage.OPERATION_SUCCESS.getMessage(), entity);
//	}
//
//	public Object convertToDto(Object source, Object target)// , Object target)
//	{
//		BeanUtils.copyProperties(source, target);
//		return target;
//	}

}
