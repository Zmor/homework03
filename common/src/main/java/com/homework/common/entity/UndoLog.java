package com.homework.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Timestamp;

@TableName(value = "undo_log")
public class UndoLog implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  private Integer branchId;
  private String xid;
  private String context;
  private String rollbackInfo;
  private Integer logStatus;
  private java.sql.Timestamp logCreated;
  private java.sql.Timestamp logModified;

  public long getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public long getBranchId() {
    return branchId;
  }

  public void setBranchId(Integer branchId) {
    this.branchId = branchId;
  }

  public String getXid() {
    return xid;
  }

  public void setXid(String xid) {
    this.xid = xid;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getRollbackInfo() {
    return rollbackInfo;
  }

  public void setRollbackInfo(String rollbackInfo) {
    this.rollbackInfo = rollbackInfo;
  }

  public long getLogStatus() {
    return logStatus;
  }

  public void setLogStatus(Integer logStatus) {
    this.logStatus = logStatus;
  }

  public Timestamp getLogCreated() {
    return logCreated;
  }

  public void setLogCreated(Timestamp logCreated) {
    this.logCreated = logCreated;
  }

  public Timestamp getLogModified() {
    return logModified;
  }

  public void setLogModified(Timestamp logModified) {
    this.logModified = logModified;
  }
}