package com.cheng.system.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_org
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class OrgModel implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.inheritance
     *
     * @mbg.generated
     */
    private String inheritance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.full_name
     *
     * @mbg.generated
     */
    private String fullName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.parent
     *
     * @mbg.generated
     */
    private String parent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.order
     *
     * @mbg.generated
     */
    private Integer order;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.created_time
     *
     * @mbg.generated
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.created_by
     *
     * @mbg.generated
     */
    private String createdBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.updated_by
     *
     * @mbg.generated
     */
    private String updatedBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.updated_time
     *
     * @mbg.generated
     */
    private Date updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.del_flag
     *
     * @mbg.generated
     */
    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_org
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.id
     *
     * @return the value of sys_org.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.id
     *
     * @param id the value for sys_org.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.inheritance
     *
     * @return the value of sys_org.inheritance
     *
     * @mbg.generated
     */
    public String getInheritance() {
        return inheritance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.inheritance
     *
     * @param inheritance the value for sys_org.inheritance
     *
     * @mbg.generated
     */
    public void setInheritance(String inheritance) {
        this.inheritance = inheritance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.name
     *
     * @return the value of sys_org.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.name
     *
     * @param name the value for sys_org.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.full_name
     *
     * @return the value of sys_org.full_name
     *
     * @mbg.generated
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.full_name
     *
     * @param fullName the value for sys_org.full_name
     *
     * @mbg.generated
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.parent
     *
     * @return the value of sys_org.parent
     *
     * @mbg.generated
     */
    public String getParent() {
        return parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.parent
     *
     * @param parent the value for sys_org.parent
     *
     * @mbg.generated
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.order
     *
     * @return the value of sys_org.order
     *
     * @mbg.generated
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.order
     *
     * @param order the value for sys_org.order
     *
     * @mbg.generated
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.created_time
     *
     * @return the value of sys_org.created_time
     *
     * @mbg.generated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.created_time
     *
     * @param createdTime the value for sys_org.created_time
     *
     * @mbg.generated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.created_by
     *
     * @return the value of sys_org.created_by
     *
     * @mbg.generated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.created_by
     *
     * @param createdBy the value for sys_org.created_by
     *
     * @mbg.generated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.updated_by
     *
     * @return the value of sys_org.updated_by
     *
     * @mbg.generated
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.updated_by
     *
     * @param updatedBy the value for sys_org.updated_by
     *
     * @mbg.generated
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.updated_time
     *
     * @return the value of sys_org.updated_time
     *
     * @mbg.generated
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.updated_time
     *
     * @param updatedTime the value for sys_org.updated_time
     *
     * @mbg.generated
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.del_flag
     *
     * @return the value of sys_org.del_flag
     *
     * @mbg.generated
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.del_flag
     *
     * @param delFlag the value for sys_org.del_flag
     *
     * @mbg.generated
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}