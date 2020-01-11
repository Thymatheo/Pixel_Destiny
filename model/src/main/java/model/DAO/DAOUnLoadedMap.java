package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Size;
import entity.UnLoadedMap;

public class DAOUnLoadedMap extends DAOEntity<UnLoadedMap> {


	public DAOUnLoadedMap(Connection connection) throws SQLException {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(UnLoadedMap entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UnLoadedMap entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UnLoadedMap entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UnLoadedMap find(int id) {
		return null;
	}

	@Override
	public UnLoadedMap find(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UnLoadedMap findAndFile(int idMap, Size size) {
		UnLoadedMap map = new UnLoadedMap(size.getLenght(),size.getWidth());
		try {
			final String sql = "{call get_a_map(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, idMap);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			while (resultSet.next()) {
				System.out.println("consol log : "+resultSet.getString("console_log")+" | coord x :"+ resultSet.getInt("coord_x")+" | coord y :"+  resultSet.getInt("coord_y"));
				map.setOnTheMap(resultSet.getString("console_log"), resultSet.getInt("coord_x"), resultSet.getInt("coord_y"));
			}
			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
