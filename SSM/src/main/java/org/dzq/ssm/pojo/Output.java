package org.dzq.ssm.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Output {
    private Integer oid;

    private String name;

    private Integer pcount;

    private double price;

    private String annt;

    private String outputtime;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPcount() {
		return pcount;
	}

	public void setPcount(Integer pcount) {
		this.pcount = pcount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAnnt() {
		return annt;
	}

	public void setAnnt(String annt) {
		this.annt = annt;
	}

	public String getOutputtime() {
		return outputtime;
	}

	public void setOutputtime(String outputtime) {
		this.outputtime = outputtime;
	}

    
}