
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 奖惩
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiangcheng")
public class JiangchengController {
    private static final Logger logger = LoggerFactory.getLogger(JiangchengController.class);

    @Autowired
    private JiangchengService jiangchengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private FenshujiluService fenshujiluService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiangchengService.queryPage(params);

        //字典表数据转换
        List<JiangchengView> list =(List<JiangchengView>)page.getList();
        for(JiangchengView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiangchengEntity jiangcheng = jiangchengService.selectById(id);
        if(jiangcheng !=null){
            //entity转view
            JiangchengView view = new JiangchengView();
            BeanUtils.copyProperties( jiangcheng , view );//把实体数据重构到view中

                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(jiangcheng.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiangchengEntity jiangcheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiangcheng:{}",this.getClass().getName(),jiangcheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            jiangcheng.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jiangcheng.setInsertTime(new Date());
            jiangcheng.setCreateTime(new Date());
            jiangchengService.insert(jiangcheng);






            XueshengEntity xueshengEntity = xueshengService.selectById(jiangcheng.getXueshengId());
            if(xueshengEntity == null)
                return R.error("查不到学生");
            if(jiangcheng.getJiangchengTypes().intValue() == 1){
                xueshengEntity.setXueshengFenshu(xueshengEntity.getXueshengFenshu()+jiangcheng.getJiangchengFenshu());
            }else if(jiangcheng.getJiangchengTypes().intValue() == 2){
                xueshengEntity.setXueshengFenshu(xueshengEntity.getXueshengFenshu()-jiangcheng.getJiangchengFenshu());
            }else{
                return R.error("删除字典表奖励惩罚的一级分类了,这个不能删除");
            }
            xueshengService.updateById(xueshengEntity);

            FenshujiluEntity fenshujiluEntity = new FenshujiluEntity();
            fenshujiluEntity.setCreateTime(new Date());
            fenshujiluEntity.setInsertTime(new Date());
            fenshujiluEntity.setXueshengId(jiangcheng.getXueshengId());
            fenshujiluEntity.setFenshujiluFenshu(jiangcheng.getJiangchengFenshu());
            if(jiangcheng.getJiangchengTypes().intValue() == 1){
                fenshujiluEntity.setFenshujiluTypes(1);
                fenshujiluEntity.setFenshujiluContent("得到"+jiangcheng.getJiangchengFenshu()+"分");
            }else if(jiangcheng.getJiangchengTypes().intValue() == 2){
                fenshujiluEntity.setFenshujiluTypes(2);
                fenshujiluEntity.setFenshujiluContent("扣减"+jiangcheng.getJiangchengFenshu()+"分");
            }else{
                return R.error("删除字典表奖励惩罚的一级分类了,这个不能删除");
            }
            fenshujiluService.insert(fenshujiluEntity);


            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiangchengEntity jiangcheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiangcheng:{}",this.getClass().getName(),jiangcheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            jiangcheng.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiangchengEntity> queryWrapper = new EntityWrapper<JiangchengEntity>()
            .notIn("id",jiangcheng.getId())
            .andNew()
            .eq("xuesheng_id", jiangcheng.getXueshengId())
            .eq("jiangcheng_uuid_number", jiangcheng.getJiangchengUuidNumber())
            .eq("jiangcheng_name", jiangcheng.getJiangchengName())
            .eq("jiangcheng_types", jiangcheng.getJiangchengTypes())
            .eq("jiangcheng_erji_types", jiangcheng.getJiangchengErjiTypes())
            .eq("jiangcheng_jibie_types", jiangcheng.getJiangchengJibieTypes())
            .eq("jiangcheng_fenshu", jiangcheng.getJiangchengFenshu())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiangchengEntity jiangchengEntity = jiangchengService.selectOne(queryWrapper);
        if(jiangchengEntity==null){
            jiangchengService.updateById(jiangcheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiangchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiangchengEntity> jiangchengList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiangchengEntity jiangchengEntity = new JiangchengEntity();
//                            jiangchengEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            jiangchengEntity.setJiangchengUuidNumber(data.get(0));                    //奖惩编号 要改的
//                            jiangchengEntity.setJiangchengName(data.get(0));                    //奖惩名称 要改的
//                            jiangchengEntity.setJiangchengTypes(Integer.valueOf(data.get(0)));   //奖惩类型 要改的
//                            jiangchengEntity.setJiangchengErjiTypes(Integer.valueOf(data.get(0)));   //二级类型 要改的
//                            jiangchengEntity.setJiangchengJibieTypes(Integer.valueOf(data.get(0)));   //奖惩级别 要改的
//                            jiangchengEntity.setJiangchengFenshu(Integer.valueOf(data.get(0)));   //奖惩分数 要改的
//                            jiangchengEntity.setJiangchengContent("");//详情和图片
//                            jiangchengEntity.setInsertTime(date);//时间
//                            jiangchengEntity.setCreateTime(date);//时间
                            jiangchengList.add(jiangchengEntity);


                            //把要查询是否重复的字段放入map中
                                //奖惩编号
                                if(seachFields.containsKey("jiangchengUuidNumber")){
                                    List<String> jiangchengUuidNumber = seachFields.get("jiangchengUuidNumber");
                                    jiangchengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiangchengUuidNumber = new ArrayList<>();
                                    jiangchengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiangchengUuidNumber",jiangchengUuidNumber);
                                }
                        }

                        //查询是否重复
                         //奖惩编号
                        List<JiangchengEntity> jiangchengEntities_jiangchengUuidNumber = jiangchengService.selectList(new EntityWrapper<JiangchengEntity>().in("jiangcheng_uuid_number", seachFields.get("jiangchengUuidNumber")));
                        if(jiangchengEntities_jiangchengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiangchengEntity s:jiangchengEntities_jiangchengUuidNumber){
                                repeatFields.add(s.getJiangchengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [奖惩编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiangchengService.insertBatch(jiangchengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
