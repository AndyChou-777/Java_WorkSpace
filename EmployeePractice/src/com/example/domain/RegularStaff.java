package com.example.domain;

public interface RegularStaff {
	
	public static String[] gifts = {"咖啡機", "洗衣機", "超大電視", "禮券", "機票" , "銘謝惠顧!"};
	
	public static String getLuckDraw() {
	    int i = (int)(Math.random() * gifts.length);
	    return "恭喜抽中" + gifts[i];
	}
	
	public default double calcPerMultiplier(){
		return (int)(Math.random()*5+1)*0.5;
	}
	
	public abstract double getBonus();
} 

