/*
 * Copyright (c)  "IQB Solutions" All rights reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential.
 * Written by erkankavlak,  December 2017
 */

package com.mikado.multitenant.domain.base;

import com.google.common.collect.Lists;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.List;

@MappedSuperclass
@Data
public class TwentyFourHourEntity extends EntityBase {

    @Column(name = "value_h0")
    private BigDecimal valueH0;

    @Column(name = "value_h1")
    private BigDecimal valueH1;

    @Column(name = "value_h2")
    private BigDecimal valueH2;

    @Column(name = "value_h3")
    private BigDecimal valueH3;

    @Column(name = "value_h4")
    private BigDecimal valueH4;

    @Column(name = "value_h5")
    private BigDecimal valueH5;

    @Column(name = "value_h6")
    private BigDecimal valueH6;

    @Column(name = "value_h7")
    private BigDecimal valueH7;

    @Column(name = "value_h8")
    private BigDecimal valueH8;

    @Column(name = "value_h9")
    private BigDecimal valueH9;

    @Column(name = "value_h10")
    private BigDecimal valueH10;

    @Column(name = "value_h11")
    private BigDecimal valueH11;

    @Column(name = "value_h12")
    private BigDecimal valueH12;

    @Column(name = "value_h13")
    private BigDecimal valueH13;

    @Column(name = "value_h14")
    private BigDecimal valueH14;

    @Column(name = "value_h15")
    private BigDecimal valueH15;

    @Column(name = "value_h16")
    private BigDecimal valueH16;

    @Column(name = "value_h17")
    private BigDecimal valueH17;

    @Column(name = "value_h18")
    private BigDecimal valueH18;

    @Column(name = "value_h19")
    private BigDecimal valueH19;

    @Column(name = "value_h20")
    private BigDecimal valueH20;

    @Column(name = "value_h21")
    private BigDecimal valueH21;

    @Column(name = "value_h22")
    private BigDecimal valueH22;

    @Column(name = "value_h23")
    private BigDecimal valueH23;

    public BigDecimal getValue(Integer hour) {
        BigDecimal value;
        switch (hour) {
            case 0:
                value = valueH0;
                break;
            case 1:
                value = valueH1;
                break;
            case 2:
                value = valueH2;
                break;
            case 3:
                value = valueH3;
                break;
            case 4:
                value = valueH4;
                break;
            case 5:
                value = valueH5;
                break;
            case 6:
                value = valueH6;
                break;
            case 7:
                value = valueH7;
                break;
            case 8:
                value = valueH8;
                break;
            case 9:
                value = valueH9;
                break;
            case 10:
                value = valueH10;
                break;
            case 11:
                value = valueH11;
                break;
            case 12:
                value = valueH12;
                break;
            case 13:
                value = valueH13;
                break;
            case 14:
                value = valueH14;
                break;
            case 15:
                value = valueH15;
                break;
            case 16:
                value = valueH16;
                break;
            case 17:
                value = valueH17;
                break;
            case 18:
                value = valueH18;
                break;
            case 19:
                value = valueH19;
                break;
            case 20:
                value = valueH20;
                break;
            case 21:
                value = valueH21;
                break;
            case 22:
                value = valueH22;
                break;
            case 23:
                value = valueH23;
                break;
            default:
                value = BigDecimal.ZERO;
                break;
        }
        return value;
    }

    public void setValue(int index, BigDecimal value) {
        switch (index) {
            case 0:
                valueH0 = value;
                break;
            case 1:
                valueH1 = value;
                break;
            case 2:
                valueH2 = value;
                break;
            case 3:
                valueH3 = value;
                break;
            case 4:
                valueH4 = value;
                break;
            case 5:
                valueH5 = value;
                break;
            case 6:
                valueH6 = value;
                break;
            case 7:
                valueH7 = value;
                break;
            case 8:
                valueH8 = value;
                break;
            case 9:
                valueH9 = value;
                break;
            case 10:
                valueH10 = value;
                break;
            case 11:
                valueH11 = value;
                break;
            case 12:
                valueH12 = value;
                break;
            case 13:
                valueH13 = value;
                break;
            case 14:
                valueH14 = value;
                break;
            case 15:
                valueH15 = value;
                break;
            case 16:
                valueH16 = value;
                break;
            case 17:
                valueH17 = value;
                break;
            case 18:
                valueH18 = value;
                break;
            case 19:
                valueH19 = value;
                break;
            case 20:
                valueH20 = value;
                break;
            case 21:
                valueH21 = value;
                break;
            case 22:
                valueH22 = value;
                break;
            case 23:
                valueH23 = value;
                break;
            default:
                break;
        }
    }

    public void setValueToAll(BigDecimal value) {
        valueH0 = value;
        valueH1 = value;
        valueH2 = value;
        valueH3 = value;
        valueH4 = value;
        valueH5 = value;
        valueH6 = value;
        valueH7 = value;
        valueH8 = value;
        valueH9 = value;
        valueH10 = value;
        valueH11 = value;
        valueH12 = value;
        valueH13 = value;
        valueH14 = value;
        valueH15 = value;
        valueH16 = value;
        valueH17 = value;
        valueH18 = value;
        valueH19 = value;
        valueH20 = value;
        valueH21 = value;
        valueH22 = value;
        valueH23 = value;
    }

    public List<BigDecimal> getAllValues() {
        return Lists.newArrayList(
                valueH0
                , valueH1
                , valueH2
                , valueH3
                , valueH4
                , valueH5
                , valueH6
                , valueH7
                , valueH8
                , valueH9
                , valueH10
                , valueH11
                , valueH12
                , valueH13
                , valueH14
                , valueH15
                , valueH16
                , valueH17
                , valueH18
                , valueH19
                , valueH20
                , valueH21
                , valueH22
                , valueH23);
    }

    public boolean valuesAreNull() {
        boolean allValuesAreNullOrZero = true;
        for (int i = 0; i < 24; i++) {
            BigDecimal currentValue = getValue(i);
            if (currentValue == null /*|| currentValue == BigDecimal.ZERO*/)
                allValuesAreNullOrZero = true;
            else
                allValuesAreNullOrZero = false;
        }

        return allValuesAreNullOrZero;
    }
}
