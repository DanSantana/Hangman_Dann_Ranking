package ca.dann.hangman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.dann.hangman.domain.HangUser;
import ca.dann.hangman.factory.ConnectionFactory;

public class UserDAO {

	public void newUser(HangUser user) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_users ");
		sql.append("(userName, userPassword)");
		sql.append("VALUES (?, ?)");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		cmd.setString(1, user.getUserName());
		cmd.setString(2, user.getUserPassword());

		cmd.executeUpdate();
	}

	public void updateHihestScore(HangUser user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_users ");
		
		
		sql.append("SET highestScore = ? ");
		sql.append("WHERE userName = ?");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		
		cmd.setInt(1, user.getHighestScore());
		cmd.setString(2, user.getUserName());	

		cmd.executeUpdate();
	}

	public void updateLastScore(HangUser user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_users ");
		sql.append("SET lastScore = ? ");
		sql.append("WHERE userName = ?");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());		
		cmd.setInt(1, user.getLastScore()); 
		cmd.setString(2, user.getUserName());
		cmd.executeUpdate();
	}
	public void updateTotalScore (HangUser user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_users ");
		sql.append("SET sumScore = ? ");
		sql.append("WHERE userName = ?");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());		
		cmd.setInt(1, user.getSumScore()); 
		cmd.setString(2, user.getUserName());
		cmd.executeUpdate();
	}
	
	public void updateVictory(HangUser user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_users ");
		sql.append("SET victories = ? ");
		sql.append("WHERE userName = ?");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());		
		cmd.setInt(1, user.getVictories()); 
		cmd.setString(2, user.getUserName());
		cmd.executeUpdate();
	}
	public void updateDefeat(HangUser user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_users ");
		sql.append("SET defeats = ? ");
		sql.append("WHERE userName = ?");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());		
		cmd.setInt(1, user.getDefeats()); 
		cmd.setString(2, user.getUserName());
		cmd.executeUpdate();
	}
	
	public HangUser searchUserName(HangUser user) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT userName, lastScore, highestScore, sumScore, victories, defeats, userPassword ");
		sql.append("FROM tbl_users ");
		sql.append("WHERE userName like ?");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		cmd.setString(1, user.getUserName());
		ResultSet result = cmd.executeQuery();
		HangUser userReply = null;

		if (result.next()) {
			userReply = new HangUser();
			userReply.setUserName(result.getString("userName"));
			userReply.setLastScore(result.getInt("lastScore"));
			userReply.setHighestScore(result.getInt("highestScore"));
			userReply.setSumScore(result.getInt("sumScore"));
			userReply.setVictories(result.getInt("victories"));
			userReply.setDefeats(result.getInt("defeats"));
			userReply.setUserPassword(result.getString("userPassword"));
		}
		return userReply;
	}

	public ArrayList<HangUser> listUsers() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT userName, lastScore, highestScore, sumScore, victories, defeats ");
		sql.append("FROM tbl_users ");
		sql.append("ORDER BY highestScore DESC");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());

		ResultSet result = cmd.executeQuery();

		ArrayList<HangUser> listing = new ArrayList<HangUser>();

		while (result.next()) {

			HangUser userReply = new HangUser();
			userReply = new HangUser();
			userReply.setUserName(result.getString("userName"));
			userReply.setLastScore(result.getInt("lastScore"));
			userReply.setHighestScore(result.getInt("highestScore"));
			userReply.setSumScore(result.getInt("sumScore"));
			userReply.setVictories(result.getInt("victories"));
			userReply.setDefeats(result.getInt("defeats"));
			listing.add(userReply);
		}
		return listing;
	}

	public ArrayList<HangUser> lisTop10Users() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT userName, lastScore, highestScore, sumScore, victories, defeats ");
		sql.append("FROM tbl_users ");
		sql.append("ORDER BY highestScore DESC ");
		sql.append("LIMIT 5");

		Connection con = ConnectionFactory.openConnection();

		PreparedStatement cmd = con.prepareStatement(sql.toString());

		ResultSet result = cmd.executeQuery();

		ArrayList<HangUser> listing = new ArrayList<HangUser>();

		while (result.next()) {
			HangUser userReply = new HangUser();
			userReply = new HangUser();
			userReply.setUserName(result.getString("userName"));
			userReply.setLastScore(result.getInt("lastScore"));
			userReply.setHighestScore(result.getInt("highestScore"));
			userReply.setSumScore(result.getInt("sumScore"));
			userReply.setVictories(result.getInt("victories"));
			userReply.setDefeats(result.getInt("defeats"));
			listing.add(userReply);
		}
		return listing;
	}

	public Boolean userNameAvailable(HangUser user) throws SQLException {

		Boolean availableUserName = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) AS QTY ");
		sql.append("FROM tbl_users ");
		sql.append("WHERE userName like ? ");

		Connection con = ConnectionFactory.openConnection();
		PreparedStatement cmd = con.prepareStatement(sql.toString());
		cmd.setString(1, user.getUserName());
		ResultSet result = cmd.executeQuery();

		result.next();
		int count = result.getInt("QTY");
		if (count != 0) {
			availableUserName = true;
		}
		return availableUserName;
	}

	public Boolean FindNameAndPass(HangUser user) throws SQLException {

		Boolean foundUser = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) AS QTY ");
		sql.append("FROM tbl_users ");
		sql.append("WHERE userName like ? ");
		sql.append("AND userPassword like ?");

		Connection con = ConnectionFactory.openConnection();

		PreparedStatement cmd = con.prepareStatement(sql.toString());

		cmd.setString(1, user.getUserName());
		cmd.setString(2, user.getUserPassword());

		ResultSet result = cmd.executeQuery();

		result.next();
		int count = result.getInt("QTY");
		if (count != 0) {
			foundUser = true;
		}
		
		return foundUser;
	}
}

