package com.mikado.mikadosaas.service.dto.tenant;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mikado.mikadosaas.domain.TextFileFormat} entity.
 */
public class TextFileFormatDTO implements Serializable {

    private Long id;

    @Size(max = 50)
    private String optionName;

    @Size(max = 80)
    private String fileName;

    private Boolean cardNoEqualEmpNo;

    private Integer rowSize;

    private Integer fixedSize;

    private Integer minTimekeepingSec;

    @Size(max = 20)
    private String defaultVisitorCardNo;

    private Integer posCardNo;

    private Integer lenCardNo;

    private Integer posDay;

    private Integer lenDay;

    private Integer posMonth;

    private Integer lenMonth;

    private Integer lenYear;

    private Integer posYear;

    private Integer posHour;

    private Integer lenHour;

    private Integer posMin;

    private Integer lenMin;

    private Integer posSec;

    private Integer lenSec;

    private Integer posDirection;

    private Integer lenDirection;

    private Integer posAccessCode;

    private Integer lenAccessCode;

    private Integer posTerminal;

    private Integer lenTerminal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean isCardNoEqualEmpNo() {
        return cardNoEqualEmpNo;
    }

    public void setCardNoEqualEmpNo(Boolean cardNoEqualEmpNo) {
        this.cardNoEqualEmpNo = cardNoEqualEmpNo;
    }

    public Integer getRowSize() {
        return rowSize;
    }

    public void setRowSize(Integer rowSize) {
        this.rowSize = rowSize;
    }

    public Integer getFixedSize() {
        return fixedSize;
    }

    public void setFixedSize(Integer fixedSize) {
        this.fixedSize = fixedSize;
    }

    public Integer getMinTimekeepingSec() {
        return minTimekeepingSec;
    }

    public void setMinTimekeepingSec(Integer minTimekeepingSec) {
        this.minTimekeepingSec = minTimekeepingSec;
    }

    public String getDefaultVisitorCardNo() {
        return defaultVisitorCardNo;
    }

    public void setDefaultVisitorCardNo(String defaultVisitorCardNo) {
        this.defaultVisitorCardNo = defaultVisitorCardNo;
    }

    public Integer getPosCardNo() {
        return posCardNo;
    }

    public void setPosCardNo(Integer posCardNo) {
        this.posCardNo = posCardNo;
    }

    public Integer getLenCardNo() {
        return lenCardNo;
    }

    public void setLenCardNo(Integer lenCardNo) {
        this.lenCardNo = lenCardNo;
    }

    public Integer getPosDay() {
        return posDay;
    }

    public void setPosDay(Integer posDay) {
        this.posDay = posDay;
    }

    public Integer getLenDay() {
        return lenDay;
    }

    public void setLenDay(Integer lenDay) {
        this.lenDay = lenDay;
    }

    public Integer getPosMonth() {
        return posMonth;
    }

    public void setPosMonth(Integer posMonth) {
        this.posMonth = posMonth;
    }

    public Integer getLenMonth() {
        return lenMonth;
    }

    public void setLenMonth(Integer lenMonth) {
        this.lenMonth = lenMonth;
    }

    public Integer getLenYear() {
        return lenYear;
    }

    public void setLenYear(Integer lenYear) {
        this.lenYear = lenYear;
    }

    public Integer getPosYear() {
        return posYear;
    }

    public void setPosYear(Integer posYear) {
        this.posYear = posYear;
    }

    public Integer getPosHour() {
        return posHour;
    }

    public void setPosHour(Integer posHour) {
        this.posHour = posHour;
    }

    public Integer getLenHour() {
        return lenHour;
    }

    public void setLenHour(Integer lenHour) {
        this.lenHour = lenHour;
    }

    public Integer getPosMin() {
        return posMin;
    }

    public void setPosMin(Integer posMin) {
        this.posMin = posMin;
    }

    public Integer getLenMin() {
        return lenMin;
    }

    public void setLenMin(Integer lenMin) {
        this.lenMin = lenMin;
    }

    public Integer getPosSec() {
        return posSec;
    }

    public void setPosSec(Integer posSec) {
        this.posSec = posSec;
    }

    public Integer getLenSec() {
        return lenSec;
    }

    public void setLenSec(Integer lenSec) {
        this.lenSec = lenSec;
    }

    public Integer getPosDirection() {
        return posDirection;
    }

    public void setPosDirection(Integer posDirection) {
        this.posDirection = posDirection;
    }

    public Integer getLenDirection() {
        return lenDirection;
    }

    public void setLenDirection(Integer lenDirection) {
        this.lenDirection = lenDirection;
    }

    public Integer getPosAccessCode() {
        return posAccessCode;
    }

    public void setPosAccessCode(Integer posAccessCode) {
        this.posAccessCode = posAccessCode;
    }

    public Integer getLenAccessCode() {
        return lenAccessCode;
    }

    public void setLenAccessCode(Integer lenAccessCode) {
        this.lenAccessCode = lenAccessCode;
    }

    public Integer getPosTerminal() {
        return posTerminal;
    }

    public void setPosTerminal(Integer posTerminal) {
        this.posTerminal = posTerminal;
    }

    public Integer getLenTerminal() {
        return lenTerminal;
    }

    public void setLenTerminal(Integer lenTerminal) {
        this.lenTerminal = lenTerminal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TextFileFormatDTO)) {
            return false;
        }

        return id != null && id.equals(((TextFileFormatDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TextFileFormatDTO{" +
            "id=" + getId() +
            ", optionName='" + getOptionName() + "'" +
            ", fileName='" + getFileName() + "'" +
            ", cardNoEqualEmpNo='" + isCardNoEqualEmpNo() + "'" +
            ", rowSize=" + getRowSize() +
            ", fixedSize=" + getFixedSize() +
            ", minTimekeepingSec=" + getMinTimekeepingSec() +
            ", defaultVisitorCardNo='" + getDefaultVisitorCardNo() + "'" +
            ", posCardNo=" + getPosCardNo() +
            ", lenCardNo=" + getLenCardNo() +
            ", posDay=" + getPosDay() +
            ", lenDay=" + getLenDay() +
            ", posMonth=" + getPosMonth() +
            ", lenMonth=" + getLenMonth() +
            ", lenYear=" + getLenYear() +
            ", posYear=" + getPosYear() +
            ", posHour=" + getPosHour() +
            ", lenHour=" + getLenHour() +
            ", posMin=" + getPosMin() +
            ", lenMin=" + getLenMin() +
            ", posSec=" + getPosSec() +
            ", lenSec=" + getLenSec() +
            ", posDirection=" + getPosDirection() +
            ", lenDirection=" + getLenDirection() +
            ", posAccessCode=" + getPosAccessCode() +
            ", lenAccessCode=" + getLenAccessCode() +
            ", posTerminal=" + getPosTerminal() +
            ", lenTerminal=" + getLenTerminal() +
            "}";
    }
}
