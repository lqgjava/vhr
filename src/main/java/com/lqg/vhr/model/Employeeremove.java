package com.lqg.vhr.model;

import java.io.Serializable;
import java.util.Date;

/**
 * employeeremove
 * @author 
 */
public class Employeeremove implements Serializable {
    private Integer id;

    private Integer eid;

    /**
     * 调动后部门
     */
    private Integer afterdepid;

    /**
     * 调动后职位
     */
    private Integer afterjobid;

    /**
     * 调动日期
     */
    private Date removedate;

    /**
     * 调动原因
     */
    private String reason;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getAfterdepid() {
        return afterdepid;
    }

    public void setAfterdepid(Integer afterdepid) {
        this.afterdepid = afterdepid;
    }

    public Integer getAfterjobid() {
        return afterjobid;
    }

    public void setAfterjobid(Integer afterjobid) {
        this.afterjobid = afterjobid;
    }

    public Date getRemovedate() {
        return removedate;
    }

    public void setRemovedate(Date removedate) {
        this.removedate = removedate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}