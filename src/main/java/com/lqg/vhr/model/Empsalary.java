package com.lqg.vhr.model;

import java.io.Serializable;

/**
 * empsalary
 * @author 
 */
public class Empsalary implements Serializable {
    private Integer id;

    private Integer eid;

    private Integer sid;

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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}