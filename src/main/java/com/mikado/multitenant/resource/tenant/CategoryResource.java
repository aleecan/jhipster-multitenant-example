package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.domain.tenant.Category;
import com.mikado.multitenant.domain.tenant.QCategory;
import com.mikado.multitenant.resource.util.PageHelper;
import com.mikado.multitenant.resource.util.PaginationUtil;
import com.mikado.multitenant.resource.util.ResponseDTO;
import com.mikado.multitenant.resource.util.SearchFilterHelper;
import com.mikado.multitenant.service.tenant.CategoryService;
import com.querydsl.core.BooleanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryResource {

    private CategoryService categoriesService;

	/*@Autowired
	private CategoriesMapper categoriesMapper;
	@Autowired
	private LanguageMessageService languageMessageService;*/

    public CategoryResource(CategoryService categoryService) {
        this.categoriesService = categoryService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryResource.class);

	/*@PostMapping(path = "/addcategories", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseDTO> addCategories(@RequestBody CategoriesDTO categoriesDTO) {
		HttpStatus status = HttpStatus.OK;
		boolean error = false;
		String message = languageMessageService.getMessage(MultiLanguageKey.SUCCESS);
		try {

			if (categoriesDTO.getId() == null) {
				if (!categoriesService.findByCode(categoriesDTO.getCode()).isPresent()) {
					categoriesService.save(categoriesMapper.dtoToEntity(categoriesDTO));
					LOGGER.info("Categories Saved Successfully");
				} else {
					error = true;
					message = languageMessageService.getMessage(MultiLanguageKey.CODE_ALREADY_EXIST)
							.replace(MultiLanguageKey.NAME_TARGET, "categories");
				}

			} else {
				error = true;
				message = languageMessageService.getMessage(MultiLanguageKey.ONLY_NEW_OBJECT_ALLOWED)
						.replace(MultiLanguageKey.NAME_TARGET, "categories");
			}
		} catch (Exception e) {
			LOGGER.error("CategoriesController :: addcategories == ", e);
			error = true;
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(new ResponseDTO(error, message), status);
	}

	@PutMapping(path = "/updatecategories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> updateCategories(@RequestBody CategoriesDTO categoriesDTO) {
		HttpStatus status = HttpStatus.OK;
		boolean error = false;
		String message = languageMessageService.getMessage(MultiLanguageKey.SUCCESS);
		try {
			Optional<Categories> categoriesOptional = null;
			if (categoriesDTO.getId() != null
					&& (categoriesOptional = categoriesService.findById(categoriesDTO.getId())).isPresent()) {
				Categories categories = categoriesOptional.get();
				categories.setDescription(categoriesDTO.getDescription());
				categories.setAbbreviation(categoriesDTO.getAbbreviation());
				categories.setColor(categoriesDTO.getColor());
				categories.setShiftTime(categoriesDTO.getShiftTime());
				categories.setShiftMultiplier(categoriesDTO.getShiftMultiplier());
				categories.setDayShiftMultiplier(categoriesDTO.getDayShiftMultiplier());
				categories.setShiftLimitLow(categoriesDTO.getShiftLimitLow());
				categories.setShiftLimitUp(categoriesDTO.getShiftLimitUp());
				categories.setDayShiftLimitLow(categoriesDTO.getDayShiftLimitLow());
				categories.setDayShiftLimitUp(categoriesDTO.getDayShiftLimitUp());
				categories.setDayRounding(categoriesDTO.getDayRounding());
				categories.setAddingTime(categoriesDTO.getAddingTime());
				categories.setRoundingGap(categoriesDTO.getRoundingGap());
				categories.setTimeRounding(categoriesDTO.getTimeRounding());
				categories.setMonthRounding(categoriesDTO.getMonthRounding());
				categories.setNormalWorkingGroup(categoriesDTO.getNormalWorkingGroup());
				categories.setOverworkGroup(categoriesDTO.getOverworkGroup());
				categories.setOvertimeApproval(categoriesDTO.getOvertimeApproval());
			//	categories.setChangeWeeklyPayroll(categoriesDTO.getChangeWeeklyPayroll);
				categories.setCustomTasks(categoriesDTO.getCustomTasks());
				categories.setAddTasks(categoriesDTO.getAddTasks());
				categories.setHourlyExcuse(categoriesDTO.getHourlyExcuse());
				categories.setCtypeGroup(categoriesDTO.getCtypeGroup());
				categoriesService.save(categories);
				LOGGER.info("Categories Updated Successfully");
			} else {
				error = true;
				message = languageMessageService.getMessage(MultiLanguageKey.NOT_FOUND_BY_NAME)
						.replace(MultiLanguageKey.NAME_TARGET, "categories");
			}
		} catch (Exception e) {
			LOGGER.error("CategoriesController :: updatecategories == ", e);
			error = true;
			message = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(new ResponseDTO(error, message), status);
	}


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteCategories(@PathVariable Long id) {
        HttpStatus status = HttpStatus.OK;
        boolean error = false;
        String message = languageMessageService.getMessage(MultiLanguageKey.SUCCESS);
        try {
            Optional<Categories> optional = categoriesService.findById(id);
            if (optional.isPresent()) {
                categoriesService.delete(optional.get());
                LOGGER.info("Categories Deleted Successfully");
            } else {
                error = true;
                message = languageMessageService.getMessage(MultiLanguageKey.NOT_FOUND_BY_NAME)
                    .replace(MultiLanguageKey.NAME_TARGET, "categories");
            }
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("CategoriesController :: delete ---> Constraint violation (foreign key )");
            error = true;
            message = languageMessageService.getMessage(MultiLanguageKey.FOREIGN_KEY_CONTRAINTS)
                .replace(MultiLanguageKey.NAME_TARGET, "Categories");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception e) {
            LOGGER.error("CategoriesController :: deletecategories == ", e);
            error = true;
            message = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(new ResponseDTO(error, message), status);
    }*/

    @GetMapping(path = "/allcategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> listOfCategory() {
        return categoriesService.findAll();
    }

    @PostMapping(path = "/categories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> listOfCategory(@RequestBody SearchFilterHelper filterHelper) {
        QCategory qcategory = QCategory.category;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        // Filtering data with text.
        String searchText = filterHelper.getSearchText();
        if (searchText != null && !searchText.isEmpty()) {
            booleanBuilder.and(qcategory.code.containsIgnoreCase(searchText)
                .or(qcategory.description.containsIgnoreCase(searchText)));
        }
        /*PageRequest pageRequest = new PageRequest(filterHelper.getPageNumber() - 1, filterHelper.getPageSize());
        Page<Category> page = categoriesService.findAll(booleanBuilder, pageRequest);
        final List<Category> pagedData = page.getContent();
        HttpHeaders httpHeaders = PaginationUtil.generatePaginationHttpHeaders(page, "");
        return new ResponseEntity<>(pagedData, httpHeaders, HttpStatus.OK);*/
        return PageHelper.responseEntity(filterHelper,
            pr -> categoriesService.findAll(booleanBuilder, pr));
    }
}
