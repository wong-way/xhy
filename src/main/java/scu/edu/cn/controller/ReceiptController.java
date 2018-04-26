package scu.edu.cn.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scu.edu.cn.dao.entity.Receipt;
import scu.edu.cn.service.ReceiptService;
import scu.edu.cn.util.Error;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;

    /**
     *添加收款记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/addReceipt",method = RequestMethod.POST)
    @ResponseBody
    public Error addReceipt(@RequestBody Receipt json){
//        Gson gson = new Gson();
//        Receipt receipt = gson.fromJson(json,Receipt.class);
        Error error = receiptService.insertReceipt(json);
        System.out.println(json);
        return error;
    }

    /**
     * 查找收款记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/selectReceipt",method = RequestMethod.POST)
    @ResponseBody
    public Error selectReceipt(@RequestBody String json){
        Gson gson = new Gson();
        Receipt receipt = gson.fromJson(json,Receipt.class);
        Error error = receiptService.selectReceptById(receipt.getReceiptId()).getError();
        return error;
    }

    /**
     * 删除收款记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/deleteReceipt",method = RequestMethod.POST)
    @ResponseBody
    public Error deleteReceipt(@RequestParam("receiptId") Integer json){

//        Gson gson = new Gson();
//        Receipt receipt = gson.fromJson(json,Receipt.class);
//        System.out.println(receipt.getReceiptId());
        System.out.println(json);
        Error error = receiptService.deleteReceiptById(json);
        return error;
    }

    /**
     * 更新收款记录
     * @param json
     * @return
     */
    @RequestMapping(value = "api/updateReceipt",method = RequestMethod.POST)
    @ResponseBody
    public Error updateReceipt(@RequestBody Receipt json){
//        Gson gson = new Gson();
//        System.out.println(json);
//        Receipt receipt = gson.fromJson(json,Receipt.class);
        //info.setToken(new Token().getToken());
        Error error = receiptService.updateReceipt(json);
        return error;
    }

    /**
     * 查看收款记录，返回页面
     * @return
     */
    @RequestMapping("receiptList")
    public String getReceipt(){
        return "receiptList.html";
    }

    /**
     * 查找所有收款记录
     * @return
     */
    @ResponseBody
    @RequestMapping("api/receiptList")
    public List<Receipt> getReceiptList(){
        List<Receipt> list = receiptService.selectAllReceipt().getData();
        return list;
    }
    @ResponseBody
    @RequestMapping("api/briefReceiptList")
    public List<Receipt> getBriefReceiptList(){
        List<Receipt> list = receiptService.selectAllReceipt().getData();
        return list.subList(0,5);
    }
}
