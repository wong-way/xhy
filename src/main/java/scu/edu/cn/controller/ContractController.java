package scu.edu.cn.controller;
/**
 * @author 黄伟
 * 处理合同相关操作
 */

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.Contract;
import scu.edu.cn.service.ContractService;
import scu.edu.cn.util.Error;
import scu.edu.cn.util.Response;

import javax.servlet.http.HttpSession;
import java.util.List;

import static scu.edu.cn.util.Constant.OPERATION_SUCCESS;

@Controller
@RequestMapping("/")
public class ContractController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ContractService service;

    /**
     * API接口，返回合同列表json数据
     *
     * @return 包含json格式数据的List
     */
    @ResponseBody
    @RequestMapping("api/contractList")
    public List<Contract> getList() {
        logger.info("获取合同信息列表");
        Response response = service.getAll();
        if (response.getError().getCode() == OPERATION_SUCCESS) {
            logger.info("获取合同信息列表成功");
            return (List<Contract>) response.getData();
        }
        else{
            logger.info("获取合同信息列表成功");
        }
            return null;
    }

    /**
     * 页面控制器，返回页面信息
     *
     * @return 合同页面
     */

    @RequestMapping("contractList")
    public String getContractPage() {
        return "contractList.html";
    }

    /**
     * 页面控制器，返回编辑页面
     *
     * @return 合同页面
     */

    @RequestMapping("editContract")
    public String editContractPage() {
        return "editContract.html";
    }

    /**
     * 更新对应合同号的数据
     *
     * @param session    会话信息
     * @param contractId 合同号
     * @return 编辑页面
     */

    @RequestMapping(value = "updateContract/{id}")
    public String updateContractPage(HttpSession session, @PathVariable("id") int contractId) {
        logger.info("请求更新id= {}的合同信息",contractId);
        session.setAttribute("contractId", contractId);
        return "editContract.html";
    }

    /**
     * 根据传入的合同号，删除合同信息
     *
     * @param contractId 合同号
     * @return Error类包含错误信息和错误码
     */
    @ResponseBody
    @RequestMapping("api/deleteContract")
    public Error deleteContract(@RequestParam("contractId") Integer contractId) {
        logger.info("请求删除id= {}的合同信息",contractId);
        Error error = service.deleteContract(contractId);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("删除id= {}的合同信息成功",contractId);
        }else{
            logger.info("删除id= {}的合同信息成功",contractId);
        }
        return error;
    }

    /**
     * 批量删除合同信息
     *
     * @param list 合同信息数组
     * @return Error类 包含错误信息和错误码
     */

    @ResponseBody
    @RequestMapping("api/deleteContracts")
    public Error deleteContracts(@RequestBody Contract[] list) {
        logger.info("请求批量删除list= {}的合同信息",list);
        Error error = service.deleteContracts(list);
        System.out.println(list.length);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("批量删除成功");
        }else{
            logger.info("批量删除错误");
        }
        return error;
    }

    /**
     * 根据会话中是否有合同号来选择是增加合同信息还是更新信息
     *
     * @param info    json数据
     * @param session 会话
     * @return Error类包含错误信息和错误码
     */

    @ResponseBody
    @RequestMapping("api/editContract")
    public Error addContract(@RequestBody String info, HttpSession session) {
        Integer contractId = (Integer) session.getAttribute("contractId");
        Contract contract;
        Gson gson = new Gson();
        Error error;
        contract = gson.fromJson(info, Contract.class);
        System.out.println(info);
        if (contractId == null)
        {
            error = service.insertContract(contract);
            logger.info("请求插入一条新的合同信息",contractId);
        }
        else {
            contract.setContractId(contractId);
            error = service.updateContract(contract);
            logger.info("请求更新id为{}的合同信息",contractId);
        }
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("操作id为{}的合同成功",contractId);
        }else{
            logger.info("操作id为{}的合同失败",contractId);
        }

        return error;
    }

    /**
     * 根据session中的合同号更新合同信息
     *
     * @param info    json数据
     * @param session 会话信息
     * @return Error类包含错误信息和错误码
     */
    @RequestMapping("api/updateContract")
    public Error updateContract(@RequestBody String info, HttpSession session) {
        Integer contractId = (Integer) session.getAttribute("contractId");
        logger.info("请求更新id为{}的合同数据",contractId);
        Contract contract;
        Gson gson = new Gson();
        contract = gson.fromJson(info, Contract.class);
        contract.setContractId(contractId);
        Error error = service.updateContract(contract);
        if(error.getCode()==OPERATION_SUCCESS){
            logger.info("更新id为{}的合同信息成功",contractId);
        }else{
            logger.info("更新id为{}的合同信息异常",contractId);
        }
        return error;
    }

    /**
     * 获取合同信息
     * @param session 会话信息
     * @return 对应的合同信息
     */
    @ResponseBody
    @RequestMapping("api/getContract")
    public Contract getContract( HttpSession session) {
        Integer contractId = (Integer) session.getAttribute("contractId");

        Contract contract;
        if (contractId == null)
            return null;
        else {
           contract=service.getContractById(contractId);
           logger.info("请求获取id为{}的合同信息",contractId);
        }
        if(contract!=null){
            logger.info("获取id为{}的合同信息失败",contractId);
        }else{
            logger.info("获取id为{}的合同信息成功",contractId);
        }
        return contract;
    }
}
