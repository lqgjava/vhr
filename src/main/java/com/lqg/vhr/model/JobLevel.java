package com.lqg.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * joblevel
 * @author 
 */
public class JobLevel implements Serializable {
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    private String titleLevel;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}