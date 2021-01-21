package file;

public class Paging {
	 //화면에 보여질 게시글의 개수를 지정
   private int pageSize=16;
   private int count =0; //전체 글의 갯수를 저장하는 변수
   private int number =0; //페이지 넘버링 변수
   private String pageNum;

   private int startRow;
   private int endRow;
   
   private int currentPage;
   private int pageCount;
   private int startPage;
   private int pageBlock;
   private int endPage;
   
   
   private int prev; //이전
   private int next; //다음
   
   
   
	public Paging(String pageNum) {
	 //만약 처음 boardList.jsp를 클릭하거나 수정 삭제 등 다른 게시글에서 이 페이지로 넘어오면 pageNum값이 없기에 null 처리를 해줌
	  if(pageNum==null){
			 pageNum="1";
	  }
	  this.pageNum=pageNum;
	  
	  //전체 보고자 하는 페이지숫자를 저장
	  currentPage =Integer.parseInt(pageNum);
	}
	 

	public void setTotalCount(int count){
		
		this.count=count;
		
		//현재 페이지에 보여줄 시작 번호를 설정 = 데이터 베이스에서 불러올 시작번호
	    startRow =(currentPage-1) *pageSize+1;
		endRow =currentPage * pageSize;
		
		//테이블에 표시할 번호를 지정
		this.number =count - (currentPage -1 ) * pageSize;
		
		//페이지 계산
		pageCaculator();
	}
	 
	   
   public void pageCaculator(){
   	if(count  >0){
   		
   		pageCount =count /pageSize + (count%pageSize == 0 ?  0 :1) ; //카우터링 숫자를 얼마까지 보여줄건지 결정
   		
   		//시작 페이지 숫자를 설정
   		startPage =1;
   		
   		if(currentPage %10 !=0){
   			startPage =(int)(currentPage/10)*10+1;
   		}else{
   			startPage =((int)(currentPage/10)-1)*10+1;
   		}
   		
   		pageBlock=10;//카운터링 처리 숫자
   		endPage =startPage+pageBlock-1;//화면에 보여질 페이지의 마지막 숫자
   		if(endPage > pageCount) endPage =pageCount;
   		
   		
   		//이전 다음
   		if(startPage >pageSize)  prev =startPage-10;
   		//다음
   		if(endPage < pageCount) next=startPage+10;
   	}   		
   }


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getPageNum() {
		return pageNum;
	}


	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}


	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getPageBlock() {
		return pageBlock;
	}


	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getPrev() {
		return prev;
	}


	public void setPrev(int prev) {
		this.prev = prev;
	}


	public int getNext() {
		return next;
	}


	public void setNext(int next) {
		this.next = next;
	}

   
   
   
	 	
	
}
