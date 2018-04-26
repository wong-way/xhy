package scu.edu.cn.service;

import scu.edu.cn.dao.entity.Record;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

/**
 * @author 黄伟
 * 处理跟进记录相关业务
 */
public interface RecordService {
    /**
     * 插入一条跟进记录记录
     *
     * @param record 跟进记录实体
     * @return Error对象
     */
    Error insertRecord(Record record);

    /**
     * 根据主键更新跟进记录信息
     *
     * @param record 跟进记录实体
     * @return Error对象
     */
    Error updateRecord(Record record);

    /**
     * 根据跟进记录号删除跟进记录信息
     *
     * @param id 跟进记录号
     * @return Error对象
     */
    Error deleteRecord(int id);

    /**
     * 批量删除记录信息
     *
     * @return Error对象
     */
    Error deleteRecords(Record[] list);

    /**
     * 获得所有记录信息
     *
     * @return Response对象
     */
    Response getAllRecord();

    /**
     * 根据跟进记录号得到跟进记录信息
     *
     * @param id 跟进记录号
     * @return Record实体
     */

    Record getRecordById(int id);

    /**
     * 获取一定数量的记录简介
     * @param count
     * @return
     */
    Response getBriefRecord(int count);

}
