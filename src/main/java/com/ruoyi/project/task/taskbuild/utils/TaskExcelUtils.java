package com.ruoyi.project.task.taskbuild.utils;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

import java.lang.annotation.Annotation;

public class TaskExcelUtils implements Excel {
    @Override
    public String name() {
        return null;
    }

    @Override
    public String dateFormat() {
        return "yyyy-MM-dd";
    }

    @Override
    public String readConverterExp() {
        return null;
    }

    @Override
    public ColumnType cellType() {
        return null;
    }

    @Override
    public double height() {
        return 0;
    }

    @Override
    public double width() {
        return 0;
    }

    @Override
    public String suffix() {
        return null;
    }

    @Override
    public String defaultValue() {
        return null;
    }

    @Override
    public String prompt() {
        return null;
    }

    @Override
    public String[] combo() {
        return new String[0];
    }

    @Override
    public boolean isExport() {
        return false;
    }

    @Override
    public String targetAttr() {
        return null;
    }

    @Override
    public Type type() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
