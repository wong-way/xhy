package scu.edu.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scu.edu.cn.dao.entity.YysExperience;
import scu.edu.cn.dao.mapper.YysExperienceMapper;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.DUPLICATE_USERNAME;
import static scu.edu.cn.util.Constant.OPERATION_ERROR;
import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Service
public class YysExperienceServiceImpl implements YysExperienceService{
    @Autowired
    YysExperienceMapper mapper;

    /**
     * @Parameter yysExperience
     * @Return error
     */
    @Override
    public Error insertYysExperience(YysExperience yysExperience){
        Error error ;
        YysExperience yysExperience1;
        try{
            yysExperience1=mapper.selectByPrimaryKey(yysExperience.getYysExperienceId());
            if(yysExperience1 != null)
            {
                error= new Error(DUPLICATE_USERNAME,"育婴师已存在");
            }else{
                mapper.insert(yysExperience);
                error= new Error(OPERATION_SUCCESS,"增加成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"增加失败");
        }
        return error;
    }

    /**
     * @Parameter yysExperience
     * @Return error
     */
    @Override
    public Error updateYysExperience(YysExperience yysExperience){
        Error error ;
        try{
            mapper.updateByPrimaryKey(yysExperience);
            error= new Error(OPERATION_SUCCESS,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"更新失败");
        }
        return error;
    }

    /**
     * @Parameter yysExperienceId
     * @Return error
     */
    @Override
    public Error deleteYysExperience(Integer yysExperienceId){
        Error error ;
        try{
            mapper.deleteByPrimaryKey(yysExperienceId);
            error= new Error(OPERATION_SUCCESS,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            error= new Error(OPERATION_ERROR,"删除失败");
        }
        return error;
    }

    /**
     * @Parameter
     * @Return List<YysExperience>
     */
    @Override
    public List<YysExperience> selectAllYysExperience(){
        List<YysExperience> list = mapper.selectAllYysExperience();
        Response<List<YysExperience>> response = new Response<List<YysExperience>>();
        response.setData(list);
        response.setError(new Error(OPERATION_SUCCESS," "));
        return mapper.selectAllYysExperience();
    }
}