/*	public static void main(String[] args) {
		HangUser u1 = new HangUser("jano", "1234");
		try {
			UserDAO dao = new UserDAO();
			Boolean yea = dao.FindNameAndPass(u1);
			if (yea == true) {				
				System.out.println("found user " + u1.getUserName());
			}else{
				System.out.println("not found user " + u1.getUserName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

/*
 * public static void main(String[] args) throws SQLException { HangUser u1 =
 * new HangUser();
 * 
 * u1.setUserName("Carlos");
 * 
 * try { UserDAO dao = new UserDAO(); boolean respossta =
 * dao.userNameAvailable(u1);
 * 
 * if (respossta == true) { System.out.println("Yeaa"); } else {
 * System.out.println("fudeu"); }
 * 
 * } catch (SQLException e) { e.printStackTrace(); } /* public static void
 * main(String[] args) {
 * 
 * try { UserDAO uDAO = new UserDAO();
 * 
 * ArrayList<HangUser> top10List = uDAO.lisTop10Users();
 * 
 * for (HangUser hu : top10List) {
 * System.out.printf("hang user: %s Score %s \n",
 * hu.getUserName(),hu.getHighestScore()); } } catch (SQLException e) {
 * System.out.println(" Error: "); e.printStackTrace(); } }
 */

/*
 * public static void main(String[] args) { HangUser u1 = new HangUser();
 * u1.setUserName("Carlos");
 * 
 * UserDAO dao = new UserDAO(); try { HangUser hmU1 = dao.searchUserName(u1);
 * 
 * System.out.println(" Result 1: "+hmU1.getUserName());
 * System.out.println(" Result 1: "+hmU1.getLastScore());
 * System.out.println(" Result 1: "+hmU1.getHighestScore());
 * System.out.println(" Result 1: "+hmU1.getSumScore());
 * System.out.println(" Result 1: "+hmU1.getVictories());
 * System.out.println(" Result 1: "+hmU1.getDefeats());
 * 
 * 
 * } catch (SQLException e) {
 * System.out.println(" there is Error during the search: ");
 * e.printStackTrace(); } }
 */

/*
 * public static void main(String[] args) { HangUser u1 = new HangUser();
 * u1.setName("Jaspion"); u1.setLastScore(900);
 * 
 * UserDAO udao = new UserDAO(); try { udao.updateLastScore(u1);
 * System.out.println("Valew!"); } catch (SQLException e) { e.printStackTrace();
 * System.out.println("deu ruin"); } }
 */
