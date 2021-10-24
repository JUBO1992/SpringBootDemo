package com.jubo.springboot01.system.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jubo
 * @since 2021-03-21
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String uri;

    private String name;

    private Boolean c;

    private Boolean r;

    private Boolean u;

    private Boolean d;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getC() {
        return c;
    }

    public void setC(Boolean c) {
        this.c = c;
    }

    public Boolean getR() {
        return r;
    }

    public void setR(Boolean r) {
        this.r = r;
    }

    public Boolean getU() {
        return u;
    }

    public void setU(Boolean u) {
        this.u = u;
    }

    public Boolean getD() {
        return d;
    }

    public void setD(Boolean d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Permission{" +
            "id=" + id +
            ", uri=" + uri +
            ", name=" + name +
            ", c=" + c +
            ", r=" + r +
            ", u=" + u +
            ", d=" + d +
            "}";
    }
}
