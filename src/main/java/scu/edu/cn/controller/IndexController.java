package scu.edu.cn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.CustomerVisit;
import scu.edu.cn.dao.entity.Receipt;
import scu.edu.cn.dao.entity.Record;
import scu.edu.cn.dao.entity.StaffInfo;
import scu.edu.cn.dto.*;
import scu.edu.cn.service.*;
import scu.edu.cn.util.Response;

import java.util.List;

import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

/**
 * @author 黄伟
 * 处理主页信息
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    ContractService contractService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ReceiptService receiptService;
    @Autowired
    CustomerVisitService customerVisitService;
    @Autowired
    UserService userService;
    @Autowired
    ReceptionSituationService receptionSituationService;
    @Autowired
    RecordService recordService;
    @Autowired
    StaffInfoService staffInfoService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取主页概述
     * @return Summary对象
     */
    @ResponseBody
    @RequestMapping(value = "api/getSummary", method = RequestMethod.GET)
    public Summary getSummary() {
        logger.info("请求获取主页概述");
        Integer userCount = userService.selectAllUser().size();
        Integer customerCount = customerService.getAllCustomer().getData().size();
        Integer receiptCount = receiptService.selectAllReceipt().getData().size();
        Integer visitCount = customerVisitService.selectAllCustomerVisit().size();
        Summary summary = new Summary(userCount, customerCount, receiptCount, visitCount);
        if(summary!=null)
            logger.info("获取主页概述成功");
        else
            logger.info("获取主页概述失败");
        return summary;
    }

    /**
     * 获取订单情况
     * @return Order对象
     */
    @ResponseBody
    @RequestMapping(value = "api/getOrder", method = RequestMethod.GET)
    public Order getOrder() {
        logger.info("请求获取主页订单情况");
        Integer contractCount = contractService.getAll().getData().size();
        Integer recentCount = contractService.getRecent().getData().size();
        Double price = contractService.getAllContractPrice();
        Order order = new  Order(contractCount, recentCount, price);
        if(order!=null)
            logger.info("获取主页订单成功");
        else
            logger.info("获取主页订单失败");
        return order;
    }

    /**
     * 请求获取主页收款数据情况
     * @return 收款数据列表
     */
    @ResponseBody
    @RequestMapping(value = "api/getReception", method = RequestMethod.GET)
    public  List<Reception> getReception() {
        logger.info("请求获取主页收款数据情况");

        List<Reception> list = receptionSituationService.selectTopFive();
        if(list!=null)
            logger.info("获取主页收款数据成功");
        else
            logger.info("获取主页收款数据失败");
        return list;
    }

    /**
     * 请求获取简单跟进记录
     * @return 简单跟进记录列表
     */
    @ResponseBody
    @RequestMapping(value = "api/getBriefRecord", method = RequestMethod.GET)
    public  List<BriefRecord> getBriefRecord() {
        logger.info("请求获取主页跟进记录情况");

        Response<List<BriefRecord>> response = recordService.getBriefRecord(5);
        if(response.getError().getCode()==OPERATION_SUCCESS){
            logger.info("获取主页收款数据情况成功");
        }else{
            logger.info("请求获取主页跟进记录失败，{}",response.getError().getMessage());
        }
        return response.getData();
    }
    @ResponseBody
    @RequestMapping(value = "api/getEachDay", method = RequestMethod.GET)
    public  List<DetailContract> getEachDay() {
        logger.info("请求获取主页合同近况");

        Response<List<DetailContract>> response = contractService.getEachDayDetail();
        if(response.getError().getCode()==OPERATION_SUCCESS){
            logger.info("获取主页合同近况成功");
        }else{
            logger.info("请求获取合同近况失败，{}",response.getError().getMessage());
        }
        return response.getData();
    }
    @ResponseBody
    @RequestMapping(value = "api/getDutyOnStaff", method = RequestMethod.GET)
    public  List<StaffInfo> getDutyOnStaff() {
        logger.info("请求获取主页在职员工情况");

        List<StaffInfo> list = staffInfoService.selectOnDutyStaff();
        if(list!=null)
            logger.info("获取主页在职员工成功");
        else
            logger.info("获取主页在职员工失败");
        return list;
    }
}
