package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Size;

public class DAOSize extends DAOEntity<Size> {

	public DAOSize(Connection connection) throws SQLException {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Size entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Size entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Size entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Size find(int id) {
		Size size = new Size();
		try {
			final String sql = "{CALL get_map_size(?)}";
			System.out.println(sql);
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			System.out.println(call);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				System.out.println("x : "+resultSet.getInt("x")+" | y : " +resultSet.getInt("y"));
				size = new Size(resultSet.getInt("x"), resultSet.getInt("y"));
			}
			return size;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Size find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
