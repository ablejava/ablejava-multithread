package com.zhihuishu.junit;

import java.util.ArrayList;
import java.util.List;

public class JTest {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		/*
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		Collections.shuffle(list);
		for (String string : list) {
			System.err.println(string);
		}*/
		
		/*String dateString = DateUtils.getDateMilliFormat(new Date());
		System.out.print(dateString);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("1",null);

		String obj = (String)map.get("1");
		System.out.print(obj+"***********");


		HashSet<String> set = new HashSet<String>();

		float a =0;
		float b=0;
		float c=Float.parseFloat(a+"");*/
		/*System.out.print("-------------------");
		System.out.println();
		String questionType ="4";
		if (!(questionType.equals("1") || questionType.equals("2") || questionType.equals("14"))) {
			System.out.print("--------true-----------");
		}*/
		Double totalScore =0.0;
		//保留一位小数
		/*totalScore +=Double.parseDouble("9.0");
		BigDecimal scoreBigDecimal = new BigDecimal(totalScore);
		totalScore = scoreBigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		String subTotalScore = NumberTools.subZeroAndDot(String.format("%.2f", totalScore));
		System.out.print(totalScore+"-------------------"+subTotalScore);*/

		Double d = 50.0;
		System.out.print(d.intValue()+"");



		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
