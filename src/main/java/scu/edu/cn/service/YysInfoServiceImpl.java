package scu.edu.cn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.YysInfo;
import scu.edu.cn.dao.mapper.YysInfoMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.DUPLICATE_USERNAME;
import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class YysInfoServiceImpl implements YysInfoService{
    @Autowired
    YysInfoMapper mapper;

    /**
     * @Parameter yysInfo
     * @Return error
     */
    @Override
    public Error insertYysInfo(YysInfo yysInfo){
        Error error ;
        YysInfo yys;
        try{
            yys=mapper.selectByPrimaryKey(yysInfo.getYysId());
            if(yys != null)
            {
                error= new Error(DUPLICATE_USERNAME,"育婴师已存在");
            }else{
                mapper.insert(yysInfo);
                error= new Error(OPERATION_SUCCESS,"增加成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"增加失败");
        }
        return error;
    }

    /**
     * @Parameter yysInfo
     * @Return error
     */
    @Override
    public Error updateYysInfo(YysInfo yysInfo){
        Error error ;
        try{
            mapper.updateByPrimaryKey(yysInfo);
            error= new Error(OPERATION_SUCCESS,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"更新失败");
        }
        return error;
    }

    /**
     * @Parameter yysId
     * @Return error
     */
    @Override
    public Error deleteYysInfo(Integer yysId){
        Error error ;
        try{
            mapper.deleteByPrimaryKey(yysId);
            error= new Error(OPERATION_SUCCESS,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"删除失败");
        }
        return error;
    }

    /**
     * @Parameter
     * @Return List<YysInfo>
     */
    @Override
    public List<YysInfo> selectAllYysInfo(){
        List<YysInfo> list = mapper.selectAllYysInfo();
        Response<List<YysInfo>> response = new Response<List<YysInfo>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS," "));
        return mapper.selectAllYysInfo();
    }

}
