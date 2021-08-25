package com.jk.integral.service;

import com.jk.integral.dao.IntegralStandardHskDao;
import com.jk.integral.entity.IntegralStandardHskEntity;
import com.jk.integral.utils.PoiUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * @Author hsk
 * @Description //积分标准
 * @Date 19:01 2021/4/21
 * @Param
 * @return
**/
@Service
public class IntegralStandardHskService {

    @Autowired
    private IntegralStandardHskDao integralStandardHskDao;
    /**
     * @Author hsk
     * @Description //积分标准
     * @Date 19:02 2021/4/21
     * @Param [integral]
     * @return 
    **/
    public List<IntegralStandardHskEntity> getIntegralSettingStandardList(IntegralStandardHskEntity integral) {

        return integralStandardHskDao.getIntegralSettingStandardList(integral);
    }
    /**
     * @Author hsk
     * @Description //类别动态查询
     * @Date 9:44 2021/4/22
     * @Param []
     * @return
    **/
    public List<IntegralStandardHskEntity> getType() {

        return integralStandardHskDao.getType();
    }
    /**
     * @Author hsk
     * @Description //新增积分标准
     * @Date 10:06 2021/4/22
     * @Param [integral]
     * @return
    **/
    public void addIntegralStandardHsk(IntegralStandardHskEntity integral) {

        integralStandardHskDao.addIntegralStandardHsk(integral);
    }
    /**
     * @Author hsk
     * @Description //积分标准删除
     * @Date 10:38 2021/4/22
     * @Param [id]
     * @return
     **/
    public void delIntegralSettingStandard(Integer id) {

        integralStandardHskDao.delIntegralSettingStandard(id);
    }
    /**
     * @Author hsk
     * @Description //积分标准回显
     * @Date 11:07 2021/4/22
     * @Param [id]
     * @return
     **/
    public IntegralStandardHskEntity getIntegralSettingStandardHui(Integer id) {

        return integralStandardHskDao.getIntegralSettingStandardHui(id);
    }
    /**
     * @Author hsk
     * @Description //积分标准修改
     * @Date 14:11 2021/4/22
     * @Param [integral]
     * @return
     **/
    public void updateIntegralSettingStandard(IntegralStandardHskEntity integral) {

        integralStandardHskDao.updateIntegralSettingStandard(integral);
    }
    /**
     * @Author hsk
     * @Description //导出
     * @Date 14:05 2021/4/22
     * @Param [request, response]
     * @return
     **/
    public void exportDate(HttpServletRequest request, HttpServletResponse response) {
        //查询需要导出的数据
        List<IntegralStandardHskEntity> list=integralStandardHskDao.query();
        // 1、创建excel工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 2、创建行：标题、下标从0开始
        String[] titles = { "编号", "类别", "积分标题", "分数" ,"详细要求" ,"可见范围" ,"申请频次" ,"审核人" };
        String sheetName="积分标准";
        XSSFSheet sheet = PoiUtil.exportData(workbook, sheetName, titles );
        for (int i = 0; i < list.size(); i++){
            IntegralStandardHskEntity entity = list.get(i);
            XSSFRow row = sheet.createRow(i + 1);// 1、2、3...
            row.createCell(0).setCellValue(entity.getIntegralId());
            if(entity.getIntegralType()==1){
                row.createCell(1).setCellValue("贴心服务");
            }else if(entity.getIntegralType()==2){
                row.createCell(1).setCellValue("工作态度");
            }else if(entity.getIntegralType()==3){
                row.createCell(1).setCellValue("5S管理类");
            }else if(entity.getIntegralType()==4){
                row.createCell(1).setCellValue("质量管理");
            }else if(entity.getIntegralType()==5){
                row.createCell(1).setCellValue("管理会议");
            }else if(entity.getIntegralType()==6){
                row.createCell(1).setCellValue("精益改善");
            }else if(entity.getIntegralType()==7){
                row.createCell(1).setCellValue("店面销售");
            }else if(entity.getIntegralType()==8){
                row.createCell(1).setCellValue("业绩相关");
            }else{
                row.createCell(1).setCellValue("其他");
            }

            row.createCell(2).setCellValue(entity.getIntegralHead());
            row.createCell(3).setCellValue(entity.getIntegralGrade());
            row.createCell(4).setCellValue(entity.getIntegralRemark());
            row.createCell(5).setCellValue(entity.getIntegralVisualRange());
            row.createCell(6).setCellValue(entity.getIntegralFrequency());
            row.createCell(7).setCellValue(entity.getIntegralAuditor());
        }
        Date date = new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        PoiUtil.down(response, workbook, "积分标准-"+sim.format(date)+".xlsx");

    }
    /**
     * @Author hsk
     * @Description //批量修改类别
     * @Date 15:06 2021/4/22
     * @Param []
     * @return
     **/
    public void updateAll(String[] ids, Integer addid) {

        for (int i = 0; i < ids.length; i++) {
            integralStandardHskDao.updateAll(ids[i],addid);
        }
    }
    /**
     * @Author hsk
     * @Description //暂停
     * @Date 15:20 2021/4/22
     * @Param [id]
     * @return
     **/
    public void suspendIntegralSettingStandard(Integer id) {

        integralStandardHskDao.suspendIntegralSettingStandard(id);
    }
    /*/////积分类别管理//////////////////////////积分类别管理//////////////////////积分类别管理////////////////////////////////////////*/
    /**
     * @Author hsk
     * @Description //积分类别管理-查询
     * @Date 15:40 2021/4/22
     * @Param []
     * @return
     *
     * @param integralStandardHskEntity*/
    public List<IntegralStandardHskEntity> getclassificationOfIntegralStandardList(IntegralStandardHskEntity integralStandardHskEntity) {

        return integralStandardHskDao.getclassificationOfIntegralStandardList(integralStandardHskEntity);
    }
    /**
     * @Author hsk
     * @Description //积分类别管理-增加
     * @Date 16:11 2021/4/22
     * @Param [integralStandardHskEntity]
     * @return
     **/
    public void addclassificationOfIntegralStandard(IntegralStandardHskEntity integralStandardHskEntity) {

        integralStandardHskDao.addclassificationOfIntegralStandard(integralStandardHskEntity);
    }
    /**
     * @Author hsk
     * @Description //T积分类别管理回显
     * @Date 16:19 2021/4/22
     * @Param [id]
     * @return
     **/
    public IntegralStandardHskEntity gettypeTypeId(Integer id) {

        return integralStandardHskDao.gettypeTypeId(id);
    }
    /**
     * @Author hsk
     * @Description //T积分类别管理修改
     * @Date 16:19 2021/4/22
     * @Param [id]
     * @return
     **/
    public void updateClassificationOfIntegralStandard(IntegralStandardHskEntity integralStandardHskEntity) {

        integralStandardHskDao.updateClassificationOfIntegralStandard(integralStandardHskEntity);
    }
    /**
     * @Author hsk
     * @Description //积分类别管理删除
     * @Date 16:45 2021/4/22
     * @Param [id]
     * @return
     **/
    public void deltypeType(Integer id) {

        integralStandardHskDao.deltypeType(id);
    }
    /**
     * @Author hsk
     * @Description ///*已暂停的标准-查询
     * @Date 16:50 2021/4/22
     * @Param [Integral]
     * @return
     **/
    public List<IntegralStandardHskEntity> getSuspendedStandardsList(IntegralStandardHskEntity integral) {

        return integralStandardHskDao.getSuspendedStandardsList(integral);
    }

    public void recovery(Integer id) {

        integralStandardHskDao.recovery(id);
    }
}
