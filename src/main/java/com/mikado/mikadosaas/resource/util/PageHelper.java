package com.mikado.mikadosaas.resource.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;

public class PageHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(PageHelper.class);

	public static <T> ResponseEntity<ResponseDTO> responseEntity(SearchFilterHelper filterHelper, Function<PageRequest, Page<T>> function) {
		HttpStatus status = HttpStatus.OK;
		boolean error = false;
		String message = "Success";
		Page<T> page = null;
		// creating page request for search.
		PageRequest pageRequest = RequestHelper.create(filterHelper.getPageNumber(), filterHelper.getPageSize());
		try {
			// sorting data by column name.
			String sortingColumn = filterHelper.getShortingColumnName();
			if (sortingColumn != null) {
				pageRequest = RequestHelper.create(filterHelper.getPageNumber(), filterHelper.getPageSize(),
						sortingColumn);
				Direction direction = filterHelper.getDirection();
				if (direction != null) {
					pageRequest = RequestHelper.create(filterHelper.getPageNumber(), filterHelper.getPageSize(),
							sortingColumn, direction);
				}
			}
			// creating page with data
			page = function.apply(pageRequest);
		} catch (Exception e) {
			LOGGER.error("", e);
			error = true;
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(new ResponseDTO(error, message, page), status);
	}

}
