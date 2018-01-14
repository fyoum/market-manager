package service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mapper.TbItemMapper;
import com.pojo.TbItem;
import com.pojo.TbItemExample;

import service.ItemService;

@Service
public class ItemServiceImp implements ItemService {
	
	
	private TbItemMapper tbItemMapper;

	public TbItemMapper getTbItemMapper() {
		return tbItemMapper;
	}

	public void setTbItemMapper(TbItemMapper tbItemMapper) {
		this.tbItemMapper = tbItemMapper;
	}

	
	@Override
	public TbItem getItemById(long itemId) {
		
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
		}

}
