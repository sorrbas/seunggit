package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
    private int pageNum;
    private int amount;
    
    private String keyword;
    private String type; // 타입이 t냐 tc냐 tcw냐 cw냐에 따라 처리를 하려고함
    
    public Criteria() {
    	this(1,10);
    }
    public Criteria(int pageNum,int amount) {
    	this.pageNum=pageNum;
    	this.amount=amount;
    }
    
    public String[] getTypeArr() {
    	return type == null? new String[] {}: type.split("");
    }
    
}
