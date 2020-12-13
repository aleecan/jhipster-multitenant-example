package com.mikado.multitenant.domain.tenant;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A TextFileFormat.
 */
@Entity
@Table(name = "text_file_format")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TextFileFormat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "option_name", length = 50)
    private String optionName;

    @Size(max = 80)
    @Column(name = "file_name", length = 80)
    private String fileName;

    @Column(name = "card_no_equal_emp_no")
    private Boolean cardNoEqualEmpNo;

    @Column(name = "row_size")
    private Integer rowSize;

    @Column(name = "fixed_size")
    private Integer fixedSize;

    @Column(name = "min_timekeeping_sec")
    private Integer minTimekeepingSec;

    @Size(max = 20)
    @Column(name = "default_visitor_card_no", length = 20)
    private String defaultVisitorCardNo;

    @Column(name = "pos_card_no")
    private Integer posCardNo;

    @Column(name = "len_card_no")
    private Integer lenCardNo;

    @Column(name = "pos_day")
    private Integer posDay;

    @Column(name = "len_day")
    private Integer lenDay;

    @Column(name = "pos_month")
    private Integer posMonth;

    @Column(name = "len_month")
    private Integer lenMonth;

    @Column(name = "len_year")
    private Integer lenYear;

    @Column(name = "pos_year")
    private Integer posYear;

    @Column(name = "pos_hour")
    private Integer posHour;

    @Column(name = "len_hour")
    private Integer lenHour;

    @Column(name = "pos_min")
    private Integer posMin;

    @Column(name = "len_min")
    private Integer lenMin;

    @Column(name = "pos_sec")
    private Integer posSec;

    @Column(name = "len_sec")
    private Integer lenSec;

    @Column(name = "pos_direction")
    private Integer posDirection;

    @Column(name = "len_direction")
    private Integer lenDirection;

    @Column(name = "pos_access_code")
    private Integer posAccessCode;

    @Column(name = "len_access_code")
    private Integer lenAccessCode;

    @Column(name = "pos_terminal")
    private Integer posTerminal;

    @Column(name = "len_terminal")
    private Integer lenTerminal;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public TextFileFormat optionName(String optionName) {
        this.optionName = optionName;
        return this;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getFileName() {
        return fileName;
    }

    public TextFileFormat fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean isCardNoEqualEmpNo() {
        return cardNoEqualEmpNo;
    }

    public TextFileFormat cardNoEqualEmpNo(Boolean cardNoEqualEmpNo) {
        this.cardNoEqualEmpNo = cardNoEqualEmpNo;
        return this;
    }

    public void setCardNoEqualEmpNo(Boolean cardNoEqualEmpNo) {
        this.cardNoEqualEmpNo = cardNoEqualEmpNo;
    }

    public Integer getRowSize() {
        return rowSize;
    }

    public TextFileFormat rowSize(Integer rowSize) {
        this.rowSize = rowSize;
        return this;
    }

    public void setRowSize(Integer rowSize) {
        this.rowSize = rowSize;
    }

    public Integer getFixedSize() {
        return fixedSize;
    }

    public TextFileFormat fixedSize(Integer fixedSize) {
        this.fixedSize = fixedSize;
        return this;
    }

    public void setFixedSize(Integer fixedSize) {
        this.fixedSize = fixedSize;
    }

    public Integer getMinTimekeepingSec() {
        return minTimekeepingSec;
    }

    public TextFileFormat minTimekeepingSec(Integer minTimekeepingSec) {
        this.minTimekeepingSec = minTimekeepingSec;
        return this;
    }

    public void setMinTimekeepingSec(Integer minTimekeepingSec) {
        this.minTimekeepingSec = minTimekeepingSec;
    }

    public String getDefaultVisitorCardNo() {
        return defaultVisitorCardNo;
    }

    public TextFileFormat defaultVisitorCardNo(String defaultVisitorCardNo) {
        this.defaultVisitorCardNo = defaultVisitorCardNo;
        return this;
    }

    public void setDefaultVisitorCardNo(String defaultVisitorCardNo) {
        this.defaultVisitorCardNo = defaultVisitorCardNo;
    }

    public Integer getPosCardNo() {
        return posCardNo;
    }

    public TextFileFormat posCardNo(Integer posCardNo) {
        this.posCardNo = posCardNo;
        return this;
    }

    public void setPosCardNo(Integer posCardNo) {
        this.posCardNo = posCardNo;
    }

    public Integer getLenCardNo() {
        return lenCardNo;
    }

    public TextFileFormat lenCardNo(Integer lenCardNo) {
        this.lenCardNo = lenCardNo;
        return this;
    }

    public void setLenCardNo(Integer lenCardNo) {
        this.lenCardNo = lenCardNo;
    }

    public Integer getPosDay() {
        return posDay;
    }

    public TextFileFormat posDay(Integer posDay) {
        this.posDay = posDay;
        return this;
    }

    public void setPosDay(Integer posDay) {
        this.posDay = posDay;
    }

    public Integer getLenDay() {
        return lenDay;
    }

    public TextFileFormat lenDay(Integer lenDay) {
        this.lenDay = lenDay;
        return this;
    }

    public void setLenDay(Integer lenDay) {
        this.lenDay = lenDay;
    }

    public Integer getPosMonth() {
        return posMonth;
    }

    public TextFileFormat posMonth(Integer posMonth) {
        this.posMonth = posMonth;
        return this;
    }

    public void setPosMonth(Integer posMonth) {
        this.posMonth = posMonth;
    }

    public Integer getLenMonth() {
        return lenMonth;
    }

    public TextFileFormat lenMonth(Integer lenMonth) {
        this.lenMonth = lenMonth;
        return this;
    }

    public void setLenMonth(Integer lenMonth) {
        this.lenMonth = lenMonth;
    }

    public Integer getLenYear() {
        return lenYear;
    }

    public TextFileFormat lenYear(Integer lenYear) {
        this.lenYear = lenYear;
        return this;
    }

    public void setLenYear(Integer lenYear) {
        this.lenYear = lenYear;
    }

    public Integer getPosYear() {
        return posYear;
    }

    public TextFileFormat posYear(Integer posYear) {
        this.posYear = posYear;
        return this;
    }

    public void setPosYear(Integer posYear) {
        this.posYear = posYear;
    }

    public Integer getPosHour() {
        return posHour;
    }

    public TextFileFormat posHour(Integer posHour) {
        this.posHour = posHour;
        return this;
    }

    public void setPosHour(Integer posHour) {
        this.posHour = posHour;
    }

    public Integer getLenHour() {
        return lenHour;
    }

    public TextFileFormat lenHour(Integer lenHour) {
        this.lenHour = lenHour;
        return this;
    }

    public void setLenHour(Integer lenHour) {
        this.lenHour = lenHour;
    }

    public Integer getPosMin() {
        return posMin;
    }

    public TextFileFormat posMin(Integer posMin) {
        this.posMin = posMin;
        return this;
    }

    public void setPosMin(Integer posMin) {
        this.posMin = posMin;
    }

    public Integer getLenMin() {
        return lenMin;
    }

    public TextFileFormat lenMin(Integer lenMin) {
        this.lenMin = lenMin;
        return this;
    }

    public void setLenMin(Integer lenMin) {
        this.lenMin = lenMin;
    }

    public Integer getPosSec() {
        return posSec;
    }

    public TextFileFormat posSec(Integer posSec) {
        this.posSec = posSec;
        return this;
    }

    public void setPosSec(Integer posSec) {
        this.posSec = posSec;
    }

    public Integer getLenSec() {
        return lenSec;
    }

    public TextFileFormat lenSec(Integer lenSec) {
        this.lenSec = lenSec;
        return this;
    }

    public void setLenSec(Integer lenSec) {
        this.lenSec = lenSec;
    }

    public Integer getPosDirection() {
        return posDirection;
    }

    public TextFileFormat posDirection(Integer posDirection) {
        this.posDirection = posDirection;
        return this;
    }

    public void setPosDirection(Integer posDirection) {
        this.posDirection = posDirection;
    }

    public Integer getLenDirection() {
        return lenDirection;
    }

    public TextFileFormat lenDirection(Integer lenDirection) {
        this.lenDirection = lenDirection;
        return this;
    }

    public void setLenDirection(Integer lenDirection) {
        this.lenDirection = lenDirection;
    }

    public Integer getPosAccessCode() {
        return posAccessCode;
    }

    public TextFileFormat posAccessCode(Integer posAccessCode) {
        this.posAccessCode = posAccessCode;
        return this;
    }

    public void setPosAccessCode(Integer posAccessCode) {
        this.posAccessCode = posAccessCode;
    }

    public Integer getLenAccessCode() {
        return lenAccessCode;
    }

    public TextFileFormat lenAccessCode(Integer lenAccessCode) {
        this.lenAccessCode = lenAccessCode;
        return this;
    }

    public void setLenAccessCode(Integer lenAccessCode) {
        this.lenAccessCode = lenAccessCode;
    }

    public Integer getPosTerminal() {
        return posTerminal;
    }

    public TextFileFormat posTerminal(Integer posTerminal) {
        this.posTerminal = posTerminal;
        return this;
    }

    public void setPosTerminal(Integer posTerminal) {
        this.posTerminal = posTerminal;
    }

    public Integer getLenTerminal() {
        return lenTerminal;
    }

    public TextFileFormat lenTerminal(Integer lenTerminal) {
        this.lenTerminal = lenTerminal;
        return this;
    }

    public void setLenTerminal(Integer lenTerminal) {
        this.lenTerminal = lenTerminal;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TextFileFormat)) {
            return false;
        }
        return id != null && id.equals(((TextFileFormat) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TextFileFormat{" +
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
