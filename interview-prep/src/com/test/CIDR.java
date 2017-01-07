package com.test;

import java.util.ArrayList;
import java.util.List;

public class CIDR {

	public List<String> ipRangeToCIDR(String startIp, int numIPs) {

		List<String> result = new ArrayList<String>();

				String[] split = startIp.split("\\.");

		int ip = (Integer.parseInt(split[0]) * 256 * 256 * 256) + 
				(Integer.parseInt(split[1]) * 256 * 256) +  
				(Integer.parseInt(split[2]) * 256) + 
				Integer.parseInt(split[3]);

		while(numIPs > 0) {


		}


		return result;
	}

	public static void main(String[] args) {
		CIDR cidr = new CIDR();

		System.out.println(cidr.ipRangeToCIDR("0.1.0.1", 4));
	}
}
