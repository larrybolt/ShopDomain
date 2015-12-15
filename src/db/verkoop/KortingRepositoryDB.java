package db.verkoop;

import java.io.InputStream;
import java.sql.*;
import java.util.List;

import db.BaseRepositoryDB;
import domain.korting.Korting;
import domain.korting.ProductAbsoluutKorting;
import domain.korting.ProductRelativeKorting;
import domain.korting.TotaalAbsoluutKorting;
import domain.korting.TotaalRelatiefKorting;

public class KortingRepositoryDB extends BaseRepositoryDB implements KortingRepository {

	public KortingRepositoryDB(InputStream resourceAsStream) {
        super("kortingen", resourceAsStream);
	}

	@Override
	public Korting get(String code) {
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("SELECT * FROM %s WHERE code = ?", this.getTable())
            );
            statement.setString(1, code);
            ResultSet result = statement.executeQuery();
            result.next();
            switch (result.getString("type")) {
            case "totaalabsoluut":
            	return new TotaalAbsoluutKorting(code, result.getDouble("amount"));
            case "totaalrelatief":
            	return new TotaalRelatiefKorting(code, result.getDouble("amount"));
            case "productabsoluut":
            	return new ProductAbsoluutKorting(code, result.getDouble("amount"), result.getInt("productid"));
            case "productrelatief":
            	return new ProductRelativeKorting(code, result.getDouble("amount"), result.getInt("productid"));
            }
            throw new IllegalStateException("unknown data from database");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}

	@Override
	public List<Korting> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Korting korting) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Korting korting) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub

	}

}
