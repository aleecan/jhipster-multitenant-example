package com.mikado.mikadosaas.resource.util;

import lombok.Data;
import org.springframework.data.domain.Sort.Direction;

import java.util.Date;

/**
 * @author cis
 */
@Data
public class SearchFilterHelper {
	private Long id;
	private int pageNumber = ConstantValue.INITIAL_PAGE_NUMBER;
	private int pageSize = ConstantValue.INITIAL_PAGE_SIZE;
	private String searchText;
	private String shortingColumnName;
	private Direction direction;
	private EnumConstants.Type type;
	private Date fromDate;
	private Date toDate;
	private EnumConstants.CardType cardType;
	private String dayType;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getShortingColumnName() {
		return shortingColumnName;
	}

	public void setShortingColumnName(String shortingColumnName) {
		this.shortingColumnName = shortingColumnName;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
