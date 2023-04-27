package com.homework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.homework.common.entity.PointRecord;

public interface PointRecordService extends IService<PointRecord> {


    PointRecord insertPointRecord(PointRecord pointRecord);
}
