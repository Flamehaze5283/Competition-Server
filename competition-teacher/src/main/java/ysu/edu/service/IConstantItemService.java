package ysu.edu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ysu.edu.pojo.ConstantItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 常数项表 服务类
 * </p>
 *
 * @author zh
 * @since 2020-09-20
 */
public interface IConstantItemService extends IService<ConstantItem> {
    Object list(ConstantItem constantItem);
    boolean add(ConstantItem constantItem);
    boolean batchdel(Integer[] ids);

    Object getItems(String typeName);
    Object getItems(String typeName, Integer type) throws JsonProcessingException;

    String getName(String type, Integer code);
}
