package scu.edu.cn.service;

import scu.edu.cn.dao.entity.YysVisit;
import scu.edu.cn.dao.entity.YysVisitKey;
import scu.edu.cn.util.Error;

import java.util.List;

public interface YysVisitService {
    /**
     * 插入一条育婴师回访记录
     *
     * @param yysVisit 育婴师回访记录
     * @return Error对象
     */
    Error insertYysVisit(YysVisit yysVisit);

    /**
     * 更新一条育婴师回访记录
     *
     * @param yysVisit 育婴师回访记录
     * @return Error对象
     */
    Error updateYysVisit(YysVisit yysVisit);

    /**
     * 删除一条育婴师回访记录
     *
     * @param yysVisitKey 育婴师回访记录的主键
     * @return Error对象
     */
    Error deleteYysVisit(YysVisitKey yysVisitKey);

    /**
     * 列出育婴师回访记录
     *
     * @return 育婴师回访记录列表
     */
    public List<YysVisit> selectAllYysVisit();
}
