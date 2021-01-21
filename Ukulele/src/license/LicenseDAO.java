package license;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import board.BoardBean;



public class LicenseDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public LicenseDAO() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public void getConnection(){
		try{
			conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
			//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void apply(LicenseBean bean){
		getConnection();
		try{
		String sql =" insert into licenseManage (name, tel, license_id, license_email, birth, addr, grade, apply_date)";
			   sql +=" values(? ,? , ?, ?, ?, ?, ?, ?) ";
			pstmt=conn.prepareStatement(sql);
			//?에 값을 맵핑	  	
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getLicense_id());
			pstmt.setString(4, bean.getLicense_email());
			pstmt.setString(5, bean.getBirth());
			pstmt.setString(6, bean.getAddr());
			pstmt.setString(7, bean.getGrade());
			pstmt.setString(8, bean.getDate());
			//쿼리를 실행하시오
			pstmt.executeUpdate();
			sql="update memberUK set trackingProgress=1, licenseGrade=? where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bean.getGrade()));
			pstmt.setString(2, bean.getLicense_id());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int getAllCount(){
		getConnection();
		//게시글 전체수를 저장하는 변수
		int count =0;
		try{
			//쿼리준비
			String sql ="select count(*) from licenseManage";
			//쿼리를 실행할 객체 선언
			pstmt = conn.prepareStatement(sql);
			//쿼리 실행 후 결과를 리턴
			rs=pstmt.executeQuery();
			if(rs.next()){
				count =rs.getInt(1);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	public void setTrackingProgress(int apply_no){
		getConnection();
		//게시글 전체수를 저장하는 변수
		try{
			//쿼리준비
			String sql ="update licenseManage set trackingProgress = 2 where apply_no="+apply_no;
			//쿼리를 실행할 객체 선언
			pstmt = conn.prepareStatement(sql);
			//쿼리 실행 후 결과를 리턴
			pstmt.execute();
			
			sql="select license_id from licenseManage where apply_no="+apply_no;
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			String getId = null;
			while(rs.next()) {
				getId=rs.getString("license_id");
			}
			
			sql="update memberUK set trackingProgress = 2 where id='"+getId+"'";
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void depositCancel(int apply_no){
		getConnection();
		//게시글 전체수를 저장하는 변수
		try{
			//쿼리준비
			String sql ="update licenseManage set trackingProgress = 1 where apply_no="+apply_no;
			//쿼리를 실행할 객체 선언
			pstmt = conn.prepareStatement(sql);
			//쿼리 실행 후 결과를 리턴
			pstmt.execute();
			sql="select license_id from licenseManage where apply_no="+apply_no;
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			String getId = null;
			while(rs.next()) {
				getId=rs.getString("license_id");
			}
			sql="update memberUK set trackingProgress = 1 where id='"+getId+"'";
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Vector<LicenseBean> getAllApply(int start, int end){		
		//리넡할 객체 선언
		Vector<LicenseBean> v =new Vector<>();
		getConnection();
		try{
			//쿼리 준비
			String sql = "SELECT * FROM licenseManage ORDER BY apply_no DESC LIMIT ?, 10";
			//쿼리를 실행할객체 선언
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, start-1);
//			pstmt.setInt(2, end);
			//쿼리실행 후 결과 저장
			rs=pstmt.executeQuery();
			//데이터 개수가 몇개인지 모르기에 반복문을 이용하여 데이터를 추출
			while(rs.next()){
				LicenseBean bean =new LicenseBean();
				bean.setApply_no(rs.getInt("apply_no"));
				bean.setName(rs.getString("name"));
				bean.setTel(rs.getString("tel"));
				bean.setLicense_email(rs.getString("license_email"));
				bean.setLicense_id(rs.getString("license_id"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getString("birth"));
				bean.setGrade(rs.getString("grade"));
				bean.setDate(rs.getString("apply_date"));
				bean.setTrackingProgress(rs.getInt("trackingProgress"));
				//패키징한 데이터를 벡터에 저장
				v.add(bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return v;
	}
}
