package com.mikado.mikadosaas.common.util;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterDefinition {
    private String fieldName;
    private FilterModes filterModes;
    private String filterValue;

    public static HashMap<String, FilterDefinition> parse(String[] filters) {
        HashMap<String, FilterDefinition> parsedFilters = new HashMap<>();
        int filterCount = filters.length;
        if (filterCount <= 0) {
            parsedFilters = null;
        } else {
            for (int i = 0; i < filterCount; i++) {
                String[] splitedFilter = filters[i].split("::");
                if (parsedFilters.keySet().contains(splitedFilter[0])) {
                    throw new KeyAlreadyExistsException("The key " + splitedFilter[0] + "is already exist in filter collection!");
                }

                FilterDefinition filterDefinition = new FilterDefinition();
                filterDefinition.setFieldName(splitedFilter[0]);
                FilterModes filterMode = FilterModes.valueOf(splitedFilter[1]);
                filterDefinition.setFilterModes(filterMode);
                filterDefinition.setFilterValue(splitedFilter[2]);
                parsedFilters.put(filterDefinition.getFieldName(), filterDefinition);
            }
        }

        return parsedFilters;
    }

    public Byte[] getValueAsByteArray() {
        String[] splitedValues = filterValue.split("-");
        int length = splitedValues.length;
        Byte[] bytes = new Byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = Byte.valueOf(splitedValues[i]);
        }

        return bytes;
    }

    public List<Long> getValueAsLongList() {
        String[] splitedValues = filterValue.split("-");
        int length = splitedValues.length;
        List<Long> longValues = new ArrayList();
        for (int i = 0; i < length; i++) {
            longValues.add(Long.valueOf(splitedValues[i]));
        }
        return longValues;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FilterModes getFilterModes() {
        return filterModes;
    }

    public void setFilterModes(FilterModes filterModes) {
        this.filterModes = filterModes;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
