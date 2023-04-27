package com.homework.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 积分记录变更记录
 */
@TableName(value = "t_point_record")
public class PointRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Integer id;
  private Integer userId;
  private Integer orderId;
  private BigDecimal changeValue;
  private LocalDateTime createTime;


  public long getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }


  public BigDecimal getChangeValue() {
    return changeValue;
  }

  public void setChangeValue(BigDecimal changeValue) {
    this.changeValue = changeValue;
  }


  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

}
