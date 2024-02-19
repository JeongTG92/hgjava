package gym_Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.management.NotificationBroadcaster;
import javax.print.attribute.standard.JobMessageFromOperator;

public class GymDAO {
	Connection conn ;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	private Member mb;
	//회원등록
	public boolean Insertmb(Member mb) {
		conn=mDAO.getConn();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		sql = "insert into mb (m_no,\r\n"
				+ "            name,\r\n"
				+ "            email,\r\n"
				+ "            birth_date,\r\n"
				+ "            mw,\r\n"
				+ "            address,\r\n"
				+ "            phone)\r\n"
				+ "values  (?,\r\n"
				+ "         ?,\r\n"
				+ "         ?,\r\n"
				+ "         ?,\r\n"
				+ "         ?,\r\n"
				+ "         ?,\r\n"
				+ "         ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mb.getMno());
			psmt.setString(2, mb.getName());
			psmt.setString(3, mb.getEmail());
			psmt.setString(4, sdf.format(mb.getBirth()));
			psmt.setString(5, mb.getGender());
			psmt.setString(6, mb.getAddress());
			psmt.setString(7, mb.getPhone());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean selectMno(Member mb) {
	    conn = mDAO.getConn();
	    sql = "SELECT m_no FROM mb WHERE m_no = ?";

	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setInt(1, mb.getMno());

	        rs = psmt.executeQuery();
	        return rs.next(); // 결과가 있으면 true, 없으면 false 반환
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return false;
	}
	public boolean InsertmbShip(MemberShip mbs) {
		conn = mDAO.getConn();
		sql = "INSERT INTO mbship (mb_option,\r\n"
				+ "                mb_price)\r\n"
				+ "        VALUES (?,\r\n"
				+ "                ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mbs.getOption());
			psmt.setInt(2, mbs.getPrice());
			
			int r = psmt.executeUpdate();
			return r > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//단건 조회
	public Member selectMno1() {
		conn = mDAO.getConn();
		sql = "SELECT * FROM mb WHERE m_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mb.getMno());
			
			
			while(rs.next()) {
				mb = new Member();
				mb.setMno(rs.getInt("m_no"));
				mb.setName(rs.getString("name"));
				mb.setEmail(rs.getString("email"));
				mb.setBirth(rs.getDate("birth_date"));
				mb.setGender(rs.getString("mw"));
				mb.setAddress(rs.getString("address"));
				mb.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mb;
	}
	
	
	//회원 목록
	public List<Member> getList(String gender, int page){
		conn=mDAO.getConn();
		List<Member> list = new ArrayList<Member>();
		sql = "SELECT m_no,\r\n"
				+ "       name,\r\n"
				+ "       email,\r\n"
				+ "       birth_date,\r\n"
				+ "       mw,\r\n"
				+ "       address,\r\n"
				+ "       phone\r\n"
				+ "FROM (SELECT rownum rn, a.*\r\n"
				+ "      FROM(SELECT *\r\n"
				+ "           FROM mb\r\n"
				+ "           WHERE mw = nvl(?, mw)\r\n"
				+ "           ORDER BY m_no)a ) b\r\n"
				+ "WHERE b.rn > (? -1) * 5 AND b.rn <= (?) * 5";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gender);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.setMno(rs.getInt("m_no"));
				mb.setName(rs.getString("name"));
				mb.setEmail(rs.getString("email"));
				mb.setBirth(rs.getDate("birth_date"));
				mb.setGender(rs.getString("mw"));
				mb.setAddress(rs.getString("address"));
				mb.setPhone(rs.getString("phone"));
				list.add(mb);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	//정보수정
	public boolean updateMb(Member mb) {
		System.out.println(mb);
	    conn = mDAO.getConn();
	    sql = "UPDATE mb SET email = ?, address = ?, phone = ? WHERE m_no = ?";
	    
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, mb.getEmail());
	        psmt.setString(2, mb.getAddress());
	        psmt.setString(3, mb.getPhone());
	        psmt.setInt(4, mb.getMno());
	        
	        int r = psmt.executeUpdate();
	        if (r > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	//회원 삭제
	public boolean deleteMb(int mno) {
		conn = mDAO.getConn();
		sql = "DELETE FROM mb WHERE m_no = ? ";
		
		Member mb = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mno);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//성별로 목록 구성
	public int getTotalCnt(String gender) {
		conn = mDAO.getConn();
		sql = "SELECT COUNT (*) FROM mb WHERE mw = nvl(?,mw)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gender);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	public int getSalesByOption(String option) {
	    conn = mDAO.getConn();
	    sql = "SELECT SUM(mb_price) FROM mbship WHERE mb_option = ?";
	    
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, option);
	        rs = psmt.executeQuery();
	        
	        if (rs.next()) {
	            return rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources(); // 리소스 닫기
	    }
	    
	    return -1; // 오류 발생 시 -1 반환
	}
	
	public int getTotalSales() {
	    conn = mDAO.getConn();
	    sql = "SELECT SUM(mb_price) FROM mbship";
	    
	    try {
	        psmt = conn.prepareStatement(sql);
	        
	        rs = psmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	
	  private void closeResources(Connection conn, PreparedStatement psmt, ResultSet rs) {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (psmt != null) {
	                psmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
