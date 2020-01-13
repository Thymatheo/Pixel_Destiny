package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.LevelData;
import entity.MapSize;

public class DAOLevelData extends DAOEntity<LevelData> {

	public DAOLevelData(Connection connection) throws SQLException {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(LevelData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LevelData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LevelData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LevelData find(int idLevel) {
		LevelData data = new LevelData();
		try {
			final String sql = "{CALL get_level_data(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, idLevel);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				data.setLabel(resultSet.getString("level_label"));
				data.setLabelPlanet(resultSet.getString("planet_label"));
			}
			System.out.println(data.getLabel());
			System.out.println(data.getLabelPlanet());
			return data;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LevelData find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
