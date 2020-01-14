package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.MapSize;

public class DAOMapSize extends DAOEntity<MapSize> {

	public DAOMapSize(Connection connection) throws SQLException {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(MapSize entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MapSize entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MapSize entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MapSize find(int id) {
		MapSize size = new MapSize();
		try {
			final String sql = "{CALL get_map_size(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				size = new MapSize(resultSet.getInt("x"), resultSet.getInt("y"));
			}
			return size;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MapSize find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
