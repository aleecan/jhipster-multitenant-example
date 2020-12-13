package com.mikado.multitenant.resource.util;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

public class RequestHelper {

	public static PageRequest create(int pageNumber, int pageSize, String column, Direction direction) {
		if (column == null || column.isEmpty()) {
			return create(pageNumber, pageSize);
		}
		// Direction direction = Direction.ASC;
		// if (column.indexOf("-") > -1) {
		// column = column.replaceAll("-", "");
		// direction = Direction.DESC;
		// }
		return PageRequest.of(pageNumber - 1, pageSize, direction, column);
	}

	public static PageRequest create(int pageNumber, int pageSize, String column) {
		if (column == null || column.isEmpty()) {
			return create(pageNumber, pageSize);
		}
		Direction direction = Direction.ASC;
		if (column.indexOf("-") > -1) {
			column = column.replaceAll("-", "");
			direction = Direction.DESC;
		}
		return PageRequest.of(pageNumber - 1, pageSize, direction, column);
	}

	public static PageRequest create(int pageNumber, int pageSize) {
		return PageRequest.of(pageNumber - 1, pageSize);
	}

	public static PageRequest create(int pageNumber, int pageSize, OrderSpecifier<?> os) {
		Path<?> path = (Path<?>) os.getTarget();
		return PageRequest.of(pageNumber - 1, pageSize, os.isAscending() ? Direction.ASC : Direction.DESC,
				path.getMetadata().getName());
	}

}
