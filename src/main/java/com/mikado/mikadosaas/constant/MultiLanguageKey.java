package com.mikado.mikadosaas.constant;

public class MultiLanguageKey {

	private MultiLanguageKey() {
	}

	// targets
	public static final String LINK_TARGET = "|link|";
	public static final String NAME_TARGET = "|name|";

	// common message
	public static final String SUCCESS = "success";
	public static final String PASSWORD_NOT_VALID = "password_invalid";
	public static final String NOT_FOUND_BY_NAME = "not_found";
	public static final String ONLY_NEW_OBJECT_ALLOWED = "only_new_object_allowed";
	public static final String CODE_ALREADY_EXIST = "code_alread_exist";
	public static final String USERNAME_ALREADY_EXIST = "username_already_exist";
	public static final String FILE_NOT_FOUND = "file_not_found";
	public static final String CATEGORY_ALREADY_USED = "category_already_exist";
	public static final String CANNOT_DELETE_ACTIVE_EMP = "cannot_delete_active_emp";
	public static final String NOT_PROPER_FORMAT = "not_proper_format";

	// user message
	public static final String USER_NOT_FOUND_BY_USERNAME = "user.not_found.by_id";
	public static final String LOGIN_USER_NOT_FOUND = "user.not_found.on_login";
	public static final String USER_LIMIT_EXCEEDED = "user.limit_exceeded";
	public static final String USER_INACTIVE = "user.inactive";

	// token message
	public static final String TOKEN_NOT_FOUND_OR_EXPIRED = "token.not_found_or_expired";
	public static final String TOKEN_EXPIRED = "token.expired";

	// mail message
	public static final String CHANGE_PASSOWD_BY_TOKEN_MAIL = "mail.change_password";
	public static final String EMAIL_NOT_FOUND = "mail.email_not_found";

	// SQL dump
	public static final String SQL_DUMP_NOT_FOUND = "sql.dump_not_found";

	// Tenant message
	public static final String TENANT_ID_ALREADY_EXIST = "tenant.id_exist";
	public static final String TENANT_NOT_FOUND = "tenant.not_found";
	public static final String TENANT_LICENSE_EXPIRED = "tenant.license_expired";
	public static final String OVERTIME_REQUEST_NOT_FOUND = "tenant_overtime_request_not_found";

	// Database message
	public static final String DATABASE_DETAIL_ALREADY_EXIST = "database.detail_exist";
	public static final String DATABASE_CREDENTIAL_INCORRECT = "database.credential_incorrect";
	public static final String EMPTY_DATABASE_NAME = "empty.database.name";
	public static final String FOREIGN_KEY_CONTRAINTS = "database.foreign_key_problem";

}
