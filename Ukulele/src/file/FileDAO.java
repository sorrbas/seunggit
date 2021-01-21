package file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import file.FileBean;

public class FileDAO {
	
	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private int result = 0 ;
	private static FileDAO instance = new FileDAO();
	
	public static FileDAO getInstance() {
		return instance;
	}
	
	//DB연결
	public void getConnection() throws ClassNotFoundException, IOException, SQLException {
		InputStream in = (this.getClass().getResourceAsStream("dd.properties"));
		Properties p = new Properties();
		p.load(in);
		
		String url = p.getProperty("dburl");
		String id = p.getProperty("dbid");
		String pw = p.getProperty("dbpw");

		Class.forName(p.getProperty("dbclass"));
		con = DriverManager.getConnection(url, id, pw);
	}
	
	//DB연결 종료
	public void close() throws SQLException {
		if(rs!=null) rs.close();
		if(psmt!=null) psmt.close();
		if(con!=null) con.close();
	}
	
	//파일업로드
	public int uploadFile(FileBean bean) throws SQLException, ClassNotFoundException, IOException {
		getConnection();
		
		int ref = 0;
		int re_step = 1;
		int re_level = 1;
		
		String refsql = "select max(ref) from gallery";
		psmt = con.prepareStatement(refsql);
		rs = psmt.executeQuery();
		if(rs.next()) {
			ref = rs.getInt(1)+1;
		}
		
//		psmt = con.prepareStatement("insert into fileboard values(file_num.nextval,?,?,?,to_char(sysdate, 'YYYY-MM-DD'))");
	    psmt = con.prepareStatement("insert into gallery(writer, subject, email, password, fileName, reg_date, ref, re_step, re_level, readcount, content) values(?,?,?,?,?, now(), ?, ?, ?, 0, ?)");
	    psmt.setString(1, bean.getWriter());
		psmt.setString(2, bean.getSubject());
		psmt.setString(3, bean.getEmail());
		psmt.setString(4, bean.getPassword());
		psmt.setString(5, bean.getFileName());
		psmt.setInt(6, ref);
		psmt.setInt(7, re_step);
		psmt.setInt(8, re_level);
		psmt.setString(9, bean.getContent());
		
		result = psmt.executeUpdate();
		
		close();
		
		return result;
	}

	public Vector<FileBean> selectAll(int start, int end) throws ClassNotFoundException, IOException, SQLException {
		getConnection();
		
		Vector<FileBean> v = new Vector<>();
		psmt = con.prepareStatement("Select * from gallery order by num DESC LIMIT ?, 16");
		psmt.setInt(1, start-1);
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			FileBean bean =new FileBean();
			bean.setNum(rs.getInt("num"));
			bean.setWriter(rs.getString("writer"));
			bean.setSubject(rs.getString("subject"));
			bean.setEmail(rs.getString("email"));
			bean.setPassword(rs.getString("password"));
			bean.setFileName(rs.getString("fileName"));
			bean.setReg_date(rs.getDate("reg_date").toString());
			bean.setRef(rs.getInt("ref"));
			bean.setRe_step(rs.getInt("re_step"));
			bean.setRe_level(rs.getInt("re_level"));
			bean.setReadcount(rs.getInt("readcount"));
			bean.setContent(rs.getString("content"));
			v.add(bean);
		}
		
		close();
		
