package com.lvg.order.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.commons.utils.IDUtils;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbGroupDubboService;
import com.lvg.dubbo.service.TbGroupItemDubboService;
import com.lvg.dubbo.service.TbOrderDubboService;
import com.lvg.order.pojo.TbOrderChild;
import com.lvg.order.service.TbOrderService;
import com.lvg.pojo.TbGroup;
import com.lvg.pojo.TbGroupItem;
import com.lvg.pojo.TbOrder;

@Service
public class TbOrderServiceImpl implements TbOrderService {
	@Reference
	private TbOrderDubboService tbOrderDubboServiceImpl;
	
	@Reference
	private TbGroupItemDubboService tbGroupItemDubboServiceImpl;
	
	@Reference
	private TbGroupDubboService tbGroupDubboServiceImpl;

	@Override
	public String getBookdate(long iid) throws ParseException {
		List<TbOrder> list = tbOrderDubboServiceImpl.selByIid(iid, true);
		Set<Integer> set = new HashSet<>();
		if (list!=null) {
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			String dateStr = format.format(date);
			Date today = format.parse(dateStr);
			for (TbOrder order : list) {
				Date intime = order.getIntime();
				if(intime.compareTo(today)==-1) {
					intime = today;
				}
				//获取两个 Date 之间所有的日期
				Calendar start = Calendar.getInstance();
			    start.setTime(intime);
			    Calendar end = Calendar.getInstance();
			    end.setTime(order.getOuttime());
			    while (start.before(end)) {
			    	set.add(Integer.parseInt(format.format(start.getTime())));
		            start.add(Calendar.DATE, 1);
			   }
			}
		}
		return JsonUtils.objectToJson(set);
	}

	@Override
	public LvgResult onBook(String order, String intime, String outtime) throws ParseException {
		TbOrder orderObj = JsonUtils.jsonToPojo(order, TbOrder.class);
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date in = format.parse(intime);
		Date out = format.parse(outtime);
		Date now = new Date();
		orderObj.setId(IDUtils.genItemId());
		orderObj.setCreated(now);
		orderObj.setUpdated(now);
		orderObj.setIntime(in);
		orderObj.setOuttime(out);
		// 获取房东ID
		TbGroupItem item = tbGroupItemDubboServiceImpl.selById(orderObj.getItemId());
		TbGroup group = tbGroupDubboServiceImpl.selById(item.getGroupId());
		orderObj.setHostId(group.getHostId());
		int ins = tbOrderDubboServiceImpl.insTbOrder(orderObj);
		LvgResult result = new LvgResult();
		if(ins==1) {
			result.setStatus(200);
		}
		return result;
	}

	@Override
	public WxDataGrid showList(boolean isLandlord, long uid, byte status, int page, int rows) {
		WxDataGrid dataGrid = tbOrderDubboServiceImpl.selByUidAndStatus(isLandlord, uid, status, page, rows);
		String json = JsonUtils.objectToJson(dataGrid.getRows());
		List<TbOrderChild> list= JsonUtils.jsonToList(json, TbOrderChild.class);
		for (TbOrderChild order : list) {
			TbGroupItem item = tbGroupItemDubboServiceImpl.selById(order.getItemId());
			TbGroup group = tbGroupDubboServiceImpl.selById(item.getGroupId());
			order.setTitle(item.getTitle());
			order.setPrice(item.getPrice());
			order.setRestype(group.getRestype());
			order.setType(item.getType());
			order.setRoom(item.getRoom());
			String image = item.getImage();
			String[] images = (image==null||image.equals("")?new String[1]:image.split(","));
			order.setImages(images);
			String beds = item.getBeds();
			int num = (beds==null || beds.equals("")?0:beds.split(",").length);
			order.setBedNum(num);
		}
		dataGrid.setRows(list);
		dataGrid.setStatus(200);
		return dataGrid;
	}

	@Override
	public LvgResult updTbOrder(String orderJson) {
		TbOrder order = JsonUtils.jsonToPojo(orderJson, TbOrder.class);
		order.setUpdated(new Date());
		int flag = tbOrderDubboServiceImpl.updTbOrder(order);
		LvgResult result = new LvgResult();
		if(flag==1) {
			result.setStatus(200);
		}
		return result;
	}
}
