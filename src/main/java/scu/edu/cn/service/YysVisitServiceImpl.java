package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.YysVisit;
import scu.edu.cn.dao.entity.YysVisitKey;
import scu.edu.cn.dao.mapper.YysVisitMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.DUPLICATE_USERNAME;
import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class YysVisitServiceImpl implements YysVisitService{
    @Autowired
    YysVisitMapper mapper;
    @Override
    public Error insertYysVisit(YysVisit yysVisit){
        Error error ;
        YysVisit yysVisit1;
        YysVisitKey yysVisitKey=new YysVisitKey();
        try{
            yysVisitKey.setYysId(yysVisit.getYysId());
            yysVisitKey.setVisitDate(yysVisit.getVisitDate());
            yysVisit1=mapper.selectByPrimaryKey(yysVisitKey);
            if(yysVisit1 != null)
            {
                error= new Error(DUPLICATE_USERNAME,"客户回访记录已存在");
            }else{
                mapper.insert(yysVisit);
                error= new Error(OPERATION_SUCCESS,"增加成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"增加失败");
        }
        return error;
    }

    @Override
    public Error updateYysVisit(YysVisit yysVisit){
        Error error ;
        try{
            mapper.updateByPrimaryKeyWithBLOBs(yysVisit);
            System.out.println(yysVisit.getContent());
            error= new Error(OPERATION_SUCCESS,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"更新失败");
        }
        return error;
    }

    @Override
    public Error deleteYysVisit(YysVisitKey yysVisitKey){
        Error error ;
        try{
            mapper.deleteByPrimaryKey(yysVisitKey);
            error= new Error(OPERATION_SUCCESS,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"删除失败");
        }
        return error;
    }

    @Override
    public List<YysVisit> selectAllYysVisit(){
        List<YysVisit> list = mapper.selectAllYysVisit();
        Response<List<YysVisit>> response = new Response<List<YysVisit>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS," "));
        return mapper.selectAllYysVisit();
    }
}