		return v;
	}

	public FileBean SelectOne(int num) throws ClassNotFoundException, IOException, SQLException {
		getConnection();
		
		psmt = con.prepareStatement("select * from gallery where num=?");
		psmt.setInt(1, num);
		rs = psmt.executeQuery();
		
		FileBean bean = new FileBean();
		
		if(rs.next()) {
			bean.setNum(rs.getInt("num"));
			bean.setWriter(rs.getString("writer"));
			bean.setSubject(rs.getString("subject"));
			bean.setEmail(rs.getString("email"));
			bean.setPassword(rs.getString("password"));
			bean.setFileName(rs.getString("fileName"));
			bean.setReg_date(rs.getDate("reg_date").toString());
			bean.setRef(rs.getInt("ref"));
			bean.setRe_step(rs.getInt("re_step"));
			bean.setRe_level(rs.getInt("re_level"));
			bean.setReadcount(rs.getInt("readcount"));
			bean.setContent(rs.getString("content"));
		}
		
		close();
		
		return bean;
	}
	
	public void reWriteGallery(FileBean bean)throws ClassNotFoundException, SQLException, IOException {
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();
		
		
		getConnection();
		
		psmt = con.prepareStatement("update gallery set re_level = re_level+1 where ref=? and re_level >?");
		psmt.setInt(1, ref);
		psmt.setInt(2, re_level);
		psmt.executeUpdate();
		
		
		 psmt = con.prepareStatement("insert into gallery(writer, subject, email, passwoard, fileName, reg_date,"
		 		+ "ref, re_step, re_level, readcount, content");
		 
		 psmt.setString(1, bean.getWriter());
		 psmt.setString(2, bean.getSubject());
		 psmt.setString(3, bean.getEmail());
		 psmt.setString(4, bean.getPassword());
		 psmt.setString(5, bean.getFileName());
		 psmt.setInt(6, ref);
		 psmt.setInt(7, re_step+1);
		 psmt.setInt(8, re_level+1);
		 psmt.setString(9, bean.getContent());
		 psmt.executeUpdate();
		
		 close(); 		 
	}
	// galleryUpdate용 delete시 하나의 게시글을 리턴
	public FileBean getOneUpdateGallery(int num)throws ClassNotFoundException, SQLException, IOException  {
		FileBean bean = new FileBean();
		getConnection();
		
	psmt = con.prepareStatement("select * from gallery where num=?");
	psmt.setInt(1, num);
	rs=psmt.executeQuery();
	if(rs.next()) {
		bean.setNum(rs.getInt("num"));
		bean.setWriter(rs.getString("writer"));
		bean.setSubject(rs.getString("subject"));
		bean.setEmail(rs.getString("email"));
		bean.setPassword(rs.getString("password"));
		bean.setFileName(rs.getString("fileName"));
		bean.setReg_date(rs.getDate("reg_date").toString());
		bean.setRef(rs.getInt("ref"));
		bean.setRe_step(rs.getInt("re_step"));
		bean.setRe_level(rs.getInt("re_level"));
		bean.setReadcount(rs.getInt("readcount"));
		bean.setContent(rs.getString("content"));
	}
	close();		
	return bean;
	}
	public String getPass(int num){
		String pass = "";
		try {
			getConnection();
			System.out.println(num);
			
			psmt = con.prepareStatement("select password from gallery where num = ?");
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			if(rs.next()) {
				pass = rs.getString(1);
			}
			close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pass;
	}
	  public String getID(int num)  {
	      String id = "";
	      try {
	         getConnection();
	         System.out.println(num);
	            psmt = con.prepareStatement("select writer from gallery where num = ?");
	            psmt.setInt(1, num);
	            rs = psmt.executeQuery();
	            //패스워드 값 저장
	            if(rs.next()) {
	               id=rs.getString(1);
	            }
	            close();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	         return id;
	   }
	public int updateGallery(FileBean bean)throws ClassNotFoundException, SQLException, IOException {
		getConnection();
		psmt = con.prepareStatement("update gallery set subject = ?, content = ?, fileName = ? where num = ?");
		psmt.setString(1, bean.getSubject());
		psmt.setString(2, bean.getContent());
		psmt.setString(3, bean.getFileName());
		psmt.setInt(4, bean.getNum());
		result = psmt.executeUpdate();
		close();
		return result;
	}
	public void deleteGallery(int num) {
		try {
			getConnection();
			
			psmt = con.prepareStatement("delete from gallery where num = ?");
			psmt.setInt(1, num);
			psmt.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getAllCount()throws ClassNotFoundException, SQLException, IOException {
		getConnection();
		int count = 0;
		
		psmt = con.prepareStatement("select count(*) from gallery");
		rs = psmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
			con.close();
		}
		return count;
	}
	public int getCount(String subjectSearch, String keyword)throws ClassNotFoundException, SQLException, IOException  {
		getConnection();
		int count = 0;
		
		psmt = con.prepareStatement("select count(*) from gallery where " +keyword+ " like ?");
		psmt.setString(1, "%"+subjectSearch+"%");
		rs = psmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
			con.close();
		}
		return count;
	}
	public ArrayList<FileBean> searchGallery(int pageNum, int pageList, String subjectSearch, String keyword)throws ClassNotFoundException, SQLException, IOException {
		ArrayList<FileBean> v = new ArrayList<>();
		getConnection();
		psmt = con.prepareStatement("select num, subject, content, writer, fileName, reg_date, readcount from gallery where " +keyword+ " like ? "
				+"order by ref desc, re_step asc, num desc limit ?,?");
		psmt.setString(1, "%"+subjectSearch+"%");
		psmt.setInt(2, pageList*(pageNum-1));
		psmt.setInt(3, pageList);
		rs = psmt.executeQuery();
		while(rs.next()) {
			FileBean bean = new FileBean();
			bean.setNum(rs.getInt("num"));
			bean.setSubject(rs.getString("subject"));
			bean.setContent(rs.getString("content"));
			bean.setWriter(rs.getString("writer"));
			bean.setFileName(rs.getString("fileName"));
			bean.setReg_date(rs.getDate("reg_date").toString());
			bean.setReadcount(rs.getInt("readcount"));
			v.add(bean);
		}
		return v;
	}
	public void deleteGalleryFile(HttpServletRequest request, String fileSysGallery) {
	      String filePath = request.getRealPath("Upload");
	      File file = new File(filePath + "/" + fileSysGallery);
	      file.delete();   
	   }
	
}
